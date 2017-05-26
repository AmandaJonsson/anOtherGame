
/**
 * @author: Maja
 * Revised by: *name*
 * Responsibility: Interface to TheLostKitten
 * Used by: MainController
 * Uses: IPlayer, IDice, IMap
 */

package Model.Intefaces;

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
    void moveByBoat(int diceroll);
    void moveByTram(int diceroll);
    void setSomeoneFoundCat();
    boolean getSomeoneFoundCat();
}
