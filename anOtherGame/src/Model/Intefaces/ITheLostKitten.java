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
    void setNewDecreasedBudget(int value);
    IMap getMap();
    void moveByBike(int resultFromDice);
    void moveByBoat(int diceroll);
    void moveByTram(int diceroll);
}
