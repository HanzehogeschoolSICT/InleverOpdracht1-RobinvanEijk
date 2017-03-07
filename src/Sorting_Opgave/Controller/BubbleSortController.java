package Sorting_Opgave.Controller;

import Sorting_Opgave.Model.BubbleSorter;
import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;

/**
 * Created by robin on 3-3-17.
 * Controller for the Bubblesort. This class performs the required actions for the user input in the BubbleSorter class.
 */
public class BubbleSortController{
    private BubbleSorter bubbleSorter;

    /*constructs new BubbleSortController and creates a new BubbleSorter*/
    public BubbleSortController(){
        bubbleSorter = new BubbleSorter();
    }

    // Lets the BubbleSorter perform one step and updates the barchart.
    public void processOneStep(BarChart barChart){
        bubbleSorter.processOneStep();
        getData(barChart);
    }

    // Lets the sorter sort the entire array and updates the barchart.
    public void processEntireSort(BarChart barChart){
        bubbleSorter.processEntireSort();
        getData(barChart);
    }

    // Gets the newest data from the bubbleSorter and displays it in the bargraph.
    public BarChart getData(BarChart barChart){
        barChart.setData(FXCollections.observableArrayList(bubbleSorter.returnData()));
        return barChart;
    }
}
