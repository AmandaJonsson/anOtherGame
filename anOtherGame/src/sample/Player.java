package sample;


public class Player {

    private String position;
    private boolean hasTramCard = false;
    private int budget = 5000;      //StartBudget is 5000 kr right?

    public Player(String position, boolean hasTramCard, int budget){
        this.position = position;
        this.hasTramCard = hasTramCard;
        this.budget = budget;
    }

    public int getBudget(){
        return this.budget;
    }

    public String getPosition(){
        return this.position;
    }

    public void setPosition(String newPosition){ //onödig när vi har den här i PlayerController?
        this.position = newPosition;

    }

    public void gotTramCard(){          //ska också ligga i  PlayerController?
        hasTramCard = true;
    }

    public void usedTramCard(){         //ska också ligga i PlayerController?
        hasTramCard = false;
    }




}
