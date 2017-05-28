
/**
 * @author: Maja
 * Revised by: Everybody
 * Responsibility: Interface to TheLostKitten
 * Used by: MainController
 * Uses: IPlayer, IDice, IMap
 */

package Model.Interfaces;

import java.util.List;


public interface ITheLostKitten {

    List<IPlayer> getPlayers();
    IDice getDice();
    List<IPlayer> getListOfPlayers();
    IPlayer getActivePlayer();
    void setActivePlayer(IPlayer player);
    ISpace getRandomStartPosition();
    void getNextPlayer();
    void setNewBudget();
    void setMarkerTurned();
    boolean checkIfMarkerIsTurned(IMarker mark);
    void setNewDecreasedBudget(int value);
    IMap getMap();
    List<ISpace> moveByBike();
    List<IStation> moveByTram();
    void setSomeoneFoundCat();
    boolean getSomeoneFoundCat();
    boolean getSomeoneFoundTramCard();
    void setSomeoneFoundTramCard();
    boolean getSomeoneGotRobbed();
    void setSomeoneGotRobbed();

}
