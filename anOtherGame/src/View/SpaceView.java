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
import Model.Player;
import Model.Space;
import event.Event;
import event.EventBus;
import event.IEventHandler;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


public class SpaceView extends Circle {
    private String color;
    private ISpace space;
    private String defaultColor;
    private ISpace spaceClicked;
    private double defaultRadius;

    private boolean isAvailableForAMove;

    public SpaceView(ISpace space, String color) {
        this.color = color;
        defaultColor = color;
        this.setId("spaces");
        this.setFill(Paint.valueOf(color));
        this.setRadius(5);
        defaultRadius = 5;
        this.space=space;
        setMouseEvent();
        isAvailableForAMove = false;
    }

    public void setIsAvailAbleForAMove(boolean available){
        isAvailableForAMove = available;
    }

    public boolean getIsAvailableForAMove(){
        return isAvailableForAMove;
    }

    public void setDefaultColor(String newColor){
        defaultColor = newColor;
    }

    public String getDefaultColor(){
        return defaultColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        this.setFill(Paint.valueOf(color));
    }

    public double getDefaultRadius(){
        return defaultRadius;
    }

    public void setDefaultRadius(double radius){
        defaultRadius = radius;
    }

    public int getX(){
        return space.getX();
    }

    public int getY(){
        return space.getY();
    }

    public ISpace getSpaceClicked(){
        return spaceClicked;
    }

    public void setSpaceClicked(int x, int y){
        spaceClicked = new Space(x,y);
        System.out.println("hej:    " + spaceClicked.getX());
        EventBus.BUS.publish(new Event(Event.Tag.SPACE_CHOSEN, this));
    }

    public ISpace getLocationOfSpace(){
        return space;
    }

    //TODO THIS NO WORK PLEASE FEEEX!!

        private void setMouseEvent() {
        /*
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
            this.setOnMouseClicked(e->{
                this.setColor("Orange");
                this.setSpaceClicked(this.getX(),this.getY());
                System.out.println("klickad: " + this.getSpaceClicked().toString());
            });



        }
}
