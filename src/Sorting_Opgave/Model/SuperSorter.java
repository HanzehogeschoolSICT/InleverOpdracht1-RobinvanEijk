package Sorting_Opgave.Model;

import javafx.scene.chart.XYChart;
import java.util.Random;

/**
 * Created by robin on 3-3-17.
 * Superclass for the sorters which creates and contains an array of integers.
 */
public class SuperSorter {
    public int[] array;

    /*Constructs the SuperSorter*/
    public SuperSorter(){
        array = new int[10];
        for (int i = 0; i < 10; i++){
            Random generator = new Random();
            array[i] = generator.nextInt(9) + 1;
        }
    }

    /*Creates a start for the data in the bargraphs, should be further implemented in the subclasses of SuperSorter*/
    public XYChart.Series returnData() {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Unsorted list");
        return series1;
    }
}
