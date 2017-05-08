package Model;


import java.util.ArrayList;
import java.util.Random;

public class TheLostKitten{

    private Player[] playerList;
 //   private int currentTurn = 0;


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

    public int changeTurn(int i){

        if(i+1>=playerList.length){
            playerList[i].isTurn = false;
            playerList[0].isTurn = true;
            return 0;

        }else if(playerList[i+1].getSkipATurn()){
            playerList[i+1].doneSkippingTurn(); //-> was 'player.skipTurn = false', used a setter instead!
            return changeTurn(i+1);

        }else {
            playerList[i].isTurn = false;
            playerList[i+1].isTurn = true;
            return i+1;

        }


    }

    public int isFirstTurn(){
        Random randomPlayer = new Random();
        int playerNumber = randomPlayer.nextInt(playerList.length-1)+1;
        playerList[playerNumber].isTurn = true;

        return randomPlayer.nextInt(playerList.length-1)+1;
    }



    public Player[] getPlayers(){
        return playerList;
    }



}
