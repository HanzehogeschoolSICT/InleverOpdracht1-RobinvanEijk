package Sorting_Opgave.Controller;

import Sorting_Opgave.Model.InsertionSorter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;

/**
 * Created by robin on 7-3-17.
 * Controller for the InsertionSort. This class performs the required actions for the user input in the InsertionSorter class.
 */
public class InsertionSortController {
    private InsertionSorter insertionSorter;

    /**
     * Constructs new InsertionSortController and a new insertionSorter.
     */
    public InsertionSortController(){
        insertionSorter = new InsertionSorter();
    }

    /**
     * Lets the sorter perform one step in the sorting algorithm and updates the barchart.
     * @param barChart
     */
    public void processOneStep(BarChart barChart){
        insertionSorter.processOneStep();
        getData(barChart);
    }

    /**
     * Lets the sorter sort the entire array and updates the barchart.
     * @param barChart
     */
    public void processEntireSort(BarChart barChart){
        Sorter sorter = new Sorter(barChart);
        sorter.start();
    }

    public BarChart getData(BarChart barChart){
        barChart.setData(FXCollections.observableArrayList(insertionSorter.returnData()));
        return barChart;
    }

    private class Sorter extends Thread {
        private  boolean running = true;
        private BarChart barChart;

        private Sorter(BarChart barChart){this.barChart = barChart; }

        @Override
        public void run() {
            while (!insertionSorter.isFinished()) {
                while (!running) {
                    yield();
                }

                insertionSorter.processOneStep();
                Platform.runLater(() -> {
                    getData(barChart);
                });


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
