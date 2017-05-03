package Design;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static javafx.geometry.VPos.CENTER;

/**
 * Created by Allex on 2017-04-06.
 */
public class MapView extends GridPane {

    private String map;
    public MapView(){
        map = this.getClass().getResource("../images/mapNoPlupps.png").toExternalForm();
        this.setStyle("-fx-background-image: url('"+map+"'); " +
                "-fx-background-position: center center;" +
                "-fx-background-repeat: stretch; " +
                "-fx-background-size: contain;" +
                "-fx-background-repeat: no-repeat;");

        //this.setStyle("-fx-background-color: aqua");
        this.setPrefSize(600,600);
        this.setMinSize(400,400);
        this.setMaxSize(900,900);
        createGrid();

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

    private void createGrid() {
        this.setGridLinesVisible(false);
        final int numCols = 100 ;
        final int numRows = 100 ;
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
}
