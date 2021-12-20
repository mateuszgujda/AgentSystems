package Model.Highway;

//Autostrada - sklada się z dwoch jezdni

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Highway {
    /// Initiate empty list of number of cars per segment
    public static List<Integer> carsOnSegment = new ArrayList<>(Collections.nCopies(17, 0));
    
    /// Initiate lengths of segments
    public static List<Integer> segmentsLen = Arrays.asList(191, 434, 371, 481, 611, 271, 776, 454, 345, 413, 532, 612, 666, 626, 665, 306, 599);
    
    /// Empty list of segment start cell numbers
    public static ArrayList<Integer> startOfSegments = new ArrayList<>(Collections.nCopies(17, 0));
    
    /// List of segment names
    public static String[] segmentsNames = {"Balice", "Balice2", "Modlniczka", "Modlnica", "Zielonki", "Węgrzce", "Kr. Mistrzejowice", "Kr. Grębałów", "Kr. Nowa Huta", "Kr. Przewóz", "Kr. Bieżanów", "Kr. Wieliczka", "Kr. Łagiewniki", "Kr. Południe", "Kr. Skawina", "Kr. Tyniec", "Kr. Bielany"};
    static ArrayList<Integer> segmentsByCell = new ArrayList<>(8353);
    
    /// Roads on highway
    public Road[] roads;
    
    /// Number of all segments
    private int numberOfSegments = 17;

    public Highway(int highwayWidth) {
        roads = new Road[highwayWidth];
        for (int i = 0; i < highwayWidth; i++) roads[i] = new Road(3);
        setupSegments();
        setupSegmentsStarts();
    }

    /// TODO
    public static void resetNumbersOfCarOnSegments() {

    }

    /// TODO
    public void setupHighway() {

    }

    /// TODO
    private void setupSegments() {

    }

    /// TODO
    private void setupSegmentsStarts() {

    }
}
