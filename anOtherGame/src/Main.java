import Objects.Dice;
import Objects.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("/Design/start.fxml"));

        StackPane pane = new StackPane();
        primaryStage.setScene(new Scene(pane,1000,1000));
        pane.getChildren().add(new Map());

        primaryStage.show();
    }
    

    public static void main(String[] args) {
        launch(args);

        Dice rollTheDice = new Dice();

    }
}
