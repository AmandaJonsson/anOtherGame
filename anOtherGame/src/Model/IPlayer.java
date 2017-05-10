package Model;


public interface IPlayer {
    boolean playerHasTurn();
    int getBalance();
    Spaces getPosition();
    String getName();
    void updatePosition(Spaces newPosition);
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
