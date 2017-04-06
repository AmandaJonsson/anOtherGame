package Objects;


import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

import static javafx.geometry.VPos.CENTER;

public class Map extends GridPane {
    //private Pane map;
    Group group;
    private int size = 800;
    private String map;
    public Map(){
        map = this.getClass().getResource("../images/map.png").toExternalForm();
        this.setStyle("-fx-background-image: url('"+map+"'); " +
                "-fx-background-position: center center;" +
                "-fx-background-repeat: stretch; " +
                "-fx-background-size: contain;" +
                "-fx-background-repeat: no-repeat;");

        //this.setStyle("-fx-background-color: aqua");
        this.setPrefSize(900,900);
        this.setMinSize(this.getPrefWidth(),this.getPrefHeight());
        this.setMaxSize(this.getPrefWidth(),this.getPrefHeight());
        createGrid();
        addSpaces();

        //group.layoutYProperty().bind(this.layoutYProperty());
        //group.getChildren().add();
        //new Spaces("Nordstan", 100,100);

         //group.setTranslateY();

        this.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                setNewSize(newSceneWidth.doubleValue(), oldSceneWidth.doubleValue());
            }
        });
        this.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                setNewSize(newSceneHeight.doubleValue(), oldSceneHeight.doubleValue());
            }
        });
    }

    private void addSpaces() {
        Stations nordstan = new Stations("Nordstan", 55,30);
        Stations chalmers = new Stations("Chalmers", 59,70);
        Stations jarntorget = new Stations("Järntorget", 39,50);
        Stations olskroken = new Stations("Olskroken", 95,10);
        nordstan.addAdjacentSpace(chalmers);
        nordstan.addAdjacentSpace(jarntorget);
        chalmers.addAdjacentSpace(olskroken);
        //group = new Group();
        this.add(nordstan, nordstan.getX(), nordstan.getY());
        this.add(chalmers, chalmers.getX(), chalmers.getY());
        this.add(jarntorget, jarntorget.getX(), jarntorget.getY());
        this.add(olskroken, olskroken.getX(), olskroken.getY());
        for (Edge edge : nordstan.getAdjacentSpaces()) {
            for (Step step : edge.getPath()){
                this.add(step, step.getX(), step.getY());
            }
        }
        for (Edge edge : chalmers.getAdjacentSpaces()) {
            for (Step step : edge.getPath()){
                this.add(step, step.getX(), step.getY());
            }
        }
        //group.getChildren().add();
        //this.getChildren().add(group);
    }

    private void createGrid() {
        this.setGridLinesVisible(false);
        final int numCols = 100 ;
        final int numRows = 100 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            colConst.setHalignment(HPos.CENTER);
            this.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            rowConst.setValignment(CENTER);
            this.getRowConstraints().add(rowConst);
        }

    }

    public void setNewSize(double newsize, double oldSize) {
        this.setHeight(newsize);
        this.setWidth(newsize);
//System.out.println(group.computeAreaInScreen());
        //group.setTranslateX(1/(getPrefWidth()- newsize));
       // group.setTranslateY(1/(oldSize-newsize));
        //group.resize(newsize/oldSize, newsize/oldSize);
    }
}
