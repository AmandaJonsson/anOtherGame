package Model.Intefaces;

import Model.Player;

/**
 * Created by majanyberg on 2017-05-16.
 */
public interface ITheLostKitten {



    ISpace getRandomStartPosition();
    int changeTurn(int i);
    int isFirstTurn();
    Player[] getPlayers();

}
