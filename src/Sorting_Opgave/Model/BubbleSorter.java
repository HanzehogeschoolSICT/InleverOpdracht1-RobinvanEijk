package Sorting_Opgave.Model;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;

/**
 * Created by robin on 7-3-17.
 */
public class BubbleSorter extends SuperSorter {
    private int length;                 // length of the array
    private int index = 0;              // index keeps track of where in the array we are
    private boolean counting = false;   // If there has been a swap in values, this boolean is set to false so we know we have to loop again.
    private int stepsWithoutSwaps = 0;  // stepsWithoutSwaps is used to count how far in the array we have come without swapping integers

    public BubbleSorter(){
        super();
        length = array.length;
    }

    /**
     * performs a single step in the bubblesorting algorithm each time the +1 button is pressed. And updates the barchart
     */
    public void processOneStep(){
        //this algorithm is built using pseudocode from: https://en.wikipedia.org/wiki/Bubble_sort
        if (!isFinished()) {
            //check if the value after the current value is lower
            if (array[index] > array[index + 1]) {
                //if true we need to swap.
                counting = false;
                stepsWithoutSwaps = 0;

                //swap the two values.
                int swap = array[index];
                array[index] = array[index + 1];
                array[index + 1] = swap;
            } else {
                //if we start at index 0 and we dont have to swap we can start counting the amount of steps.
                if (!counting && index == 0)
                    counting = true;
                if (counting)
                    stepsWithoutSwaps++;
            }
            //After the current value has been checked we increment the pointer
            index++;
            //if the index is as high as the length of the array we start the loop again.
            if (index == this.length - 1)
                index = 0;
        } else {
            index = 0;
        }
    }

    /**
     * if the the amount of steps without a swap done is as large as the length of the array. this means all integers are sorted.
     * @return boolean
     */
    public boolean isFinished() {
        return stepsWithoutSwaps == this.length;
    }

    /**
     * Creates the bars for the barchart from the array.
     * And gives them their correct collour according to the index and isFinished()
     * @return XYChart.Series
     */
    public XYChart.Series returnData() {
        XYChart.Series series1 = super.returnData();
        for (int i = 0; i < length; i++) {
            XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
            if (i == index && !isFinished()) {
                Platform.runLater(() -> {
                        value.getNode().setStyle("-fx-background-color: blue;");
                });
            } else if (isFinished()) {
                Platform.runLater(() -> {
                    value.getNode().setStyle("-fx-background-color: green;");
                });
            }
            series1.getData().add(value);
        }
        return series1;
    }
}

