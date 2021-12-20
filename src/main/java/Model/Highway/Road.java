package Model.Highway;

/// Road has 3 lanes

import java.util.Random;

public class Road {
    /// List of lanes
    public Lane[] road;
    public int[] roadThroughput;
    private Random probability = new Random();

    Road(int roadWidth) {
        road = new Lane[roadWidth];
        for (int i = 0; i < roadWidth; i++) road[i] = new Lane();
    }

    /// TODO
    public void generateNextFrame() {

    }

    /// TODO
    public void moveCarsNeighbourhoods(int laneIndex) {

    }
}
