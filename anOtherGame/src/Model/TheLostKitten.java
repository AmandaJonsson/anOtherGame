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
            Player player = new Player(nameOfPlayers.get(i), getRandomStartPosition(), 5000);
            addPlayer(player);
            System.out.println("Spelare: " + playerList[i].getName() + " Position: " +
                    playerList[i].getPosition() + " Budget: " + playerList[i].getBalance());
        }

    }

    public Spaces getRandomStartPosition(){

        Spaces start1 = new Spaces(95, 22);
        Spaces start2 = new Spaces(7, 14);
        ArrayList<Spaces> startpositions = new ArrayList<Spaces>();
        startpositions.add(start1);
        startpositions.add(start2);
        for (int i =0; i<startpositions.size();i++){
            System.out.println(startpositions.get(i));

        }
        Random r = new Random();
        int startPos = r.nextInt(2)+1;


        return startpositions.get(startPos);
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
