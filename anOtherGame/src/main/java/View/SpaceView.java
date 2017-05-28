/**
 * @author Allex
 * Revised by: *name*
 * Responsibility: View for the spaces.
 * Used by: MapView
 * Uses: Ispace, IStation
 */

package View;

import Model.Intefaces.ISpace;
import Model.Space;
import event.Event;
import event.EventBus;
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
        EventBus.BUS.publish(new Event(Event.Tag.SPACE_CHOSEN, this));
    }

    public ISpace getLocationOfSpace(){
        return space;
    }

    //TODO THIS NO WORK PLEASE FEEEX!!

    private void setMouseEvent() {

        this.setOnMouseClicked(e->{
            this.setSpaceClicked(this.getX(),this.getY());
        });

        }
}
