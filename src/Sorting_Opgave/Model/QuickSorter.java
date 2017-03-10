package Sorting_Opgave.Model;


import javafx.application.Platform;
import javafx.scene.chart.XYChart;
import java.util.concurrent.Semaphore;

/**
 * Created by robin on 10-3-17.
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

    public boolean isFinished(){
        return isFinished;
    }

    public XYChart.Series returnData() {
        XYChart.Series series1 = super.returnData();
        for (int i = 0; i < length; i++) {
            if (i == indexLeft && !isFinished() || i == indexRight && !isFinished()) {
                //the indexes should be blue
                XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
                Platform.runLater(() -> {
                    value.getNode().setStyle("-fx-background-color: blue;");
                });
                series1.getData().add(value);
            } else if (!isFinished()) {
                // the remaining values should be the standard colour.
                XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
                series1.getData().add(value);
            } else {
                //once finished all values should be green.
                XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
                Platform.runLater(() -> {
                    value.getNode().setStyle("-fx-background-color: green;");
                });
                series1.getData().add(value);
            }
        }
        return series1;
    }

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


        //This is an implementation of the algorithm from http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html

        //I have made use of semaphores to be able to let the algorithm execute step by step.
        //Each time the indexes change i acquire a semaphore so that the indexes stay displayed until the next step unlocks the semaphore and makes it continue.
        //This takes away the potential of quicksort to be very fast however it does give the ability to sort of visualize the algorithm.
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

                // If we have found a values in the left list which is larger then
                // the pivot element and if we have found a value in the right list
                // which is smaller then the pivot element then we exchange the
                // values.
                // As we are done we can increase i and j
                if (i <= j) {
                    exchange(i, j);
                    i++;
                    indexLeft = i;
                    semaphore.acquire();
                    j--;
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

        private void exchange(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

