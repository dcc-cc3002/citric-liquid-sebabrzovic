package cl.uchile.dcc.citricliquid.model.Controller;

import cl.uchile.dcc.citricliquid.model.Phases.Phase;
import cl.uchile.dcc.citricliquid.model.Units.Boss_Unit;
import cl.uchile.dcc.citricliquid.model.Units.Player;
import cl.uchile.dcc.citricliquid.model.Units.Wild;
import cl.uchile.dcc.citricliquid.model.board.*;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.Set;

public class Controller {
    private Phase phase;
    private Player player;
    private List<Player> listPlayers;
    private Panel panel;
    private List<Panel> listPanel;
    private int movesLeft;
    private Player winner = null;
    private int turn;
    private int chapter;

    private final PropertyChangeSupport NormaLevelListener= new normaLevelListener(this);
    private final PropertyChangeSupport atHomePanel= new PropertyChangeSupport(this);
    private final PropertyChangeSupport moreThanOnePlayer= new PropertyChangeSupport(this);
    private final PropertyChangeSupport moreThanOnePath= new PropertyChangeSupport(this);








    /**
     * @param phase set the phase we are
     */
    public void setPhase(Phase phase) {
        this.phase = phase;
        phase.setController(this);
    }
    /**
    Adding the player with its attributes
     */
    public Player addPlayer(String name, int hp, int atk, int def, int evd, @NotNull Ipanel panel, int Id) {
        Player player = new Player(name, hp, atk, def, evd);
        this.addplayerList(player);
        panel.addPlayer(player);
        player.setHomeId(Id);
        player.setCurrentPanel(panel);
        return player;
    }

    /**
     * Adding the player to the list that keeps the order for the game
     * Also creating a method to acces that list
     * @param Player1
     */
    public void addplayerList(Player Player1){
        this.listPlayers.add(Player1);
    }

    public List<Player> getListPlayers() {
        return listPlayers;
    }

    /**
     * Set and get the player that is currently playing
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Method that allows the player to change panel
     * @param player
     * @param panel
     */
    public void setPlayerPanel(Player player, Ipanel panel) {
        player.getCurrentPanel().getPlayers().remove(player);
        panel.addPlayer(player);
        player.setCurrentPanel(panel);


    }

    /**
     * Creating method that creats the wild units
     * @param name
     * @param hp
     * @param atk
     * @param def
     * @param evd
     * @return
     */
    public Boss_Unit addBossUnit(String name, int hp, int atk, int def, int evd) {
        return new Boss_Unit(name, hp, atk, def, evd);
    }

    public Wild addWildUnit(String name, int hp, int atk, int def, int evd) {
        return new Wild(name, hp, atk, def, evd);
    }

