package Sorting_Opgave.Model;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;
import java.util.Random;

/**
 * Created by robin on 3-3-17.
 * Superclass for the sorters which creates and contains an array of integers.
 */
public class SuperSorter {
    public int[] array;
    public int length;
    public int index;

    /**
     * constructs the supersorter with an array in it.
     */
    public SuperSorter(){
        array = new int[10];
        for (int i = 0; i < 10; i++){
            Random generator = new Random();
            array[i] = generator.nextInt(9) + 1;
        }
        length = array.length;
    }

    /**
     * function to process one step. should be further implemented in the subclasses.
     */

    public void processOneStep(){}
    /**
     * returns true if the algorithm is finished. Should be overriden in the subclasses.
     * @return boolean.
     */
    public boolean isFinished() {return false;}

    /**
     * creates the data for the barchart and gives it the right color using the index and the isFinished method.
     * this function is overridden in the QuickSorter class.
     * @return
     */
    public XYChart.Series returnData() {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Unsorted list");
        for (int i = 0; i < length; i++) {
            XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
            if (i == index && !isFinished()) {
                // the index should be colored blue
                Platform.runLater(() -> {
                    value.getNode().setStyle("-fx-background-color: blue;");
                });
            } else if (isFinished()) {
                Platform.runLater(() -> {
                    //once done the values should be colored green.
                    value.getNode().setStyle("-fx-background-color: green;");
                });
            }
            series1.getData().add(value);
        }
        return series1;
    }
}
