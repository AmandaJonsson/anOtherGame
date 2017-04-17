package Objects;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class Spaces extends Step {
    private String name;
    private ArrayList<Spaces> adjacentSpaces;
    private Edge edge;


    public Spaces(String name, int x, int y) {
        super(name, x,y);
        this.setId("spaces");
        this.setFill(Paint.valueOf("000"));
        this.setRadius(10);
        this.adjacentSpaces = new ArrayList<Spaces>();
        this.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                setStyle("-fx-fill:RED;");
            }
        });

        this.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                setStyle("-fx-fill:#000;");
            }
        });
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                for(Spaces space : adjacentSpaces) {
                    System.out.println(space.getName());
                            space.setFill(Paint.valueOf("green"));

                }

            }
        });
    }


    public void addAdjacentStation(Spaces space){

        //createEdge(space);
    }

    public void addAdjacentSpace(Spaces space) {
        adjacentSpaces.add(space);
    }

    public ArrayList<Spaces> getAdjacentSpaces() {
        return adjacentSpaces;
    }


    public Edge getEdge() {
        return edge;
    }

    public void addPath(Map map, Stations station) {
        edge = new Edge(map, this, station);
        adjacentSpaces.add(station);
    }
}
