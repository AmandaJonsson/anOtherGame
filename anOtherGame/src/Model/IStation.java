package Model;


public interface IStation {

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

