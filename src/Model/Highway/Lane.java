package Model.Highway;

import Model.Settings;
import Model.Vehicles.Car;
import Model.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Lane contains of 8353 cells

public class Lane {
    public static int iterCounter = 0;
    private final int cellNumber = 8353;
    public CircularArrayList<Cell> lane;
    public int[][] carsFlow = new int[17][60];
    private int numberOfCarsOnLane;
    private int entryCounter = 0;
    private List<Integer> BaliceEntry = IntStream.rangeClosed(0, 40).boxed().collect(Collectors.toList());
    private List<Integer> Balice2Entry = IntStream.rangeClosed(192, 232).boxed().collect(Collectors.toList());
    private List<Integer> BielanyEntry = IntStream.rangeClosed(626, 666).boxed().collect(Collectors.toList());
    private List<Integer> TyniecEntry = IntStream.rangeClosed(997, 1037).boxed().collect(Collectors.toList());
    private List<Integer> SkawinaEntry = IntStream.rangeClosed(1478, 1518).boxed().collect(Collectors.toList());
    private List<Integer> PoludnieEntry = IntStream.rangeClosed(2089, 2129).boxed().collect(Collectors.toList());
    private List<Integer> LagiewnikiEntry = IntStream.rangeClosed(2360, 2400).boxed().collect(Collectors.toList());
    private List<Integer> WieliczkaEntry = IntStream.rangeClosed(3136, 3176).boxed().collect(Collectors.toList());
    private List<Integer> BiezaznowEntry = IntStream.rangeClosed(3580, 3620).boxed().collect(Collectors.toList());
    private List<Integer> PrzewozEntry = IntStream.rangeClosed(3926, 3966).boxed().collect(Collectors.toList());
    private List<Integer> NowaHutaEntry = IntStream.rangeClosed(4340, 4380).boxed().collect(Collectors.toList());
    private List<Integer> GrebalowEntry = IntStream.rangeClosed(4873, 4913).boxed().collect(Collectors.toList());
    private List<Integer> MistrzejowiceEntry = IntStream.rangeClosed(5486, 5526).boxed().collect(Collectors.toList());
    private List<Integer> WegrzceEntry = IntStream.rangeClosed(6153, 6193).boxed().collect(Collectors.toList());
    private List<Integer> ZielonkiEntry = IntStream.rangeClosed(6780, 6820).boxed().collect(Collectors.toList());
    private List<Integer> ModlnicaEntry = IntStream.rangeClosed(7446, 7486).boxed().collect(Collectors.toList());
    private List<Integer> ModlniczkaEntry = IntStream.rangeClosed(7753, 7793).boxed().collect(Collectors.toList());
    List<Integer> Exits = concatenate(BaliceEntry, Balice2Entry, BielanyEntry, TyniecEntry, SkawinaEntry,
            PoludnieEntry, LagiewnikiEntry, WieliczkaEntry, BiezaznowEntry, PrzewozEntry, NowaHutaEntry, GrebalowEntry,
            MistrzejowiceEntry, WegrzceEntry, ZielonkiEntry, ModlnicaEntry, ModlniczkaEntry);
    private List<Integer> BaliceExit = IntStream.rangeClosed(60, 100).boxed().collect(Collectors.toList());
    private List<Integer> Balice2Exit = IntStream.rangeClosed(252, 292).boxed().collect(Collectors.toList());
    private List<Integer> BielanyExit = IntStream.rangeClosed(686, 726).boxed().collect(Collectors.toList());
    private List<Integer> TyniecExit = IntStream.rangeClosed(1057, 1097).boxed().collect(Collectors.toList());
    private List<Integer> SkawinaExit = IntStream.rangeClosed(1538, 1578).boxed().collect(Collectors.toList());
    private List<Integer> PoludnieExit = IntStream.rangeClosed(2149, 2189).boxed().collect(Collectors.toList());
    private List<Integer> LagiewnikiExit = IntStream.rangeClosed(2420, 2460).boxed().collect(Collectors.toList());
    private List<Integer> WieliczkaExit = IntStream.rangeClosed(3196, 3236).boxed().collect(Collectors.toList());
    private List<Integer> BiezaznowExit = IntStream.rangeClosed(3640, 3680).boxed().collect(Collectors.toList());
    private List<Integer> PrzewozExit = IntStream.rangeClosed(3986, 4026).boxed().collect(Collectors.toList());
    private List<Integer> NowaHutaExit = IntStream.rangeClosed(4400, 4440).boxed().collect(Collectors.toList());
    private List<Integer> GrebalowExit = IntStream.rangeClosed(4933, 4973).boxed().collect(Collectors.toList());
    private List<Integer> MistrzejowiceExit = IntStream.rangeClosed(5546, 5586).boxed().collect(Collectors.toList());
    private List<Integer> WegrzceExit = IntStream.rangeClosed(6213, 6253).boxed().collect(Collectors.toList());
    private List<Integer> ZielonkiExit = IntStream.rangeClosed(6840, 6880).boxed().collect(Collectors.toList());
    private List<Integer> ModlnicaExit = IntStream.rangeClosed(7506, 7546).boxed().collect(Collectors.toList());
    private List<Integer> ModlniczkaExit = IntStream.rangeClosed(7813, 7853).boxed().collect(Collectors.toList());
    List<Integer> Entries = concatenate(BaliceExit, Balice2Exit, BielanyExit, TyniecExit, SkawinaExit,
            PoludnieExit, LagiewnikiExit, WieliczkaExit, BiezaznowExit, PrzewozExit, NowaHutaExit,
            GrebalowExit, MistrzejowiceExit, WegrzceExit, ZielonkiExit, ModlnicaExit, ModlniczkaExit);

