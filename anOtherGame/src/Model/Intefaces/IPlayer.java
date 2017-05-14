package Model.Intefaces;


import Model.Space;

public interface IPlayer {
    boolean playerHasTurn();
    int getBalance();
    Space getPosition();
    String getName();
    void updatePosition(Space newPosition);
    void gotTramCard();
    void usedTramCard();
    boolean hasTramCard();
    void hasCat();
    void robbedByPickpocket();
    void increaseBalance(int value);
    void decreaseBalance(int value);
    void payTicket(int ticket);
    boolean getSkipATurn();
    void skipTurn();
    void doneSkippingTurn();
    void updateBudget(int value);

}
