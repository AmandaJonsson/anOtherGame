package Model;

public class TheLostKitten{

    private Player[] playerList;
    private int currentTurn = 0;


    public TheLostKitten(int numberOfPlayers) {

        Model.Map map = new Model.Map();
        Model.Dice dice = new Model.Dice();

        playerList = new Player[numberOfPlayers];

    }



    public void addPlayer(Player player){

        for(int i = 0;i < playerList.length;i++){
            player = playerList[i];
        }

    }

    public void nextTurn(Player player){

        if(player.getSkipATurn()){
            player.doneSkippingTurn(); //-> was 'player.skipTurn = false', used a setter instead!
            return;

        }else if(++currentTurn >= playerList.length){
            currentTurn = 0;

        }


    }


}
