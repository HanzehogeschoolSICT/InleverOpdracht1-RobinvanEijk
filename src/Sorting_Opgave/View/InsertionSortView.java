package Sorting_Opgave.View;

import Sorting_Opgave.Controller.BubbleSortController;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by robin on 3-3-17.
 */
public class InsertionSortView extends View {
    public InsertionSortView(BubbleSortController bubbleSortController) {
        super.bubbleSortController = bubbleSortController;
        this.setText("InsertionSort");

        BarChart barChart = createBarchart();
        HBox hBox = createHBox();

        //Add the barchart to a vertical box with the buttons beneath it.
        VBox vBox = new VBox();
        vBox.getChildren().addAll(barChart,hBox);

        this.setContent(vBox);
    }

}
