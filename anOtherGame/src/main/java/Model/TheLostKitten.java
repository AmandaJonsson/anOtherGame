/**
 * @author Maja, Mirandra, Amanda
 * Revised by: Everybody.
 * Responsibility: Handles the logic behind the game.
 * Used by:
 * Uses: IMap, IDice, IPlayer, ISpace, IMarker, FindPath
 */



package Model;

import Model.Interfaces.*;
import event.Event;
import event.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TheLostKitten implements ITheLostKitten{
    IMap map;
    IDice dice;
    private List<IPlayer> playerList;
    private IPlayer activePlayer;
    private boolean someoneFoundCat = false;
    private boolean TramCard = false;
    private boolean gotRobbed = false;

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
    @Override
    public List<IPlayer> getListOfPlayers(){
        return playerList;
    }
    @Override
    public IMap getMap(){
        return map;
    }
    @Override
    public IDice getDice(){
        return dice;
    }
    @Override
    public IPlayer getActivePlayer(){
        return activePlayer;
    }
    @Override
    public void setActivePlayer(IPlayer player){
        activePlayer = player;
    }
    @Override
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

    @Override
    public void setMarkerTurned() {
        if(getActivePlayer().getPosition() instanceof Station){
            Station station = (Station) getActivePlayer().getPosition();
            if(station.hasMarker() == true) {
                IMarker mark = station.getMarker();
                mark.setMarkerToTurned();
            }

        }

    }
    @Override
    public boolean checkIfMarkerIsTurned(IMarker mark){
        if(getActivePlayer().getPosition() instanceof Station){
            Station station = (Station) getActivePlayer().getPosition();
            if(station.hasMarker() == true) {
                if(mark.isMarkerTurned()==true){
                    return true;
                }
                else {
                    return false;
                }
            }

        }
        return false;

    }
    @Override
    public void setNewBudget() {
        IMarker mark = ((Station) getActivePlayer().getPosition()).getMarker();
        if (mark instanceof MoneyMarker) {
            getActivePlayer().updateBudget();
            mark.setMarkerToTurned();
        }
        else if(mark instanceof OtherMarkers) {
            if (mark.equals(OtherMarkers.NoMoneyMarkers.CAT)) {
                getActivePlayer().setHasCat();
                mark.setMarkerToTurned();

            } else if (mark.equals(OtherMarkers.NoMoneyMarkers.TRAMCARD)) {
                getActivePlayer().gotTramCard();
                mark.setMarkerToTurned();

            } else if(mark.equals(OtherMarkers.NoMoneyMarkers.PICKPOCKET)){
                getActivePlayer().robbedByPickpocket();
                mark.setMarkerToTurned();
            }
        }
    }
    @Override
    public void setSomeoneFoundCat(){
        this.someoneFoundCat = true;
    }
    @Override
    public boolean getSomeoneFoundCat(){
        return this.someoneFoundCat;
    }

    @Override
    public void setSomeoneFoundTramCard(){
        this.TramCard = true;
    }

    @Override
    public boolean getSomeoneGotRobbed() {
        return this.gotRobbed;
    }

    @Override
    public void setSomeoneGotRobbed() {
        this.gotRobbed = true;

    }
    @Override
    public boolean getSomeoneFoundTramCard(){
        return this.TramCard;
    }
    @Override
    public void setNewDecreasedBudget(int value){
        getActivePlayer().decreaseBalance(value);
    }
    @Override
    public List<IPlayer> getPlayers(){
        return playerList;
    }
    @Override
    public List<ISpace> moveByBike(){
        int resultFromDice = dice.roll();
        FindPath pathfinder = new FindPath();
        List<ISpace> list = pathfinder.findPotentialSpaces(resultFromDice, this.getActivePlayer().getPosition());
        return list;
    }
    @Override
    public List<IStation> moveByTram(){
        List<IStation> listOfPotentialStations = new ArrayList<IStation>();
        if(!(getActivePlayer().getPosition() instanceof IStation)){
            System.out.println("Du kan bara åka spårvagn ifrån en station din tratt!");
        }else{
            if(getActivePlayer().getBalance() < 3000){
                System.out.println("Spelare: " + getActivePlayer().toString() + " har inte råd att åka spårvagn");
            }else{
                getActivePlayer().decreaseBalance(3000);
                FindPath pathfinder = new FindPath();
                listOfPotentialStations = pathfinder.findPotentialStations((IStation) getActivePlayer().getPosition());
                }
            }
        return listOfPotentialStations;
    }

    //----Event setters-------------
    @Override
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



