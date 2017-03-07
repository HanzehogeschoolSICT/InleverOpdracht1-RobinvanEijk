package Sorting_Opgave.View;

import Sorting_Opgave.Controller.BubbleSortController;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by robin on 3-3-17.
 * Class which creates a tabView for the BubbleSort
 */
public class BubbleSortView extends View{
    private BubbleSortController bubbleSortController;
    private BarChart barChart;

    /**
     * Create a new BubbleSortView which displays a bargraph and has two buttons.
     */
    public BubbleSortView() {
        bubbleSortController = new BubbleSortController();
        this.setText("BubbleSort");

        //Create Barchart and the HBox with buttons
        this.barChart = createBarchart();
        bubbleSortController.getData(barChart);
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
                bubbleSortController.processEntireSort(barChart));
        Button oneStepBt = new Button("Perform 1 step");
        oneStepBt.setOnAction(event ->
                bubbleSortController.processOneStep(barChart));
        hBox.getChildren().addAll(startBt,oneStepBt);


        return hBox;
    }
}

