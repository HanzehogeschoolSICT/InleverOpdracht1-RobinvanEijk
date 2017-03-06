package Sorting_Opgave.Controller;

import Sorting_Opgave.Model.SuperModel;
import Sorting_Opgave.View.BubbleSortView;
import Sorting_Opgave.View.InsertionSortView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * Created by robin on 3-3-17.
 */
public class SuperController extends Application {

    public static void startController(String[] args){ launch(args);}

    public void start(Stage primarystage)throws Exception{
        primarystage.setTitle("Sorting examples");
        SuperModel superModel = new SuperModel(10); //the integer parameter contains the length of the arraylist
        BubbleSortController bubbleSortController = new BubbleSortController(superModel);
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(new BubbleSortView(bubbleSortController),new InsertionSortView(bubbleSortController));
        primarystage.setScene(new Scene(tabPane,600,500));
        primarystage.show();
    }
}
