package Sorting_Opgave.Controller;

import Sorting_Opgave.Model.SuperSorter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;

/**
 * Created by robin on 10-3-17.
 */
public class SorterThread extends Thread {
    private  boolean running = true;
    private BarChart barChart;
    private SuperSorter sorter;

    public SorterThread(BarChart barChart,SuperSorter sorter){
        this.barChart = barChart;
        this.sorter = sorter;
    }

    @Override
    public void run() {
        while (!sorter.isFinished()) {
            while (!running) {
                yield();
            }

            sorter.processOneStep();
            Platform.runLater(() -> {
                barChart.setData(FXCollections.observableArrayList(sorter.returnData()));
            });


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
