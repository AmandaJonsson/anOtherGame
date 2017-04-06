package Objects;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * Created by Allex on 2017-04-05.
 */
public class Path extends Step{


    public Path(int x, int y) {
        super(x,y);
        this.setFill(Paint.valueOf("RED"));
        this.setRadius(2);

        this.centerYProperty();
    }


}
