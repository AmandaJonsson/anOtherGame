import Controllers.MapController;
import Controllers.PlayerController;
import Design.MapView;
import Objects.*;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Design/start.fxml"));
        primaryStage.setTitle("The Lost Kitten");
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        Map map = new Map();
        MapView mapView = new MapView();
        MapController controller = new MapController(map, mapView);
        pane.getChildren().add(mapView);
        pane.getChildren().add(root);

        primaryStage.show();

    }
    

    public static void main(String[] args) {
        launch(args);

        Dice rollTheDice = new Dice();


/*
        MoneyMarker m = new MoneyMarker(MoneyMarker.TypeOfMarkers.TOPAZ);
        MoneyMarker m1= new MoneyMarker(MoneyMarker.TypeOfMarkers.EMERALD);
        MoneyMarker m2 = new MoneyMarker(MoneyMarker.TypeOfMarkers.RUBY);
        MoneyMarker m3= new MoneyMarker(MoneyMarker.TypeOfMarkers.BLANK);

        m.Markervalue();
        m1.Markervalue();
        m2.Markervalue();
        m3.Markervalue();

        OtherMarkers n = new OtherMarkers(OtherMarkers.NoMoneyMarkers.CAT);
        OtherMarkers n1 = new OtherMarkers(OtherMarkers.NoMoneyMarkers.PICKPOCKET);
        n.Markervalue();
        n1.Markervalue();
*/

    }
}
