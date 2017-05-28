package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @author Maja
 * Revised by: Everybody
 * Responsibility: Starts the game by loading the start view.
 * Used by:
 * Uses: FXML-files: start and TheLostPane
 */

public class Main extends Application {



    @Override
    public void start(Stage startStage) throws Exception{
        startStage.setTitle("The Lost Kitten");
        startStage.setScene(createScene(loadMainPane()));
        startStage.show();
        startStage.setResizable(false);
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        return loader.load(getClass().getResource("/start.fxml"));
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        return scene;
    }


    public static void main(String[] args){
        launch(args);
    }
}
