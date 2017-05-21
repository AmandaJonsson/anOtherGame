package Model.Intefaces;

import Model.Player;

import java.util.List;


public interface ITheLostKitten {
    ISpace getRandomStartPosition();
    List<IPlayer> getPlayers();
}
