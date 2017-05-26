/**
 * @author Maja, Mirandra, Amanda
 * Revised by:
 * Responsibility: Handles the logic behind the game.
 * Used by:
 * Uses: IMap, IDice, IPlayer, ISpace, IMarker, FindPath
 */



package Model;

import Model.Intefaces.*;
import event.Event;
import event.EventBus;
import event.IEventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TheLostKitten implements ITheLostKitten{
    IMap map;
    IDice dice;
    private List<IPlayer> playerList;
    private IPlayer activePlayer;
    private FindPath pathFinder;
    private static boolean someoneFoundCat;
    
    public TheLostKitten(List<IPlayer> nameOfPlayers) {
        map = new Map();
        dice = new Dice();
        playerList = nameOfPlayers;
        if(!nameOfPlayers.isEmpty()) {
            nameOfPlayers.get(0).setTurn();

            for (IPlayer player : nameOfPlayers) {
                player.setPosition(getRandomStartPosition());
            }
            activePlayer = nameOfPlayers.get(0);
        }
    }

    public List<IPlayer> getListOfPlayers(){
        return playerList;
    }

    public IMap getMap(){
        return map;
    }

    public IDice getDice(){
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


    public void setMarkerTurned() {
        IMarker mark = ((Station) getActivePlayer().getPosition()).getMarker();
        mark.setMarkerToTurned();
    }

    public boolean checkIfMarkerIsTurned(IMarker mark){
        if(mark.isMarkerTurned()==true){
            return true;
        }
        else {
            return false;
        }
    }

    public void setNewBudget() {
        IMarker mark = ((Station) getActivePlayer().getPosition()).getMarker();
        if (mark instanceof MoneyMarker) {
            System.out.println(((MoneyMarker) mark).getMarkerType() + " " + mark.getMarkerValue(mark));
            getActivePlayer().updateBudget();
            mark.setMarkerToTurned();
        }
        else if(mark instanceof OtherMarkers) {
            if (mark.equals(OtherMarkers.NoMoneyMarkers.CAT)) {
                System.out.println(((OtherMarkers) mark).getMarkerType());
                getActivePlayer().setHasCat();
                mark.setMarkerToTurned();

            } else if (mark.equals(OtherMarkers.NoMoneyMarkers.TRAMCARD)) {
                System.out.println(((OtherMarkers) mark).getMarkerType());
                getActivePlayer().gotTramCard();
                mark.setMarkerToTurned();

            } else if(mark.equals(OtherMarkers.NoMoneyMarkers.PICKPOCKET)){
                getActivePlayer().robbedByPickpocket();
                mark.setMarkerToTurned();


            }
        }
    }

    public void setSomeoneFoundCat(){
        this.someoneFoundCat = true;
    }

    public boolean getSomeoneFoundCat(){
        return this.someoneFoundCat;
    }

    public void setNewDecreasedBudget(int value){
        getActivePlayer().decreaseBalance(value);
    }

    public List<IPlayer> getPlayers(){
        return playerList;
    }

    public List<ISpace> moveByBike(){
        int resultFromDice = dice.roll();

        FindPath pathfinder = new FindPath();
        List<ISpace> list = pathfinder.findPotentialSpaces(resultFromDice, this.getActivePlayer().getPosition());

        System.out.println(getActivePlayer().getPosition());
        System.out.println(resultFromDice);
        System.out.println(list);

        return list;
    }

    public void moveByTram(int resultFromDice){


    }

    public void moveByBoat(int resultFromDice){

    }

    public void move(){
        System.out.println("NU är det spelare " + getActivePlayer().getName());
    }

    //----Event setters-------------
    public void getNextPlayer(){
        int indexInListOfPlayers = getListOfPlayers().indexOf(activePlayer);
        if(indexInListOfPlayers==playerList.size()-1) {
            activePlayer = playerList.get(0);
        }else {
            activePlayer = playerList.get(indexInListOfPlayers + 1);
        }
        EventBus.BUS.publish(new Event(Event.Tag.LOSTKITTEN_NEXT, activePlayer));
    }



}



