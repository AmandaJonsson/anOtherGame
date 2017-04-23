package Objects;


public class Player {

    public Spaces position;
    public String name;
    public boolean hasTramCard = false;
    public int budget;      //StartBudget is 5000 kr right?
    public boolean hasCat = false;


    public Player(String name, Spaces position, boolean hasTramCard, boolean hasCat, int budget){
        this.name = name;
        this.position = position;
        this.hasTramCard = hasTramCard;
        this.budget = budget;
        this.hasCat = hasCat;
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
