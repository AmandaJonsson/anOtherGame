package Model;


import Controller.PlayerPaneController;
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
    private List<IPlayer> playerList;
    private IPlayer activePlayer;

    static ArrayList<PlayerPaneController> listOfPlayerPanes;

    public TheLostKitten(List<IPlayer> nameOfPlayers, ArrayList<PlayerPaneController> playerPaneControllers) {
        listOfPlayerPanes=playerPaneControllers;

        map = new Map();
        dice = new Dice();
        playerList = nameOfPlayers;
        nameOfPlayers.get(0).setTurn();

        for(IPlayer player : nameOfPlayers){
            player.setPosition(getRandomStartPosition());
        }
        activePlayer = nameOfPlayers.get(0);
    }

    public List<IPlayer> getListOfPlayers(){
        return playerList;
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


    public void getNextPlayer(){
        int indexInListOfPlayers = getListOfPlayers().indexOf(activePlayer);
        if(indexInListOfPlayers==playerList.size()-1) {
            activePlayer = playerList.get(0);
        }else {
            activePlayer = playerList.get(indexInListOfPlayers + 1);
        }
    }

    public void setNewBudget() {
        Marker mark = ((Station) getActivePlayer().getPosition()).getMarker();
        if (mark instanceof MoneyMarker) {
            System.out.println(getActivePlayer().getName() + " " + getActivePlayer().getPosition() + " " + getActivePlayer().getBalance());
            System.out.println(((MoneyMarker) mark).getMarkerType() + " " + mark.getMarkerValue(mark));
            System.out.println(getActivePlayer().updateBudget());
        }
    }

    public void setBudgetLabel(){
        System.out.println(listOfPlayerPanes.get(0).budgetLabel.getText());

        for(int i =0; i<listOfPlayerPanes.size(); i++){
            System.out.println(listOfPlayerPanes.get(i).nameLabel.getText());
            if(listOfPlayerPanes.get(i).nameLabel.getText() == getActivePlayer().getName()){
                listOfPlayerPanes.get(i).budgetLabel.setText("Pengar:" + getActivePlayer().getBalance() + " kr");
                System.out.println(listOfPlayerPanes.get(0).budgetLabel.getText());


            }
        }

    }




    public List<IPlayer> getPlayers(){
        return playerList;
    }

    public void move(){
        System.out.println("NU är det spelare " + getActivePlayer().getName());
    }

}
