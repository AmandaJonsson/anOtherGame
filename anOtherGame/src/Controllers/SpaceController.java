package Controllers;

import Design.SpaceView;
import Objects.*;
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
        this.view = new SpaceView(this, "black");
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
                    if (space instanceof Station) {
                        //System.out.println(((Stations)space).getName());
                    }
                    space.getController().getView().setStyle("-fx-fill:GREEN;");
                }

            }
        });
    }

    public SpaceView getView() {
        return view;
    }

    public void setColor(String color) {
        view.setColor(color);
    }

    public void setRadius(int radius) {
        view.setRadius(radius);
    }
    public void addPath(Map map, Station station) {
        if(space.getEdge() != null ){
            space.getEdge().addEdge(new Edge(map, space, station, "BLACK"));
        }
        else {
            space.setEdge(new Edge(map, space, station, "BLACK"));
        }
        space.addAdjacentSpace(station);
    }
    public void addTramPath(Map map, Station station) {
        if(space.getEdge() != null ){
            space.getEdge().addEdge(new Edge(map, space, station, "RED"));
        }
        else {
            space.setEdge(new Edge(map, space, station, "RED"));
        }
        space.addAdjacentSpace(station);
    }
    public void addBoatPath(Map map, Station station) {
        if(space.getEdge() != null ){
            space.getEdge().addEdge(new Edge(map, space, station, "BLUE"));
        }
        else {
            space.setEdge(new Edge(map, space, station, "BLUE"));
        }
        space.addAdjacentSpace(station);
    }
}
