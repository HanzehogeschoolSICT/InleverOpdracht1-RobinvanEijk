package Sorting_Opgave.Controller;

import Sorting_Opgave.View.BubbleSortView;
import Sorting_Opgave.View.InsertionSortView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * Created by robin on 3-3-17.
 * Class which launches the primarystage for the application
 */
public class SuperController extends Application {

    /**
     * This method can be called from a main method to run the Application.
     * @param String[] args
     */
    public static void startController(String[] args){ launch(args);}

    /**
     * Launches a Stage for the Application with in it a tabpane.
     * Each tab contains the view for a sorting algorithm
     * @param primarystage
     */
    public void start(Stage primarystage){
        primarystage.setTitle("Sorting examples");
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(new BubbleSortView(),new InsertionSortView());
        primarystage.setScene(new Scene(tabPane,600,500));
        primarystage.show();
    }
}
