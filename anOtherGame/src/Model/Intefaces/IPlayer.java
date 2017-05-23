package Model.Intefaces;


public interface IPlayer {
    boolean playerHasTurn();
    int getBalance();
    ISpace getPosition();
    String getName();
    void setPosition(ISpace newPosition);
    void updatePosition(ISpace newPosition);
    boolean gotTramCard();
    void usedTramCard();
    boolean hasTramCard();
    boolean hasCat();
    boolean setHasCat();
    boolean robbedByPickpocket();
    void increaseBalance(int value);
    void decreaseBalance(int value);
    void payTicket(int ticket);
    boolean getSkipATurn();
    void skipTurn();
    void doneSkippingTurn();
    int updateBudget();
    void setTurn();
    void setNotTurn();

}
