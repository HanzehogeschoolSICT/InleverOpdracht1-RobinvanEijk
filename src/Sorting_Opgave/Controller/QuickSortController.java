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
        Sorter sorter = new Sorter(barChart);
        sorter.start();
    }

    public BarChart getData(BarChart barChart){
        barChart.setData(FXCollections.observableArrayList(quickSorter.returnData()));
        return barChart;
    }

    private class Sorter extends Thread {
        private  boolean running = true;
        private BarChart barChart;

        private Sorter(BarChart barChart){this.barChart = barChart; }

        @Override
        public void run() {
            while (!quickSorter.isFinished()) {
                while (!running) {
                    yield();
                }

                quickSorter.processOneStep();
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
