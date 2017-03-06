package Sorting_Opgave.Controller;

import Sorting_Opgave.Model.SuperModel;
import javafx.scene.chart.BarChart;

/**
 * Created by robin on 3-3-17.
 */
public class BubbleSortController {
    private SuperModel superModel;

    public BubbleSortController(SuperModel sm){
        superModel = sm;
    }

    public void processOneStep(){
        //todo process one single step.
        System.out.println("This button should process a single step in the sorting algoritm");
    }

    public void processEntireSort(){
        // todo process the entire sorting algoritm.
        System.out.println("This button should sort the entire list");
    }

    public BarChart getData(BarChart barChart){
        barChart.getData().addAll(superModel.returnData());
        return barChart;
    }
}