    Lane() {
        lane = new CircularArrayList<>();
        for (int i = 0; i < cellNumber; i++) lane.add(new Cell());
    }

    public static <T> List<T> concatenate(List<T>... lists) {
        List<T> result = new ArrayList<>();

        for (List<T> l : lists)
            result.addAll(l);

        return result;
    }

    // Setup cell to entrance;
    void setupEntryOneWay() {
        for (Integer point : Entries) {
            lane.get(point).cellType = Cell.CellType.ENTRY;
        }
    }

    // Setup cell to exit
    void setupExitOneWay() {
        for (Integer point : Exits) {
            lane.get(point).cellType = Cell.CellType.EXIT;
        }
    }

    void setupEntryOtherWay() {
        for (Integer point : Exits) {
            lane.get(point).cellType = Cell.CellType.ENTRY;
        }
    }

    void setupExitOtherWay() {
        for (Integer point : Entries) {
            lane.get(point).cellType = Cell.CellType.EXIT;
        }
    }

    void setupDisabled() {
        for (int i = 0; i < cellNumber; i++) {
            if (Entries.contains(i)) {
                continue;
            } else if (Exits.contains(i)) {
                continue;
            } else {
                lane.get(i).cellType = Cell.CellType.DISABLED;
            }
        }
    }

    void setupNormal() {
        for (int i = 0; i < cellNumber; i++) {
            lane.get(i).cellType = Cell.CellType.NORMAL;
        }
    }

