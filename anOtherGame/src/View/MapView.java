package View;

import Model.ISpace;
import Model.Map;
import Model.Path;
import Model.Spaces;
import Model.Station;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.HashMap;

import static javafx.geometry.VPos.CENTER;

/**
 * Created by Allex on 2017-04-06.
 */
public class MapView extends GridPane {
    private Map mapp;
    private String map;

    public MapView(Map mapp) {
        map = this.getClass().getResource("../Resources/mapNoPlupps.png").toExternalForm();
        this.setStyle("-fx-background-image: url('" + map + "'); " +
                "-fx-background-position: center center;" +
                "-fx-background-repeat: stretch; " +
                "-fx-background-size: contain;" +
                "-fx-background-repeat: no-repeat;");

        //this.setStyle("-fx-background-color: aqua");
        this.setPrefSize(600, 600);
        this.setMinSize(400, 400);
        this.setMaxSize(900, 900);
        createGrid();
        this.mapp = mapp;
        addSpaces();

        //group.layoutYProperty().bind(this.layoutYProperty());
        //group.getChildren().add();
        //new Spaces("Nordstan", 100,100);

        //group.setTranslateY();

        this.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                setNewSize(newSceneWidth.doubleValue(), oldSceneWidth.doubleValue());
            }
        });
        this.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                setNewSize(newSceneHeight.doubleValue(), oldSceneHeight.doubleValue());
            }
        });
    }

    private void createGrid() {
        this.setGridLinesVisible(false);
        final int numCols = 100;
        final int numRows = 100;
        for (int i = 0; i < numCols; i++) {
           /* Label label = new Label();
            label.setText(Integer.toString(i));
            label.setMinWidth(20);
            //label.setPrefHeight(10);
            this.add(label, i, i);
            //this.add(i, i, 1);*/
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            colConst.setHalignment(HPos.CENTER);
            this.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
           /* Label label = new Label();
            label.setText(Integer.toString(i));
            label.setMinWidth(20);
            //label.setPrefHeight(10);
            this.add(label, 0, i);*/
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

    public void addSpaces() {
        ArrayList<String> list = new ArrayList<String>();
        for (ISpace space : mapp.getSpaces()) {
            //System.out.println(space.getController().getView());
            //System.out.println(space.getX() + " " + space.getY());
            SpaceView view = new SpaceView(space,"Black");
            if (space instanceof Station){
                if (((Station) space).getIsBoatStation()) {
                    view.setColor("Blue");
                }else if (((Station) space).getIsTramStation()) {
                    view.setColor("Red");
                }
                view.setRadius(10);
                if (((Station)space).getName().equals("Redbergsplatsen")){
                    view.setRadius(50);
                    Image img = new Image("/Resources/redbergsplatsen-01.png");
                    view.setFill(new ImagePattern(img));
                }else if (((Station)space).getName().equals("Lundby")){
                    view.setRadius(50);
                    Image img = new Image("/Resources/lundby-01.png");
                    view.setFill(new ImagePattern(img));
                }
                System.out.println("LOLOLOLOLOLOL");
                for (ISpace to : space.getAdjacentSpaces()){
                    if (!(list.contains(Integer.toString(space.getX()) + Integer.toString(space.getX()) + Integer.toString(to.getX()) + Integer.toString(to.getY())) || list.contains(Integer.toString(to.getX()) + Integer.toString(to.getX()) + Integer.toString(space.getX()) + Integer.toString(space.getY())))) {
                        if (to instanceof Station) {
                            calculatePath((Station) space, (Station) to, 0, 0);
                            list.add(Integer.toString(space.getX()) + Integer.toString(space.getX()) + Integer.toString(to.getX()) + Integer.toString(to.getY()));
                            System.out.println("WOOOHOOOOOO");
                        }
                    }
                }
            }
            this.add(view, space.getX(), space.getY());
        }
    }
    private boolean calculatePath(Station from, Station to, int x, int y) {
        String color;
        if (to.getIsTramStation() && from.getIsTramStation()) {
            color = "red";
        }else color = "black";
        //init
        if(x == 0){
            x = from.getX();
        }
        if(y == 0){
            y = from.getY();
        }
        //base case
        if (x == to.getX() && y== to.getY()){
            return true;
        }

        // adds steps for the bicycle path
        if (((from.getX() - x)%7 ==0 && x!=from.getX() && x!=to.getX()) || ((from.getY()-y)%7 == 0&& y!=from.getY() && y!=to.getY())){
            //space.addAdjacentSpace(prev);
            //prev.addAdjacentSpace(space);
        }else if (!(from.getX()-x < 1 && from.getX()-x >-1 && from.getY()-y <1 && from.getY()-y >-1) && !(to.getX()-x < 1 && to.getX()-x >-1 && to.getY()-y <1 && to.getY()-y >-1)) {
            this.add(new Path(color, x,y), x, y);
        }
        if (x < to.getX()){
            if (y==to.getY()){
                return calculatePath(from, to ,x+1, y);
            }
            if (y<to.getY()){
                return calculatePath(from, to, x+1,y+1);
            }
            if (y>to.getY()){
                return calculatePath(from, to, x+1,y-1);
            }
        }
        if (x > to.getX()){
            if (y==to.getY()){
                return calculatePath(from,to,x-1, y);
            }
            if (y<to.getY()){
                return calculatePath(from,to, x-1,y+1);
            }
            if (y>to.getY()){
                return calculatePath(from,to, x-1,y-1);
            }
        }
        if (x==to.getX()){
            if (y<to.getY()){
                return calculatePath(from,to, x,y+1);
            }
            if (y>to.getY()){
                return calculatePath(from,to, x,y-1);
            }
        }
        return false;
    }
}

