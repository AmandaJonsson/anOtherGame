/**
 * @author Allex
 * Revised by: *name*
 * Responsibility: View for the spaces.
 * Used by: MapView
 * Uses: Ispace, IStation
 */

package View;

import Model.Intefaces.ISpace;
import Model.Intefaces.IStation;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


public class SpaceView extends Circle {
    private String color;
    private ISpace space;
    public SpaceView(ISpace space, String color) {
        this.color = color;
        this.setId("spaces");
        this.setFill(Paint.valueOf(color));
        this.setRadius(5);
        this.space=space;
        setMouseEvent();

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        this.setFill(Paint.valueOf(color));
    }

    //TODO THIS NO WORK PLEASE FEEEX!!

        private void setMouseEvent() {
            this.setOnMouseEntered(new EventHandler<MouseEvent>
                    () {

                @Override
                public void handle(MouseEvent t) {
                    if (space instanceof IStation) {
                        if (!((IStation) space).isStart()) {
                            setStyle("-fx-fill:" + "Green" + ";");
                        } else {
                            setRadius(60);
                        }
                    } else setColor("RED");
                }

            });

            this.setOnMouseExited(new EventHandler<MouseEvent>
                    () {

                @Override
                public void handle(MouseEvent t) {
                    String color;
                    if (space instanceof IStation) {
                        if (!((IStation) space).isStart()) {
                            if (((IStation) space).getIsBoatStation()) {
                                color = "Blue";
                            }
                            if (((IStation) space).getIsTramStation()) {
                                color = "Red";
                            }else color="Black";
                            setColor(color);
                        } else setRadius(50);
                    } else {color="Black";
                    setColor(color);}
                }
            });


           /* this.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (space instanceof Station) {
                        if (!((Station) space).hasMarker()) {
                            space.getController().getView().setStyle("-fx-fill:BLACK;");
                            System.out.println("Has no marker");
                        } else {
                            Station s = (Station) space;
                            if (s.getMarker() instanceof MoneyMarker) {
                                System.out.println(((MoneyMarker) s.getMarker()).getMarkerType());

                            } else {
                                System.out.println(((OtherMarkers) s.getMarker()).getMarkerType());
                            }
                        }

                    }
                }
            });*/
    }
}
