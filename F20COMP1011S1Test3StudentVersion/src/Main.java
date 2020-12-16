/*
    Name:       Wyatt Kirschner
    Date:       12/16/20
    Purpose:    Test 3 - COMP1011
 */

import Models.Athlete;
import com.google.gson.stream.JsonReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Utilities.AthleteUtility;

import java.io.File;
import java.io.FileReader;

public class Main extends Application {
    public static void main(String[] args) {


        // Using this to show what is in the JSON file
        AthleteUtility.getAthleteFromJSON(new File("F20COMP1011S1Test3StudentVersion/src/Utilities/runners.json"));
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/athletesView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(new Image("Views/icon.png"));
        root.getStylesheets().add("Views/stylesheet.css");
        stage.setTitle("Athlete Tracker Database - COMP1011");
        stage.show();
    }
}
