package Model.Intefaces;

import Model.Player;

import java.util.List;

/**
 * Created by majanyberg on 2017-05-16.
 */
public interface ITheLostKitten {
    ISpace getRandomStartPosition();
    List<IPlayer> getPlayers();
}
