package Sorting_Opgave.Model;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;

/**
 * Created by robin on 7-3-17.
 */
public class InsertionSorter extends SuperSorter {
    private int length;         //the lenght of the array
    private int index = 0;    //where we are in the array (for the purpose of visualisation we start at index 0;

    public InsertionSorter(){
        super();
        length = array.length;
    }

    public void processOneStep(){
        //algorithm is built using pseudo code from: https://en.wikipedia.org/wiki/Insertion_sort
        if (!isFinished()) {
            //take the Value from the index
            int firstValue = array[index];
            //the index to compare with is the current index - 1
            int temporaryIndex = index - 1;
            //for each index lower to the current index check if it is bigger then the current index and place them one index up.
            while (temporaryIndex >= 0 && array[temporaryIndex] > firstValue) {
                array[temporaryIndex + 1] = array[temporaryIndex];
                temporaryIndex--;
            }
            //place the value from the first index to the last swapped index.
            array[temporaryIndex + 1] = firstValue;
            index++;
        }
    }



    public boolean isFinished() {
        return index == length;
    }

    public XYChart.Series returnData() {
        XYChart.Series series1 = super.returnData();
        for (int i = 0; i < length; i++) {
            if (i == index && !isFinished()) {
                // the index should be colored blue
                XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
                Platform.runLater(() -> {
                    value.getNode().setStyle("-fx-background-color: blue;");
                });
                series1.getData().add(value);
            } else if (!isFinished()) {
                // values other than the index should be the standard colour.
                XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
                series1.getData().add(value);
            } else {
                //once done the values should be completely green.
                XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
                Platform.runLater(() -> {
                    value.getNode().setStyle("-fx-background-color: green;");
                });
                series1.getData().add(value);
            }
        }
        return series1;
    }

}

