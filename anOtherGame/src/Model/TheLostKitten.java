package Model;


import Model.Intefaces.IMap;
import Model.Intefaces.IPlayer;
import Model.Intefaces.ISpace;
import Model.Intefaces.ITheLostKitten;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TheLostKitten implements ITheLostKitten{
    IMap map;
    Dice dice;
    private Player[] playerList;
    private List<IPlayer> listOfPlayers;
    private IPlayer activePlayer;
 //   private int currentTurn = 0;

    public TheLostKitten(List<IPlayer> nameOfPlayers) {
        map = new Map();
        dice = new Dice();
        listOfPlayers = nameOfPlayers;
        nameOfPlayers.get(0).setTurn();

        for(IPlayer player : nameOfPlayers){
            player.setPosition(getRandomStartPosition());
        }
        activePlayer = nameOfPlayers.get(0);
    }

    public List<IPlayer> getListOfPlayers(){
        return listOfPlayers;
    }
    public IMap getMap(){
        return map;
    }

    public Dice getDice(){
        return dice;
    }

    public IPlayer getActivePlayer(){
        return activePlayer;
    }

    public void setActivePlayer(IPlayer player){
        activePlayer = player;
    }


    public ISpace getRandomStartPosition(){
        map.getStartPositions();
        ArrayList<ISpace> startpositions = new ArrayList<ISpace>();
        for (int i=0; i<map.getStartPositions().size(); i++){
            startpositions.add(map.getStartPositions().get(i));
        }
        Random r = new Random();
        int startPos = r.nextInt(2);
        return startpositions.get(startPos);
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
