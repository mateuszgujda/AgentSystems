package Model.Highway;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Pas sklada sie z 8353 kratek

public class Lane {
    private final int cellNumber = 8353;
    public CircularArrayList<Cell> lane;
    public int[] optionsThroughput;
    int exitLength = 40;
    int spaceBetweenExitAndEntry = 20;
    private int laneNumber;
    private int numberOfCarsOnLane;
    private int entryCounter = 0;
    private List<Integer> BaliceWjazd = IntStream.rangeClosed(0, 40).boxed().collect(Collectors.toList());
    private List<Integer> Balice2Wjazd = IntStream.rangeClosed(192, 232).boxed().collect(Collectors.toList());
    private List<Integer> BielanyWjazd = IntStream.rangeClosed(626, 666).boxed().collect(Collectors.toList());
    private List<Integer> TyniecWjazd = IntStream.rangeClosed(997, 1037).boxed().collect(Collectors.toList());
    private List<Integer> SkawinaWjazd = IntStream.rangeClosed(1478, 1518).boxed().collect(Collectors.toList());
    private List<Integer> PoludnieWjazd = IntStream.rangeClosed(2089, 2129).boxed().collect(Collectors.toList());
    private List<Integer> LagiewnikiWjazd = IntStream.rangeClosed(2360, 2400).boxed().collect(Collectors.toList());
    private List<Integer> WieliczkaWjazd = IntStream.rangeClosed(3136, 3176).boxed().collect(Collectors.toList());
    private List<Integer> BiezaznowWjazd = IntStream.rangeClosed(3580, 3620).boxed().collect(Collectors.toList());
    private List<Integer> PrzewozWjazd = IntStream.rangeClosed(3926, 3966).boxed().collect(Collectors.toList());
    private List<Integer> NowaHutaWjazd = IntStream.rangeClosed(4340, 4380).boxed().collect(Collectors.toList());
    private List<Integer> GrebalowWjazd = IntStream.rangeClosed(4873, 4913).boxed().collect(Collectors.toList());
    private List<Integer> MistrzejowiceWjazd = IntStream.rangeClosed(5486, 5526).boxed().collect(Collectors.toList());
    private List<Integer> WegrzceWjazd = IntStream.rangeClosed(6153, 6193).boxed().collect(Collectors.toList());
    private List<Integer> ZielonkiWjazd = IntStream.rangeClosed(6780, 6820).boxed().collect(Collectors.toList());
    private List<Integer> ModlnicaWjazd = IntStream.rangeClosed(7446, 7486).boxed().collect(Collectors.toList());
    private List<Integer> ModlniczkaWjazd = IntStream.rangeClosed(7753, 7793).boxed().collect(Collectors.toList());

    List<Integer> Exits = concatenate(BaliceWjazd, Balice2Wjazd, BielanyWjazd, TyniecWjazd, SkawinaWjazd,
            PoludnieWjazd, LagiewnikiWjazd, WieliczkaWjazd, BiezaznowWjazd, PrzewozWjazd, NowaHutaWjazd, GrebalowWjazd,
            MistrzejowiceWjazd, WegrzceWjazd, ZielonkiWjazd, ModlnicaWjazd, ModlniczkaWjazd);

    private List<Integer> BaliceWyjazd = IntStream.rangeClosed(60, 100).boxed().collect(Collectors.toList());
    private List<Integer> Balice2Wyjazd = IntStream.rangeClosed(252, 292).boxed().collect(Collectors.toList());
    private List<Integer> BielanyWyjazd = IntStream.rangeClosed(686, 726).boxed().collect(Collectors.toList());
    private List<Integer> TyniecWyjazd = IntStream.rangeClosed(1057, 1097).boxed().collect(Collectors.toList());
    private List<Integer> SkawinaWyjazd = IntStream.rangeClosed(1538, 1578).boxed().collect(Collectors.toList());
    private List<Integer> PoludnieWyjazd = IntStream.rangeClosed(2149, 2189).boxed().collect(Collectors.toList());
    private List<Integer> LagiewnikiWyjazd = IntStream.rangeClosed(2420, 2460).boxed().collect(Collectors.toList());
    private List<Integer> WieliczkaWyjazd = IntStream.rangeClosed(3196, 3236).boxed().collect(Collectors.toList());
    private List<Integer> BiezaznowWyjazd = IntStream.rangeClosed(3640, 3680).boxed().collect(Collectors.toList());
    private List<Integer> PrzewozWyjazd = IntStream.rangeClosed(3986, 4026).boxed().collect(Collectors.toList());
    private List<Integer> NowaHutaWyjazd = IntStream.rangeClosed(4400, 4440).boxed().collect(Collectors.toList());
    private List<Integer> GrebalowWyjazd = IntStream.rangeClosed(4933, 4973).boxed().collect(Collectors.toList());
    private List<Integer> MistrzejowiceWyjazd = IntStream.rangeClosed(5546, 5586).boxed().collect(Collectors.toList());
    private List<Integer> WegrzceWyjazd = IntStream.rangeClosed(6213, 6253).boxed().collect(Collectors.toList());
    private List<Integer> ZielonkiWyjazd = IntStream.rangeClosed(6840, 6880).boxed().collect(Collectors.toList());
    private List<Integer> ModlnicaWyjazd = IntStream.rangeClosed(7506, 7546).boxed().collect(Collectors.toList());
    private List<Integer> ModlniczkaWyjazd = IntStream.rangeClosed(7813, 7853).boxed().collect(Collectors.toList());

    List<Integer> Entries = concatenate(BaliceWyjazd, Balice2Wyjazd, BielanyWyjazd, TyniecWyjazd, SkawinaWyjazd,
            PoludnieWyjazd, LagiewnikiWyjazd, WieliczkaWyjazd, BiezaznowWyjazd, PrzewozWyjazd, NowaHutaWyjazd,
            GrebalowWyjazd, MistrzejowiceWyjazd, WegrzceWyjazd, ZielonkiWyjazd, ModlnicaWyjazd, ModlniczkaWyjazd);

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


    /// TODO
    void setupEntryOneWay() {

    }

    /// TODO
    void setupExitOneWay() {

    }

    /// TODO
    void setupEntryOtherWay() {

    }

    /// TODO
    void setupExitOtherWay() {

    }

    /// TODO
    void setupDisabled() {

    }

    /// TODO
    void setupNormal() {

    }

    /// TODO
    void calculateNextFrame(int laneIndex) {

    }

    /// TODO
    int moveVehiclesForward() {
        return 0;
    }

    /// TODO
    void enterCars() {

    }

}