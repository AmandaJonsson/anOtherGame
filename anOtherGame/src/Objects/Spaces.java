package Objects;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;

import java.util.ArrayList;

public class Spaces extends Step {
    private String name;
    private ArrayList<Edge> adjacentSpaces;


    public Spaces(String name, int x, int y) {
        super(x,y);
        this.setId("spaces");
        this.setFill(Paint.valueOf("000"));
        this.setRadius(10);
        //this.setLayoutX(x);
        //this.setLayoutY(y);
        this.setTranslateX(-getRadius());
        this.setTranslateY(-getRadius());
        this.name = name;
        this.adjacentSpaces = new ArrayList<Edge>();
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
                System.out.println(name);
            }
        });
    }


    public void addAdjacentSpace(Spaces space){
        adjacentSpaces.add(new Edge(this, space));
        //createEdge(space);
    }

    private void createEdge(Spaces space) {
        Edge edge = new Edge(this, space);
    }

    public ArrayList<Edge> getAdjacentSpaces() {
        return adjacentSpaces;
    }
}
