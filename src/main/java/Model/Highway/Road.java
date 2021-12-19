package Model.Highway;

//Jezdnia sklada sie z 3 pasow

import java.util.Random;

public class Road {
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
