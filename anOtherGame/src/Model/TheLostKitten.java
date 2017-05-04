package Model;


import java.util.ArrayList;

public class TheLostKitten{

    private Player[] playerList;
    private int currentTurn = 0;


    public TheLostKitten(ArrayList<String> nameOfPlayers) {

        Model.Map map = new Model.Map();
        Model.Dice dice = new Model.Dice();


        playerList = new Player[nameOfPlayers.size()];

        for(int i = 0; i < playerList.length; i++){
            Player player = new Player(nameOfPlayers.get(i), null, 5000);
            addPlayer(player);
            System.out.println("Spelare: " + playerList[i].getName() + " Position: " +
                    playerList[i].getPosition() + " Budget: " + playerList[i].getBalance());
        }



    }


    public void addPlayer(Player player){

        for(int i = 0;i < playerList.length;i++){
            playerList[i] = player;

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
