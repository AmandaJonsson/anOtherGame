package View;

import Model.Intefaces.IPlayer;
import Model.Intefaces.ISpace;
import Model.Map;
import Model.Player;
import Model.Station;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

import static javafx.geometry.VPos.CENTER;

/**
 * Created by Allex on 2017-04-06.
 */
public class MapView extends StackPane {
    private Map mapp;
    private String map;
    GridPane stations;
    GridPane markers;
    GridPane players;

    public MapView(Map mapp) {
        map = this.getClass().getResource("../Resources/mapNoPlupps.png").toExternalForm();
        stations = new GridPane();
        stations.setMaxHeight(700);
        stations.setMaxWidth(700);
        stations.setPrefSize(700, 700);
        markers = new GridPane();
        markers.setMaxHeight(700);
        markers.setMaxWidth(700);
        markers.setPrefSize(700, 700);
        markers.setPickOnBounds(false);
        players = new GridPane();
        players.setMaxHeight(700);
        players.setMaxWidth(700);
        players.setPrefSize(700, 700);
        players.setPickOnBounds(false);
        this.setStyle("-fx-background-image: url('" + map + "'); " +
                "-fx-background-position: center center;" +
                "-fx-background-repeat: stretch; " +
                "-fx-background-size: contain;" +
                "-fx-background-repeat: no-repeat;");

        //this.setStyle("-fx-background-color: aqua");
        this.setPrefSize(400, 400);
        this.setMinSize(400, 400);
        this.setMaxSize(400, 400);
        this.getChildren().add(stations);
        this.getChildren().add(markers);
        createGrid(stations);
        createGrid(markers);
        this.setAlignment(Pos.BASELINE_LEFT);
        this.mapp = mapp;
        addSpaces();
        System.out.println(this.heightProperty());
    }

    private void createGrid(GridPane pane) {
        pane.setGridLinesVisible(false);
        final int numCols = 100;
        final int numRows = 100;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setMaxWidth(pane.getPrefWidth()/numCols);
            colConst.setHalignment(HPos.CENTER);
            colConst.setHgrow(Priority.ALWAYS);
            pane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setMaxHeight(pane.getPrefHeight()/numRows);
            rowConst.setValignment(CENTER);
            rowConst.setVgrow(Priority.ALWAYS);
            pane.getRowConstraints().add(rowConst);
        }

    }


    public void addSpaces() {
        ArrayList<String> list = new ArrayList<String>();
        for (ISpace space : mapp.getSpaces()) {
            //System.out.println(space.getController().getView());
            //System.out.println(space.getX() + " " + space.getY());
            SpaceView view = new SpaceView(space,"Black");
            if (space instanceof Station){
                if (((Station) space).hasMarker()){
                    Circle marker = new Circle();
                    marker.setRadius(5);
                    marker.setFill(Paint.valueOf("Purple"));
                    markers.add(marker, space.getX(), space.getY());
                }
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
            stations.add(view, space.getX(), space.getY());
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
            stations.add(new Path(color, x,y), x, y);
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

    public void setPlayerPosition(ArrayList<IPlayer> playerlist){
        players.getChildren().removeAll();
        for (IPlayer player : playerlist){
            Circle circle = new Circle();
            circle.setRadius(20);
            circle.setFill(Paint.valueOf("White"));
            if (!hasNode(players, player.getPosition().getX(), player.getPosition().getY())) {
                 players.add(circle, player.getPosition().getX(), player.getPosition().getY());
            }

        }

    }
    private boolean hasNode(GridPane gridpane, int col, int row) {
        for (Node node : gridpane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return true;
            }
        }
        return false;
    }
}

