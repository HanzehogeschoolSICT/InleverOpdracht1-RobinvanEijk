package Sorting_Opgave.View;

import Sorting_Opgave.Controller.BubbleSortController;
import Sorting_Opgave.Controller.QuickSortController;
import Sorting_Opgave.Model.QuickSorter;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by robin on 10-3-17.
 */
public class Quicksortview extends View {
    private BarChart barChart;
    private QuickSortController quickSortController;

    public Quicksortview(){
        quickSortController = new QuickSortController();
        this.setText("QuickSort");

        //Create Barchart and the HBox with buttons
        this.barChart = createBarchart();
        quickSortController.getData(barChart);
        HBox hBox = createHBox();


        //Add the barchart to a vertical box with the buttons beneath it.
        VBox vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.getChildren().addAll(barChart,hBox);

        //add all content to this tab.
        this.setContent(vBox);
    }

    /**
     * creates a HBox with in it the buttons and their actionEvents.
     * @return HBox
     */
    public HBox createHBox(){
        HBox hBox = super.createHBox();
        Button startBt = new Button("Sort entirely");
        startBt.setOnAction(event ->
                quickSortController.processEntireSort(barChart));
        Button oneStepBt = new Button("Perform 1 step");
        oneStepBt.setOnAction(event ->
                quickSortController.processOneStep(barChart));
        hBox.getChildren().addAll(startBt,oneStepBt);


        return hBox;
    }
}
