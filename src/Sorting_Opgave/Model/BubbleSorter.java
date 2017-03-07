package Sorting_Opgave.Model;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;

/**
 * Created by robin on 7-3-17.
 */
public class BubbleSorter extends SuperSorter {
    private boolean counting = false;   // keeps track if there has been a swap
    private int noSwaps = 0;            // noSwaps is used to count how far in the array we have come without swapping integers
    private int length;                 // length of the array
    private int pointer = 0;            // pointer keeps track of where in the array we are

    public BubbleSorter(){
        super();
        length = array.length;
    }

    /**
     * performs a single step in the bubblesorting algorithm each time the +1 button is pressed. And updates the barchart
     */
    public void processOneStep(){
        if (!isFinished()) {
            if (array[pointer] > array[pointer + 1]) {
                // there is a lower number after the number on this index so we need to swap.
                counting = false;
                noSwaps = 0;

                int swap = array[pointer];
                array[pointer] = array[pointer + 1];
                array[pointer + 1] = swap;
            } else {
                if (!counting && pointer == 0)
                    counting = true; // start counting, because we had a no-swap at index 0

                if (counting)
                    noSwaps++;
            }

            pointer++;
            if (pointer == this.length - 1)
                pointer = 0; // reset pointer to the start
        } else {
            pointer = 0;
        }
    }

    /**
     * if the the amount of noSwaps done is as large as the length of the array. this means all integers are sorted.
     * @return boolean
     */
    public boolean isFinished() {
        return noSwaps == this.length;
    }

    public void processEntireSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public XYChart.Series returnData() {
        XYChart.Series series1 = super.returnData();
        for (int i = 0; i < array.length; i++) {
            if (i == pointer && !isFinished()) {
                XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        value.getNode().setStyle("-fx-background-color: blue;");
                    }
                });
                series1.getData().add(value);
            } else {
                XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
                series1.getData().add(value);
            }

        }
        return series1;
    }
}

