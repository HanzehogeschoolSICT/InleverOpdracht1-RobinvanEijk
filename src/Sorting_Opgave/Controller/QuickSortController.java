package Sorting_Opgave.Controller;

import Sorting_Opgave.Model.QuickSorter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;

/**
 * Created by robin on 10-3-17.
 */
public class QuickSortController {
    private QuickSorter quickSorter;

    public QuickSortController(){
        quickSorter = new QuickSorter();
    }

    public void processOneStep(BarChart barChart){
        quickSorter.processOneStep();
        getData(barChart);
    }

    public void processEntireSort(BarChart barChart){
        SorterThread sorterThread = new SorterThread(barChart, quickSorter);
        sorterThread.start();
    }

    public BarChart getData(BarChart barChart){
        barChart.setData(FXCollections.observableArrayList(quickSorter.returnData()));
        return barChart;
    }
}
