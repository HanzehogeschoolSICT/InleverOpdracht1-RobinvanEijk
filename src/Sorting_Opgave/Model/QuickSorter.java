package Sorting_Opgave.Model;


import javafx.application.Platform;
import javafx.scene.chart.XYChart;
import java.util.concurrent.Semaphore;

/**
 * Created by robin on 10-3-17.
 * this Class has the quicksort algorithm implemented inside a thread.
 */
public class QuickSorter extends SuperSorter {
    private int length;
    private int indexLeft = 0;
    private int indexRight = 0;
    private boolean isFinished = false;
    private QuickSorterThread quickSorterThread;
    private static final Semaphore semaphore = new Semaphore(0);

    public QuickSorter(){
        super();
        this.length = array.length;
    }

    public void processOneStep(){
        if (quickSorterThread == null){
            quickSorterThread = new QuickSorterThread();
            quickSorterThread.start();
        } else {
            semaphore.release();
        }

    }

    /**
     * @return isFinished
     */
    public boolean isFinished(){
        return isFinished;
    }

    /**
     * Creates the bars for the barchart from the array.
     * And gives them their correct collour according to the index and isFinished()
     * @return XYChart.Series
     */
    @Override
    public XYChart.Series returnData() {
        XYChart.Series series1 = super.returnData();
        for (int i = 0; i < length; i++) {
            XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
            if (i == indexLeft && !isFinished() || i == indexRight && !isFinished()) {
                //the indexes should be blue
                Platform.runLater(() -> {
                    value.getNode().setStyle("-fx-background-color: blue;");
                });
            } else if (isFinished()){
                //once finished all values should be green.
                Platform.runLater(() -> {
                    value.getNode().setStyle("-fx-background-color: green;");
                });
            }
            series1.getData().add(value);
        }
        return series1;
    }

    /**
     * This class is a Thread which is able to run the quicksort algorithm.
     */
    private class QuickSorterThread extends Thread {

        @Override
        public void run() {
            try {
                //quicksort is executed recusively so all we have to do is call quicksort once and set the isfinished boolean to true
                quickSort(0, length - 1);
                isFinished = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * This is an implementation of the algorithm from http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
         *
         * I have made use of semaphores to be able to let the algorithm execute step by step.
         * Each time the indexes change i acquire a semaphore so that the indexes stay displayed until the next step unlocks the semaphore and makes it continue.
         * This takes away the potential of quicksort to be very fast however it does give the ability to sort of visualize the algorithm.
         * @param low
         * @param high
         * @throws InterruptedException
         */
        private void quickSort(int low, int high) throws InterruptedException {
            int i = low, j = high;
            // Get the pivot element from the middle of the list
            int pivot = array[low + (high-low)/2];
            indexLeft = i;
            indexRight = j;
            semaphore.acquire();

            // Divide into two lists
            while (i <= j) {
                // If the current value from the left list is smaller then the pivot
                // element then get the next element from the left list
                while (array[i] < pivot) {
                    i++;
                    indexLeft = i;
                    semaphore.acquire();
                }
                // If the current value from the right list is larger then the pivot
                // element then get the next element from the right list
                while (array[j] > pivot) {
                    j--;
                    indexRight = j;
                    semaphore.acquire();
                }

                if (i <= j) {
                    swap(i, j);
                    i++;
                    j--;
                    indexLeft = i;
                    indexRight = j;
                    semaphore.acquire();
                }
            }
            // Recursion
            if (low < j)
                quickSort(low, j);
            if (i < high)
                quickSort(i, high);
        }

        /**
         * swaps two values inside an array
         * @param i
         * @param j
         */
        private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

