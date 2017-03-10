package Sorting_Opgave.Controller;

import Sorting_Opgave.Model.BubbleSorter;
import javafx.application.Platform;
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
        Sorter sorter = new Sorter(barChart);
        sorter.start();
    }

    // Gets the newest data from the bubbleSorter and displays it in the bargraph.
    public BarChart getData(BarChart barChart){
        barChart.setData(FXCollections.observableArrayList(bubbleSorter.returnData()));
        return barChart;
    }

    private class Sorter extends Thread {
        private  boolean running = true;
        private BarChart barChart;

        private Sorter(BarChart barChart){this.barChart = barChart; }

        @Override
        public void run() {
            while (!bubbleSorter.isFinished()) {
                while (!running) {
                    yield();
                }

                bubbleSorter.processOneStep();
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
