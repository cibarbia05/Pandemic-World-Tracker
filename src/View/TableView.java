package View;

import Model.ConnectionUtil;
import Model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class TableView {
    private TableColumn imageCol;
    private TableColumn nameCol;
    private TableColumn casesCol;
    private TableColumn deathsCol;
    private TableColumn recoveredCol;
    private static AnchorPane pane;
    private static ObservableList<Country> observableList;
    private TextField searchByName;
    private static javafx.scene.control.TableView<Country> countryTableView;

    public AnchorPane getPane(){
        return pane;
    }
    /*On instantiation, creates a table with all the attributes of a country on five different countries*/
    public TableView() {
        pane = new AnchorPane();
        startTableCreation();
    }
    /*Checks if there is internet connection and if so creates the table*/
    private void startTableCreation(){
        if(ConnectionUtil.netIsAvailable()) {
            createTable();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.NONE, "Your internet connection is unstable, for a good experience wait for it to stabilize");
            alert.getDialogPane().getStylesheets().add("/View/Stylesheet.css");
            ButtonType alertButton = new ButtonType("Ok");
            alert.getButtonTypes().setAll(alertButton);
            alert.show();
        }
    }
    /*Initializes the observable and tableview lists, adds all countries to the lists, and creates a search bar ( to search for a country faster)*/
    private void createTable() {
        observableList = FXCollections.observableArrayList();
        countryTableView = new javafx.scene.control.TableView<>();
        countryTableView.setPrefSize(1500, 970);
        countryTableView.setId("table-view");
        countryTableView.setLayoutY(30);
        addTitlesToTableView();
        addToObservableList();
        createSearchByNameTextfield();
        setSearchByNameActions();
        addAPILabel();
        countryTableView.setItems(observableList);
    }
    /*Adds five columns to the tableview (flag,name,cases,deaths,recoveries)*/
    private void addTitlesToTableView() {
        int totalCols = 5;
        imageCol = new TableColumn("Flag");
        imageCol.setSortable(false);
        imageCol.setPrefWidth(1500 / totalCols);
        imageCol.setCellValueFactory(
                new PropertyValueFactory<Country, String>("flag")
        );
        nameCol = new TableColumn("Country");
        nameCol.setPrefWidth(1500 / totalCols);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Country, String>("Name")
        );

        casesCol = new TableColumn("Cases");
        casesCol.setPrefWidth(1500 / totalCols);
        casesCol.setCellValueFactory(
                new PropertyValueFactory<Country, String>("Cases")
        );

        deathsCol = new TableColumn("Deaths");
        deathsCol.setPrefWidth(1500 / totalCols);
        deathsCol.setCellValueFactory(
                new PropertyValueFactory<Country, String>("Deaths")
        );

        recoveredCol = new TableColumn("Recoveries");
        recoveredCol.setPrefWidth(1500 / totalCols);
        recoveredCol.setCellValueFactory(
                new PropertyValueFactory<Country, String>("Recoveries")
        );
        countryTableView.getColumns().addAll(imageCol, nameCol, casesCol, deathsCol, recoveredCol);
    }
    /*Creates a textfield for the user to search for a country*/
    private void createSearchByNameTextfield(){
        searchByName = new TextField();
        searchByName.setFocusTraversable(false);
        searchByName.setPromptText("Search by Name");
        searchByName.setLayoutX(80);
        searchByName.setLayoutY(2);
        searchByName.setPrefWidth(380);
        searchByName.setPrefHeight(20);
        pane.getChildren().add(searchByName);
    }
    /*Sets textfield actions so that when the user starts typing, it will start searching for the country*/
    private void setSearchByNameActions(){
        searchByName.setOnKeyTyped(event -> {
            System.out.println("HI");
            if(searchByName.getText().length()>1){
                countryTableView.getItems().stream().filter(item -> item.getName().toUpperCase().indexOf(searchByName.getText().toUpperCase())!=-1).findAny();
                countryTableView.getItems().stream()
                        .filter(item -> item.getName().toUpperCase().indexOf(searchByName.getText().toUpperCase())!=-1)
                        .findAny()
                        .ifPresent(item -> {
                            countryTableView.scrollTo(item);
                        });
            }
        });
    }
    /*Adds all countries from the countryList in MainView to the
     *observable list which is then transferred to the tableview (countryTableView)
     *to be made visible for the user
     */
    private void addToObservableList() {
        for (int i = 0; i < MainView.getCountryList().size(); i++) {
            observableList.add(MainView.getCountryList().get(i));
        }
        pane.getChildren().add(countryTableView);
    }
    /*Adds a label with a link to the API with the data for the user to see*/
    private void addAPILabel(){
        Label apiLabel = new Label("This table uses a Covid API. Link: https://coronavirus-19-api.herokuapp.com/countries");
        apiLabel.setLayoutX(950);
        apiLabel.setLayoutY(5);
        apiLabel.setId("api-label");
        pane.getChildren().add(apiLabel);
    }

}
