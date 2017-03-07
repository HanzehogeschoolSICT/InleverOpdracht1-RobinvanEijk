package Sorting_Opgave.Model;

import javafx.scene.chart.XYChart;

/**
 * Created by robin on 7-3-17.
 */
public class InsertionSorter extends SuperSorter {
    public InsertionSorter(){
        super();
    }

    public void processOneStep(){System.out.print("+1 step");}

    public void processEntireSort(){}

    public XYChart.Series returnData() {
        XYChart.Series series1 = super.returnData();
        for (int i = 0; i < array.length; i++) {
            XYChart.Data<String, Integer> value = new XYChart.Data<>(i + 1 + "", array[i]);
            series1.getData().add(value);
        }
        return series1;
    }

}

