package Sorting_Opgave.View;

import Sorting_Opgave.Controller.InsertionSortController;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by robin on 3-3-17.
 * Class which creates a tabView for the insertionSort
 */
public class InsertionSortView extends View {
    private InsertionSortController insertionSortController;
    private BarChart barChart;

    /**
     * Creates the view with a bargraph and the needed buttons
     */
    public InsertionSortView() {
        insertionSortController = new InsertionSortController();
        this.setText("InsertionSort");

        this.barChart = createBarchart();
        insertionSortController.getData(barChart);
        HBox hBox = createHBox();

        //Add the barchart to a vertical box with the buttons beneath it.
        VBox vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.getChildren().addAll(barChart,hBox);

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
                insertionSortController.processEntireSort(barChart));
        Button oneStepBt = new Button("Perform 1 step");
        oneStepBt.setOnAction(event ->
                insertionSortController.processOneStep(barChart));
        hBox.getChildren().addAll(startBt,oneStepBt);


        return hBox;
    }

}
