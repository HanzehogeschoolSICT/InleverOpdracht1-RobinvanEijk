package Sorting_Opgave.View;

import Sorting_Opgave.Controller.BubbleSortController;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by robin on 3-3-17.
 */
public class BubbleSortView extends View{
    /**
     * Create a new BubbleSortView which displays a bargraph and has two buttons.
     * @param bubbleSortController
     */
    public BubbleSortView(BubbleSortController bubbleSortController) {
        super.bubbleSortController = bubbleSortController;
        this.setText("BubbleSort");

        //Create Barchart and the HBox with buttons
        BarChart barChart = createBarchart();
        HBox hBox = createHBox();

        //Add the barchart to a vertical box with the buttons beneath it.
        VBox vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.getChildren().addAll(barChart,hBox);

        //add all content to this tab.
        this.setContent(vBox);
    }
}