    void calculateNextFrame(int laneIndex) {
        for (Cell aLane : lane) {
            if (aLane.occupied) {
                Vehicle currentCar = aLane.vehicle;
                currentCar.calculateDistanceToNextFrontVehicle(laneIndex);

                if (laneIndex == 1) {
                    currentCar.decideAboutChangeLaneToLeft(laneIndex);
                    currentCar.numberOfCellsToOvertake -= currentCar.getVelocity();
                }
                if (laneIndex == 0 && currentCar.numberOfCellsToOvertake <= 0 || laneIndex == 0 && currentCar.numberOfExits == 0) {
                    currentCar.decideAboutChangeLaneToRight(laneIndex);
                }
                if (laneIndex == 0)
                    currentCar.numberOfCellsToOvertake -= currentCar.getVelocity();
                if (laneIndex == 2 && currentCar.hasEntered) {
                    currentCar.decideAboutEnter();
                }


            }
        }
        for (Cell aLane : lane) {
            if (aLane.occupied) {
                Vehicle currentCar = aLane.vehicle;
                if (laneIndex == 2 && currentCar.hasEntered) {
                    currentCar.enterHighway();
                }
                currentCar.checkExits(laneIndex);
                int newIndex = currentCar.changeLane(laneIndex);
                if (!currentCar.disabled)
                    currentCar.calculateNextVelocity(newIndex);
            }
        }
    }


    int moveVehiclesForward() {

        numberOfCarsOnLane = 0;
        int segment;
        int previousSegment;
        int checkPoint;
        CircularArrayList<Cell> nextFrameLane = new CircularArrayList<>(cellNumber);
        for (int i = 0; i < cellNumber; i++) nextFrameLane.add(new Cell(lane.get(i).cellType));
        for (int i = 0; i < 17; ++i) {
            carsFlow[i][iterCounter % 60] = 0;
        }

        for (int i = 0; i < lane.size(); i++) {
            if (lane.get(i).occupied) {
                numberOfCarsOnLane += 1;
                segment = Highway.segmentsByCell.get(i);

                if (segment == 0)
                    previousSegment = 0;
                else
                    previousSegment = segment - 1;

                checkPoint = Highway.startOfSegments.get(segment) + Highway.segmentsLen.get(segment) / 2;
                Highway.carsOnSegment.set(segment, (Highway.carsOnSegment.get(segment) + 1));
                Vehicle currentCellVehicle = lane.get(i).vehicle;
                if (currentCellVehicle.getVelocity() + i > checkPoint && i <= checkPoint) {
                    carsFlow[segment][iterCounter % 60] += 1;
                }

                if (currentCellVehicle.getVelocity() + i >= lane.size()) {
                    nextFrameLane.get((currentCellVehicle.getVelocity() + i) - lane.size()).occupyCell(currentCellVehicle);
                } else {
                    nextFrameLane.get(i + currentCellVehicle.getVelocity()).occupyCell(currentCellVehicle);
                    if (nextFrameLane.get(i + currentCellVehicle.getVelocity()).cellType == Cell.CellType.DISABLED) {
                        nextFrameLane.get(i + currentCellVehicle.getVelocity()).freeCell();
                    }
                }
            }
        }
        lane = nextFrameLane;
        return numberOfCarsOnLane;
    }

    void enterCars() {
        int[] roadThroughput = Settings.throughput.clone();
        Random probability = new Random();
        for (int i = 0; i < cellNumber; i++) {

            if (lane.get(i).cellType == Cell.CellType.ENTRY) {
                if (!lane.get(i).occupied) {

                    if (probability.nextInt(61) - roadThroughput[entryCounter] < 0 && !lane.get(i).occupied) {
                        int maxVelocity;
                        int randomNumber = probability.nextInt(6);
                        if (randomNumber == 0) {
                            maxVelocity = Settings.carMaxVelocity;
                        } else {
                            maxVelocity = probability.nextInt(Settings.carMaxUpperVelocity - Settings.carMaxVelocity) + Settings.carMaxVelocity + 1;
                        }

                        Car toAdd = new Car(maxVelocity, probability.nextInt(maxVelocity < 3 ? maxVelocity : maxVelocity - 2) + 2, probability.nextInt(6) + 1);
                        toAdd.hasEntered = true;
                        toAdd.numberOfCellsToOvertake = 40;
                        lane.get(i).occupyCell(toAdd);
                    }

                }
                i += 40;
                entryCounter++;
            }
        }
        entryCounter = 0;
    }

}