    /**
     * Method that creates all the type of panel with a repective aid
     * @param id
     * @return
     */
    public Bonus addBonusPanel(int id) {
        Bonus New_panel = new Bonus(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    public Boss addBossPanel(int id){
        Boss New_panel = new Boss(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    public Drop addDropPanel(int id){
        Drop New_panel = new Drop(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    public Encounter addEncounterPanel(int id){
        Encounter New_panel = new Encounter(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    public Home addHomePanel(int id){
        Home New_panel = new Home(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    public Neutral addNeutralPanel(int id){
        Neutral New_panel = new Neutral(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    /**
     * setting and getting the panels that are next to the current one
     */
    public Set<Panel> getNextPanels(Ipanel current_panel) {
        return current_panel.getNextPanels();
    }

    public void setNextPanel(@NotNull Ipanel current, Ipanel new_panel) {
        current.addNextPanel(new_panel);
    }

    /**
     * roll of the dice
     *
     */
    public int dice() {
        int dice = getPlayer().roll();
        return dice;
    }

    /**
     * set and get moves the player will have
     * @param movesLeft
     */
    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }

    public int getMovesLeft() {
        return movesLeft;
    }

    public void stopMoving(){
        phase.toActivateCardPhase();
    }

    /**
     * Here will be the methods in charge of moving the player in the 4 possiblr directions, Up, Down, Left, Right
     */
    public void moveDown(){ /** preguntar si vale la pena meter el if dentro de Movesleft phase*/
        this.setMovesLeft(getMovesLeft()-1);
        this.setPlayerPanel(this.getPlayer(), getPlayer().getCurrentPanel().getDown());
        if(movesLeft==0){
            stopMoving();/** crear listener*/
        }
        phase.toDecisionPhase();
    }

    public void moveUp(){
        this.setMovesLeft(getMovesLeft()-1);
        this.setPlayerPanel(this.getPlayer(), getPlayer().getCurrentPanel().getUp());
        if(movesLeft==0){
            stopMoving();
        }
        phase.toDecisionPhase();
    }
    public void moveRight(){
        this.setMovesLeft(getMovesLeft()-1);
        this.setPlayerPanel(this.getPlayer(), getPlayer().getCurrentPanel().getRight());
        if(movesLeft==0){
            stopMoving();
        }
        phase.toDecisionPhase();
    }
    public void moveLeft(){
        this.setMovesLeft(getMovesLeft()-1);
        this.setPlayerPanel(this.getPlayer(), getPlayer().getCurrentPanel().getLeft());
        if(movesLeft==0){
            stopMoving();
        }
        phase.toDecisionPhase();
    }




    public void onHomePanel(boolean value){
        setCanIMove(false);
    }

    public void setCanIMove(boolean iMove){
        player.setMovement(iMove);
    }

    public void areMoreSteps(boolean steps){
        player.setMovement(steps);
    }

    public void NewNormaLevel(int level){
        if (level==6){
            winner=getPlayer();
        }
    }




    /**
     * returns weather the player is ko or not
     * @return
     */
    public boolean is_KO(){
        return getPlayer().isKO();
    }


    /**
     * These method is use when the observer advices that a player
     * has NormaLevel=6
     * in that case this player will be the owner of the turn , thats why returns
     * the owner
     * @return the winner of the game
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * Acording to the var turn in the class
     * this method will extract the current player(owner
     * of the turn) from the list of Players
     * @return player owner of the turn
     */
    public void resetcurrentPlayer() {
        this.player = listPlayers.get((turn - 1) % listPlayers.size());
        player.addNormaLevelListener(NormaLevelListener);

    }


    /**
     *When a player cant do anithing alse
     * finishturn() sets the value of turn
     * in order to change the ower of the turn
     */
    public void finishTurn() {
        if (turn % listPlayers.size() == 0) {
            chapter++;
        }
        setMovesLeft(0);
        resetcurrentPlayer();
        turn++;
        player = getPlayer();
    }



    /**
     *
     * @return the current chapter
     */
    public int getChapter() {
        return chapter;
    }

    /**
     * When we want to change the NormaGoal for the owner
     * we use setNormaGoal
     * @param goal new NormaGoal
     */
    public void setNormaGoal(String goal) {
        getPlayer().setNormaGoal(goal);
    }

    /**
     * calcula el ataque efectuado por la unidad
     * @param unit Unidad que ataca
     * @return cantidad e ataque
     */
    public int attack(IUnit unit){
        return unit.attack();
    }


    /**
     * Metodo evadir, efectua la evasión de una unidad
     * @param attacker quien atacó
     * @param victim quien recibe el atque y decide evadir
     * @throws InvalidTransitionException en caso de no hacer una transicion correcta
     */
    public void evade(IUnit attacker,IUnit victim) throws InvalidTransitionException {
        int attack=attack(attacker);
        victim.evade(attack);
        afterEvadeOrDefend(attacker,victim);
    }

    /**
     * Metodo que efectua la efensa de una unidad
     * @param attacker quien ataca
     * @param victim quien decide defende
     * @throws InvalidTransitionException en caso de na transición incorrecta
     */
    public void defend(IUnit attacker, IUnit victim) throws InvalidTransitionException {
        int attack=attack(attacker);
        victim.defend(attack);
        afterEvadeOrDefend(attacker,victim);
    }

    /**
     * Luego de evadir o defender el oponente contrataca
     * y el dueño del turno termina su turno
     * @param attacker quien ataca
     * @param victim quien recibe el ataque
     * @throws InvalidTransitionException
     */
    public void afterEvadeOrDefend(IUnit attacker, IUnit victim) throws InvalidTransitionException {
        if(victim.isK_O()){
            setActualUnit(getOwner());
            setOponnent(nullPLayer);
            attacker.increaseStarsBy(victim);
            attacker.increaseVictoriesBy(victim);
            phase.toMovingPhase();
        }
        else if(!victim.equals(getOwner())){
            counterattack(victim,attacker);
        }
    }

    /**
     * Se efectua el contrataque del oponente
     * @param attacker quien decide contratacar
     * @param victim el dueño del turno
     */
    public void counterattack(IUnit attacker, IUnit victim){
        try {
            phase.toWaitFigthPhase(attacker,victim);
        } catch (InvalidTransitionException e) {
            e.printStackTrace();
        }
        tryToFight();
    }




}
