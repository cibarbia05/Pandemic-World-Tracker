package View;

import Model.ConnectionUtil;
import Model.Country;
import Model.DataProviderCountries;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class MainView {
    private Stage stage;
    private Scene scene;
    private static AnchorPane pane;
    private static List<Country> countryList;

    /*On instantiation, checks if there is internet connection, and if so gets all the data
     *from the API (https://coronavirus-19-api.herokuapp.com/countries) and adds it to the table*/
    public MainView() throws IOException{
        if(ConnectionUtil.netIsAvailable()) {
            createStageScenePane();
            DataProviderCountries dt = new DataProviderCountries();
            countryList  = DataProviderCountries.getCountryList();
            addTable();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.NONE, "Your internet connection is unstable, for a good experience wait for it to stabilize");
            alert.getDialogPane().getStylesheets().add("/View/Stylesheet.css");
            ButtonType alertButton = new ButtonType("Ok");
            alert.getButtonTypes().setAll(alertButton);
            alert.show();
        }
        stage.show();

    }
    /*Creates the stage, scene, and pane where the table will be placed*/
    private void createStageScenePane(){
        pane = new AnchorPane();
        scene = new Scene(pane,1490,990);
        scene.getStylesheets().addAll("/View/Stylesheet.css");
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Covid-19 Tracker");
    }
    public static List<Country> getCountryList() {
        return countryList;
    }

    /*Adds the table to the pane for it to be visible*/
    public static void addTable() {
        TableView tv = new TableView();
        pane.getChildren().add(tv.getPane());
    }

}
