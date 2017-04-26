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

        primaryStage.show();
    }
    

    public static void main(String[] args) {
        launch(args);

        Dice rollTheDice = new Dice();

        /*MoneyMarker [] topaz = new MoneyMarker[15];
        MoneyMarker [] emerald = new MoneyMarker[15];
        MoneyMarker [] ruby = new MoneyMarker[15];
        MoneyMarker [] blank = new MoneyMarker[15];

        for (int i=0; i<topaz.length;i++){
            topaz[i]=new MoneyMarker(MoneyMarker.TypeOfMarkers.TOPAZ);
            emerald[i]=new MoneyMarker(MoneyMarker.TypeOfMarkers.EMERALD);
            ruby[i]=new MoneyMarker(MoneyMarker.TypeOfMarkers.RUBY);
            blank[i]=new MoneyMarker(MoneyMarker.TypeOfMarkers.BLANK);
        }

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


        Player player1 = new Player("Amanda", new Spaces(7,14), false, false, 5000 );
        player1.getBudget();
*/

    }
}
