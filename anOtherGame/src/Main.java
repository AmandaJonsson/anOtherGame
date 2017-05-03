import Controllers.MapController;
import Controllers.PlayerController;
import Design.MapView;
import Objects.*;
import javafx.application.Application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Design/theLostPane.fxml"));
        primaryStage.setTitle("The Lost Kitten");
        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);
        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        Map map = new Map();
        MapView mapView = new MapView();
        MapController controller = new MapController(map, mapView);
        Pane mapPlace = (AnchorPane)root.lookup("#mapPlace");
        VBox playerPlace = (VBox)root.lookup("#playerPlace");
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/Design/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/Design/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/Design/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/Design/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/Design/PlayerPane.fxml")));
        //mapPlace.getChildren().add(mapView);
        //pane.getChildren().add(mapView);
        pane.getChildren().add(root);
        AnchorPane.setTopAnchor(mapView, 0.0);
        AnchorPane.setLeftAnchor(mapView, 0.0);
        AnchorPane.setRightAnchor(mapView, 0.0);
        AnchorPane.setBottomAnchor(mapView, 0.0);
        mapPlace.getChildren().add(mapView);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);

        Dice rollTheDice = new Dice();


    }
}
