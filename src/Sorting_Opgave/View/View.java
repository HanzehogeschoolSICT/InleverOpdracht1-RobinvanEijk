package Sorting_Opgave.View;

import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

/**
 * Created by robin on 3-3-17.
 * Superclass for creating tabviews with a Barchart and buttons in it for each sorting algorithm.
 */
public class View extends Tab {

    /**
     * creates a barchart in the way it should look
     * @return Barchart
     */
    public BarChart createBarchart(){
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Index");
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Value");

        final BarChart<String,Number> barChart = new BarChart<String,Number>(xAxis,yAxis);
        barChart.setHorizontalGridLinesVisible(false);barChart.setVerticalGridLinesVisible(false);barChart.setLegendVisible(false);

        return barChart;
    }

    /**
     * creates a HBox with its needed styling. Buttons should be added in the subclasses of view.
     * @return the created HBox
     */
    public HBox createHBox(){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(15.0);
        return hBox;
    }
}
