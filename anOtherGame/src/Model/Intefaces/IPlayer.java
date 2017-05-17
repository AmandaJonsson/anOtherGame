package Model.Intefaces;


public interface IPlayer {
    boolean playerHasTurn();
    int getBalance();
    ISpace getPosition();
    String getName();
    void setPosition(ISpace newPosition);
    void gotTramCard();
    void usedTramCard();
    boolean hasTramCard();
    boolean hasCat();
    void robbedByPickpocket();
    void increaseBalance(int value);
    void decreaseBalance(int value);
    void payTicket(int ticket);
    boolean getSkipATurn();
    void skipTurn();
    void doneSkippingTurn();
    void updateBudget();
    void setTurn();
    void setNotTurn();

}
