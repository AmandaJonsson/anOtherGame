package sample;


public class PlayerController {

    Player player;

    public PlayerController(Player player){
        this.player = player;
    }

    public void updatePosition(String position){
        player.setPosition(position);
    }

    public void updateBudget(){
        //öka budget
        //minska budget
    }
}
