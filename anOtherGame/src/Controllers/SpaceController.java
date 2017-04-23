package Controllers;

import Design.SpaceView;
import Objects.Spaces;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

/**
 * Created by Allex on 2017-04-23.
 */
public class SpaceController {
    private Spaces space;
    private SpaceView view;

    public SpaceController(Spaces space) {
        this.space = space;
        this.view = new SpaceView(this, "red");
        setMouseEvent();
    }

    private void setMouseEvent() {
        view.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                view.setStyle("-fx-fill:RED;");
            }
        });

        view.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                view.setStyle("-fx-fill:" + view.getColor() + ";");
            }
        });
        view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                for(Spaces space : space.getAdjacentSpaces()) {
                    System.out.println(space.getName());
                    view.setFill(Paint.valueOf("green"));

                }

            }
        });
    }

    public SpaceView getView() {
        return view;
    }
}
