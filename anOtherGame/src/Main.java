import Objects.Dice;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("/Design/start.fxml"));
        primaryStage.setTitle("The lost diamond");
        primaryStage.setScene(new Scene(root, 1000, 574));
        primaryStage.show();
    }
    

    public static void main(String[] args) {
        launch(args);

        Dice rollTheDice = new Dice();

    }
}
