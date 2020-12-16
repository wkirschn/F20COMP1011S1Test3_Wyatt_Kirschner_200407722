package Controllers;

import Models.Athlete;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class AthleteViewController {

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
}
