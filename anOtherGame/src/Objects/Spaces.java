package Objects;


import Controllers.MapController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;

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

                }

            }
        });
    }


    public void addAdjacentStation(Spaces space){
        edge = new Edge(this, space);
        adjacentSpaces.add(space);
        //createEdge(space);
    }

    public void addAdjacentSpace(Spaces space) {
        adjacentSpaces.add(space);
    }


    private void createEdge(Spaces space) {
        Edge edge = new Edge(this, space);
    }

    public ArrayList<Spaces> getAdjacentSpaces() {
        return adjacentSpaces;
    }


    public Edge getEdge() {
        return edge;
    }
}
