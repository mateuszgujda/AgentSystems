package Model.Vehicles;

import Model.Highway.Cell;

public class Vehicle {
    /// Neighbourhood
    public Cell[][] neighbourhood;
    
    /// Maximum velocity car can reach
    public int maxVelocity;
    
    /// Car length
    public int carLength;
    
    /// Indicates if car has entered highway
    public boolean hasEntered = false;
    
    /// Indicates if car has been disabled
    public boolean disabled = false;
    
    /// Number of exits that car should pass before exiting highway
    public int numberOfExits;
    
    /// Car velocity
    int velocity;
    
    /// Distance to car in front
    private int distanceToNextCarInFront = 0;
    
    /// Distance to car behind
    private int distanceToNextCarInBack = 0;
    
    /// Indicates if car has changed lane
    private boolean hasChangedLane = false;
    
    /// Number of cells that car will try to pass other car
    /// before yielding.
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
