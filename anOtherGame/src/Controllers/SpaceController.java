package Controllers;

import Design.SpaceView;
import Objects.*;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import sun.jvm.hotspot.memory.Space;

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
                if(space instanceof Station){
                    if (!((Station) space).isStart()) {
                        view.setStyle("-fx-fill:RED;");
                    }else view.setRadius(60);
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
                //hämtqa spacen ni klickade på
                //loopen bör använda dess lista adjecentspaces.
                for (Spaces space : space.getAdjacentSpaces()) {
                    if (space instanceof Station) {
                        if (!((Station) space).isStart()) {
                            space.getController().getView().setStyle("-fx-fill:GREEN;");
                        } else view.setStyle("-fx-border-color:GREEN;" +
                                "-fx-border-radius: 5px");
                    } else space.getController().getView().setStyle("-fx-fill:GREEN;");
                }

            }

        });

       /* view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(space instanceof Station){
                    System.out.println("Station");

                }

            }
        });
        */
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
                Image img = new Image("/images/redbergsplatsen-01.png");
                view.setFill(new ImagePattern(img));
            }
            else if(((Station) space).getName().equals("Lundby")) {
                Image img = new Image("/images/lundby-01.png");
                view.setFill(new ImagePattern(img));
            }
        }
    }
}
