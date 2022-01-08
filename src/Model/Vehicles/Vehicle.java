package Model.Vehicles;

import Model.Highway.Cell;

import java.util.Random;

public class Vehicle {
    public Cell[][] neighbourhood;
    public int maxVelocity;
    public boolean hasEntered = false;
    public boolean disabled = false;
    public int numberOfExits;
    public int numberOfCellsToOvertake = 0;
    int velocity;
    private int distanceToNextCarInFront = 0;
    private int distanceToNextCarInBack = 0;
    private boolean hasChangedLane = false;
    private int numberOfCellsToPass = 40;
    private LaneToChange laneToChange = LaneToChange.NONE;


    Vehicle(int maxVelocity) {
        neighbourhood = new Cell[3][2 * maxVelocity + 1];
    }

    public void decreaseVelocity(int velocityChange) {
        velocity -= velocityChange;
    }

    public void increaseVelocity(int velocityChange) {
        velocity += velocityChange;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getDistanceToNextCarInFront() {
        return distanceToNextCarInFront;
    }

    public Vehicle calculateDistanceToNextFrontVehicle(int roadIndex) {
        for (int i = (neighbourhood[roadIndex].length / 2) + 1, j = 1; i < neighbourhood[roadIndex].length; i++) {
            if (!neighbourhood[roadIndex][i].occupied) {
                distanceToNextCarInFront = j;
                j++;
            } else {
                distanceToNextCarInFront = j;
                return neighbourhood[roadIndex][i].vehicle;
            }
        }
        distanceToNextCarInFront += 1;
        return null;
    }

    public boolean checkNeighbourhoodToChangeLane(int roadIndex) {
        int myNextPosition = this.maxVelocity + neighbourhood[roadIndex].length / 2;
        for (int i = 0; i < neighbourhood[roadIndex].length; i++) {
            if (neighbourhood[roadIndex][i].occupied) {
                return false;
            }
        }
        return true;
    }

    private Vehicle calculateDistanceToNextBackVehicle(int roadIndex) {
        for (int i = maxVelocity, j = 1; i >= 0; i--) {
            if (!neighbourhood[roadIndex][i].occupied) {
                distanceToNextCarInBack = j;
                j++;
            } else {
                distanceToNextCarInBack = j;
                return neighbourhood[roadIndex][i].vehicle;
            }
        }
        distanceToNextCarInBack += 1;
        return null;
    }

    public void decideAboutChangeLaneToRight(int roadIndex) {
        if (roadIndex == 2) {
            laneToChange = LaneToChange.NONE;
            return;
        }

        boolean canChangeLane = checkNeighbourhoodToChangeLane(roadIndex + 1);
        if (canChangeLane) {
            laneToChange = LaneToChange.RIGHT;
        } else {
            laneToChange = LaneToChange.NONE;
        }
    }


    public void decideAboutChangeLaneToLeft(int roadIndex) {
        if (roadIndex == 0 || roadIndex == 2) {
            laneToChange = LaneToChange.NONE;
            return;
        }
        Vehicle vehicleInFront = calculateDistanceToNextFrontVehicle(roadIndex);
        boolean canChangeLane = checkNeighbourhoodToChangeLane(roadIndex - 1);
        if (canChangeLane) {
            laneToChange = LaneToChange.LEFT;
        } else {
            laneToChange = LaneToChange.NONE;
        }
        if (vehicleInFront == null) {
            laneToChange = LaneToChange.NONE;
        }
    }


    public void checkExits(int laneIndex) {
        if (numberOfExits > 0 && neighbourhood[2][maxVelocity].cellType == Cell.CellType.EXIT) {
            if (numberOfCellsToPass == 40) {
                numberOfExits--;
                numberOfCellsToPass -= velocity;
            } else {
                numberOfCellsToPass -= velocity;
            }
        } else if (numberOfExits == 0 && neighbourhood[2][maxVelocity].cellType == Cell.CellType.EXIT) {
            if (laneIndex == 2)
                laneToChange = LaneToChange.NONE;
            else
                laneToChange = LaneToChange.RIGHT;
            decideAboutChangeLaneToRight(laneIndex);
        } else {
            numberOfCellsToPass = 40;
        }
    }

    public void enterHighway() {
        int cellsOfEnterWayLeft;
        if (laneToChange == LaneToChange.NONE) {
            cellsOfEnterWayLeft = 0;
            for (int i = (neighbourhood[2].length / 2) + 1; i < neighbourhood[2].length; i++) {
                if (neighbourhood[2][i].cellType == Cell.CellType.DISABLED) {
                    break;
                }
                cellsOfEnterWayLeft++;
            }
            if (cellsOfEnterWayLeft < velocity) {
                AvoidCollision(cellsOfEnterWayLeft);
                disabled = true;
            }

        }
        if (laneToChange == LaneToChange.LEFT) {
            disabled = false;
        }
    }

    public void decideAboutEnter() {
        boolean canEnter = checkNeighbourhoodToChangeLane(1);
        if (canEnter) {
            laneToChange = LaneToChange.LEFT;
        } else {
            laneToChange = LaneToChange.NONE;
        }


    }

    public void calculateNextVelocity(int roadIndex) {
        double probability = new Random().nextDouble();
        if (hasChangedLane) {
            calculateDistanceToNextFrontVehicle(roadIndex);
        }
        hasChangedLane = false;
        if (distanceToNextCarInFront <= velocity || (probability > 0.9 && velocity == maxVelocity)) {
            SlowDown();
        } else if ((probability < 0.3 || velocity <= maxVelocity - 2) && velocity + 1 != distanceToNextCarInFront) {
            SpeedUp();
        }
    }

    public int changeLane(int laneIndex) {
        if (laneToChange == LaneToChange.LEFT) {
            neighbourhood[laneIndex - 1][maxVelocity].occupyCell(this);
            neighbourhood[laneIndex][maxVelocity].freeCell();
            laneToChange = LaneToChange.NONE;
            hasChangedLane = true;
            if (hasEntered) {
                hasEntered = false;
                disabled = false;
            }
            numberOfCellsToOvertake = 12;
            return laneIndex - 1;
        } else if (laneToChange == LaneToChange.RIGHT) {
            neighbourhood[laneIndex][maxVelocity].freeCell();
            neighbourhood[laneIndex + 1][maxVelocity].occupyCell(this);
            laneToChange = LaneToChange.NONE;
            hasChangedLane = true;
            return laneIndex + 1;
        }

        return laneIndex;
    }

    private void SpeedUp() {
        velocity = Math.min(velocity + 1, maxVelocity);
    }

    private void SlowDown() {
        velocity = Math.max(Math.min(velocity - 1, distanceToNextCarInFront - 1), 0);
    }

    private void AvoidCollision(int distanceToCollision) {
        velocity = Math.max(Math.min(velocity - 1, distanceToCollision - 1), 0);
    }
}
