package Objects;


public class Player {

    public Spaces position;
    public boolean hasTramCard = false;
    public int budget = 5000;      //StartBudget is 5000 kr right?
    public boolean hasCat = false;


    public Player(Spaces position, boolean hasTramCard, int budget){
        this.position = position;
        this.hasTramCard = hasTramCard;
        this.budget = budget;
    }

    public int getBudget(){
        return this.budget;
    }

    public Spaces getPosition(){
        return this.position;
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
