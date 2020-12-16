/*
    Name:       Wyatt Kirschner
    Date:       12/16/20
    Purpose:    Test 3 - COMP1011
 */

package Controllers;

import Models.Athlete;
import Utilities.AthleteUtility;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import Models.Athlete;

public class AthleteViewController implements Initializable {

    @FXML
    private TableView<Athlete> tableView;

    @FXML
    private TableColumn<Athlete, Integer> idColumn;

    @FXML
    private TableColumn<Athlete, String> genderColumn;

    @FXML
    private TableColumn<Athlete, String> firstNameColumn;

    @FXML
    private TableColumn<Athlete, String> lastNameColumn;

    @FXML
    private CheckBox maleCheckBox;

    @FXML
    private CheckBox femaleCheckBox;

    @FXML
    private Label rowsReturnedLabel;

    @FXML
    private Label numOfRunsLabel;

    @FXML
    private Label avgDistanceLabel;

    @FXML
    private Label paceLabel;

    @FXML
    private void getAllAthletes()
    {
        System.out.println("getAllAthletes method called");
    }

    @FXML
    private void checkBoxChanged()
    {
    }

    @FXML
    private void getFastestFemale()
    {
        System.out.println("getFastestFemale method");
    }

    @FXML
    private void getFastestMale()
    {
        System.out.println("getFastestMale method");
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // This will be used to pass information into the TableView

        /*
          @FXML
    private TableColumn<Athlete, Integer> idColumn;

    @FXML
    private TableColumn<Athlete, String> genderColumn;

    @FXML
    private TableColumn<Athlete, String> firstNameColumn;

    @FXML
    private TableColumn<Athlete, String> lastNameColumn;
         */



        try{
            // Working!
            List <Athlete> objects = Arrays.asList(AthleteUtility.getAthleteFromJSON(new File("F20COMP1011S1Test3StudentVersion/src/Utilities/runners.json")));

            ObservableList<Athlete> athleteList = FXCollections.observableList(objects);

            idColumn.setCellValueFactory(new PropertyValueFactory< >("id"));
            genderColumn.setCellValueFactory(new PropertyValueFactory< >("gender"));
            firstNameColumn.setCellValueFactory(new PropertyValueFactory< >("firstName"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory< >("lastName"));
            tableView.setItems(athleteList);

            // Loads the idColumn being sorted by default

            idColumn.setSortType(TableColumn.SortType.ASCENDING);
            tableView.getSortOrder().add(idColumn);
            rowsReturnedLabel.setText("Rows Returned: " + String.valueOf(athleteList.size()));

        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }

    }
}
