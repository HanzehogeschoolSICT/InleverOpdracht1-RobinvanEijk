package Sorting_Opgave.Model;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;

/**
 * Created by robin on 3-3-17.
 */
public class SuperModel {
    private ArrayList array = new ArrayList();

    public SuperModel(int length){
        for (int i = 0; i < length; i++){
            array.add(Math.ceil(Math.random() * 100));
        }
    }

    public XYChart.Series returnData() {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Unsorted list");
        for (int i = 0; i < array.size(); i++) {
            series1.getData().add(new XYChart.Data(Integer.toString(i+1),array.get(i)));
        }
        return series1;
    }
}
