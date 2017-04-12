package Objects;


public class Player {

    private String position;
    private boolean hasTramCard = false;
    private int budget = 5000;      //StartBudget is 5000 kr right?
    private boolean hasCat = false;

    public Player(String position, boolean hasTramCard, int budget){
        this.position = position;
        this.hasTramCard = hasTramCard;
        this.budget = budget;
    }

    public int getBudget(){
        return this.budget;
    }

    public int updateBudget(){
        return 0;                       ////ska skrivas
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

    public void hasCat(){
        hasCat = true;
    }




}
