package Sorting_Opgave.Model;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;

/**
 * Created by robin on 7-3-17.
 */
public class InsertionSorter extends SuperSorter {

    public InsertionSorter(){
        super();
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

    @Override
    public boolean isFinished() {
        return index == length;
    }
}

