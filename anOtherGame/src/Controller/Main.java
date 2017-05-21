package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage startStage) throws Exception{
        startStage.setTitle("The Lost Kitten");
        startStage.setScene(createScene(loadMainPane()));
        startStage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = (Pane) loader.load(getClass().getResource("/View/start.fxml"));
        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        return scene;
    }

    private Pane loadGamePane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane theLostPane = (Pane) loader.load(getClass().getResource("/View/TheLostPane.fxml"));
        return theLostPane;
    }

    public static void main(String[] args){
        launch(args);
    }
}
