package Sorting_Opgave.View;

import Sorting_Opgave.Controller.BubbleSortController;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

/**
 * Created by robin on 3-3-17.
 */
public class View extends Tab {
    public BubbleSortController bubbleSortController;

    /**
     * creates a barchart and adds data to it
     * @return Barchart
     */
    public BarChart createBarchart(){
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Index");
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Value");

        final BarChart<String,Number> barChart =
                new BarChart<String,Number>(xAxis,yAxis);
        barChart.setHorizontalGridLinesVisible(false);barChart.setVerticalGridLinesVisible(false);barChart.setLegendVisible(false);

        bubbleSortController.getData(barChart);

        return barChart;
    }

    /**
     * creates a HBox with 2 buttons in it, and adds the required action event to it.
     * @return the created HBox
     */
    public HBox createHBox(){
        HBox hBox = new HBox();
        Button startBt = new Button("Start");
        startBt.setOnAction(event ->
                bubbleSortController.processEntireSort());
        Button oneStepBt = new Button("+1 Step");
        oneStepBt.setOnAction(event ->
                bubbleSortController.processOneStep());
        hBox.getChildren().addAll(startBt,oneStepBt);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(15.0);

        return hBox;
    }
}
