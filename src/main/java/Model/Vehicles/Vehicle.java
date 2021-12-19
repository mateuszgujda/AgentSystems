package Model.Vehicles;

import Model.Highway.Cell;

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

    /// TODO
    public Vehicle calculateDistanceToNextFrontVehicle(int roadIndex) {
        return null;
    }

    /// TODO
    private Vehicle calculateDistanceToNextBackVehicle(int roadIndex) {
        return null;
    }

    /// TODO
    public void decideAboutChangeLaneToRight(int roadIndex) {

    }

    /// TODO
    public void decideAboutChangeLaneToLeft(int roadIndex) {

    }


    /// TODO
    public void checkExits(int laneIndex) {

    }

    /// TODO
    public void enterHighway() {

    }

    /// TODO
    public void decideAboutEnter() {
    }

    /// TODO
    public void calculateNextVelocity(int roadIndex) {

    }

    /// TODO
    public int changeLane(int laneIndex) {
        return 0;
    }

    /// TODO
    private void SpeedUp() {
    }

    /// TODO
    private void SlowDown() {
    }

    /// TODO
    private void AvoidCollision(int distanceToCollision) {
    }
}