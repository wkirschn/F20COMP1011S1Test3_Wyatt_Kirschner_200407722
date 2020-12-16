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
import java.text.DecimalFormat;
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

    public List <Athlete> objects = Arrays.asList(AthleteUtility.getAthleteFromJSON(new File("F20COMP1011S1Test3StudentVersion/src/Utilities/runners.json")));

    public ObservableList<Athlete> athleteList = FXCollections.observableList(objects);

    @FXML
    private void getAllAthletes()
    {
        System.out.println("getAllAthletes method called");

        tableView.setItems(athleteList);
        maleCheckBox.setSelected(true);
        femaleCheckBox.setSelected(true);

        idColumn.setSortType(TableColumn.SortType.ASCENDING);
        tableView.getSortOrder().add(idColumn);
        rowsReturnedLabel.setText("Rows Returned: " + String.valueOf(athleteList.size()));





    }

    @FXML
    private void checkBoxChanged()
    {


        if (maleCheckBox.isSelected() == true) {

            System.out.println("M - True");

            List<Athlete> sortedList = athleteList.stream().sorted(Comparator.comparing(Athlete::getGender)).collect(Collectors.toList());
                    System.out.println(sortedList);




            if (femaleCheckBox.isSelected() == true) {

                System.out.println("F - True");

                //tableView.setItems(getNumOfCustomersWithStream(athleteList, "male"));
                rowsReturnedLabel.setText("Rows Returned: " + String.valueOf(athleteList.size()));

            }

            else {

               rowsReturnedLabel.setText("Rows Returned: " + String.valueOf(getNumOfCustomersWithStream(athleteList, "male")));

            }

        }

        else if (femaleCheckBox.isSelected() == true) {

            if (maleCheckBox.isSelected() == true) {

                System.out.println("M - True");
                rowsReturnedLabel.setText("Rows Returned: " + String.valueOf(athleteList.size()));


            }

            else {

                rowsReturnedLabel.setText("Rows Returned: " + String.valueOf(getNumOfCustomersWithStream(athleteList, "female")));

            }
        }

        else {

            rowsReturnedLabel.setText("Rows Returned: 0");
        }

    }


    public static long getNumOfCustomersWithStream(ObservableList<Athlete> athletes, String gender)
    {
        return athletes.stream()
                .filter(athlete -> athlete.getGender().equals(gender)).count();
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

            maleCheckBox.setSelected(true);
            femaleCheckBox.setSelected(true);

        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }

        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->
        {
            try {
                System.out.println("Selecting");
                DecimalFormat df = new DecimalFormat("#.0");

                numOfRunsLabel.setText(String.valueOf(newValue.getNumberOfRuns()));
                avgDistanceLabel.setText(String.valueOf(df.format(newValue.getAvgDistance())));
                paceLabel.setText(String.valueOf(df.format(newValue.getAvgPace())));
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });





    }
}
