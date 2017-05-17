package Model.Intefaces;


import Model.Marker;

public interface IStation extends ISpace {

    Marker getMarker();
    String getName();

    boolean hasMarker();
    void turnMarker();
    void setMarker(Marker marker);

    boolean getIsBoatStation();
    boolean getIsTramStation();

    void setTramStation(boolean tramStation);
    void setBoatStation(boolean boatStation);

    void setStart(boolean start);
    boolean isStart();
    String toString();

}

