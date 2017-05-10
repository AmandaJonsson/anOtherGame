package Controller;

import View.SpaceView;
import Model.*;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;


/**
 * Created by Allex on 2017-04-23.
 */
public class SpaceController {
    private Spaces space;
    private SpaceView view;
    private Marker marker;

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
                if(space instanceof Station) {
                    if (!((Station) space).isStart()) {
                        view.setStyle("-fx-fill:RED;");
                    } else {
                        view.setRadius(60);
                    }
                }
                else view.setStyle("-fx-fill:RED;");
            }

        });

        view.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                if (space instanceof Station) {
                    if (!((Station) space).isStart()) {
                        view.setStyle("-fx-fill:" + view.getColor() + ";");
                    } else view.setRadius(50);
                } else view.setStyle("-fx-fill:" + view.getColor() + ";");
            }
        });


        view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (ISpace space : space.getAdjacentSpaces()) {
                    if (space instanceof Station) {
                        if (!((Station) space).isStart()) {
                            space.getController().getView().setStyle("-fx-fill:GREEN;");
                        } else view.setStyle("-fx-border-color:GREEN;" +
                                "-fx-border-radius: 5px");
                    } else space.getController().getView().setStyle("-fx-fill:GREEN;");
                }
            }
        });

       view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(space instanceof Station){
                    if(!((Station) space).hasMarker()) {
                        space.getController().getView().setStyle("-fx-fill:BLACK;");
                        System.out.println("Has no marker");
                    } else {
                        Station s = (Station) space;
                        if(s.getMarker() instanceof MoneyMarker){
                            System.out.println(((MoneyMarker) s.getMarker()).getMarkerType());

                        } else{
                            System.out.println(((OtherMarkers) s.getMarker()).getMarkerType());
                        }
                    }

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

    public void setStart() {
        if (space instanceof Station) {
            ((Station) space).setStart(true);
            view.setRadius(50);
            if(((Station) space).getName().equals("Redbergsplatsen")) {
                Image img = new Image("/Resources/redbergsplatsen-01.png");
                view.setFill(new ImagePattern(img));
            }
            else if(((Station) space).getName().equals("Lundby")) {
                Image img = new Image("/Resources/lundby-01.png");
                view.setFill(new ImagePattern(img));
            }
        }
    }
}
