package cl.uchile.dcc.citricliquid.model.Controller;

import cl.uchile.dcc.citricliquid.model.Listeners.HomePanelListener;
import cl.uchile.dcc.citricliquid.model.Listeners.moreThanOneNextStep;
import cl.uchile.dcc.citricliquid.model.Listeners.moreThanOnePlayer;
import cl.uchile.dcc.citricliquid.model.Listeners.normaLevelListener;
import cl.uchile.dcc.citricliquid.model.Phases.InvalidAction;
import cl.uchile.dcc.citricliquid.model.Phases.InvalidPhase;
import cl.uchile.dcc.citricliquid.model.Phases.Phase;
import cl.uchile.dcc.citricliquid.model.Units.Boss_Unit;
import cl.uchile.dcc.citricliquid.model.Units.IUnit;
import cl.uchile.dcc.citricliquid.model.Units.Player;
import cl.uchile.dcc.citricliquid.model.Units.Wild;
import cl.uchile.dcc.citricliquid.model.board.*;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Controller {
    private Phase phase;
    private Player player;
    private List<Player> listPlayers;
    private Panel panel;
    private List<Ipanel> listPanel;
    private int movesLeft;
    private Player winner = null;
    private int turn;
    private int chapter;
    private IUnit oponnent = null;
    private IUnit actualUnit = null;
    private int numberOfOpponents;

    private final PropertyChangeListener NormaLevelListener = new normaLevelListener(this);
    private final PropertyChangeListener atHomePanel = new HomePanelListener(this);
    private final PropertyChangeListener moreThanOnePlayer = new moreThanOnePlayer(this);
    private final PropertyChangeListener moreThanOnePath = new moreThanOneNextStep(this);


    /**
     * @param phase set the phase we are
     */
    public void setPhase(Phase phase) {
        this.phase = phase;
        phase.setController(this);
    }

    /**
     * Adding the player with its attributes
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
     * Also creating a method to access that list
     *
     * @param Player1
     */
    public void addplayerList(Player Player1) {
        this.listPlayers.add(Player1);
    }

    public List<Player> getListPlayers() {
        return listPlayers;
    }

    /**
     * Set and get the player that is currently playing
     *
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
     *
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
     * Method that creates all the type of panel with a respective id
     * @param id
     * @return
     */
    public Bonus addBonusPanel(int id) {
        Bonus New_panel = new Bonus(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    public Boss addBossPanel(int id) {
        Boss New_panel = new Boss(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    public Drop addDropPanel(int id) {
        Drop New_panel = new Drop(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    public Encounter addEncounterPanel(int id) {
        Encounter New_panel = new Encounter(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    public Home addHomePanel(int id) {
        Home New_panel = new Home(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    public Neutral addNeutralPanel(int id) {
        Neutral New_panel = new Neutral(id);
        listPanel.add(New_panel);
        return New_panel;
    }

    /**
     * setting and getting the panels that are next to the current one
     */
    public Set<Ipanel> getNextPanels(Ipanel current_panel) {
        return current_panel.getNextPanels();
    }

    public void setNextPanel(@NotNull Ipanel current, Ipanel new_panel) {
        current.addNextPanel(new_panel);
    }

    /**
     * roll of the dice
     */
    public int dice() {
        int dice = getPlayer().roll();
        return dice;
    }

    /**
     * set and get moves the player will have
     *
     * @param movesLeft
     */
    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }

    public int getMovesLeft() {
        return movesLeft;
    }

    /**
     * Method that will stop the players movement in case it needs to make a decision
     * @throws InvalidPhase
     */
    public void stopMoving() throws InvalidPhase {
        phase.toStopPhase();
    }

    /**
     * Here will be the methods in charge of moving the player in the 4 possiblr directions, Up, Down, Left, Right
     */
    public void moveDown() throws InvalidPhase {
        phase.toMovingPhase();
        this.setMovesLeft(getMovesLeft() - 1);
        this.setPlayerPanel(this.getPlayer(), getPlayer().getCurrentPanel().getDown());
        if (movesLeft == 0) {
            stopMoving();
        }
    }

    public void moveUp() throws InvalidPhase {
        phase.toMovingPhase();
        this.setMovesLeft(getMovesLeft() - 1);
        this.setPlayerPanel(this.getPlayer(), getPlayer().getCurrentPanel().getUp());
        if (movesLeft == 0) {
            stopMoving();
        }
    }

    public void moveRight() throws InvalidPhase {
        phase.toMovingPhase();
        this.setMovesLeft(getMovesLeft() - 1);
        this.setPlayerPanel(this.getPlayer(), getPlayer().getCurrentPanel().getRight());
        if (movesLeft == 0) {
            stopMoving();
        }
    }

    public void moveLeft() throws InvalidPhase {
        phase.toMovingPhase();
        this.setMovesLeft(getMovesLeft() - 1);
        this.setPlayerPanel(this.getPlayer(), getPlayer().getCurrentPanel().getLeft());
        if (movesLeft == 0) {
            stopMoving();
        }
    }

    /**
     * Once it is notified that it is at home it will stop moving
     * @param value
     */

    public void onHomePanel(boolean value) {
        setCanIMove(false);
    }

    /**
     * Method that set the posibility of movement
     * @param iMove
     */
    public void setCanIMove(boolean iMove) {
        if (iMove==false){
            this.movesLeft = 0;
        }
        player.setMovement(iMove);
    }

    /**
     * Boolean requiered for the listener
     * @param steps
     */
    public void areMoreSteps(boolean steps) {
        player.setMovement(steps);
    }

    /**
     * This method is use when the observer notifies that a player has NormaLevel=6*
     * Method requiered for the listener
     * @param level
     */
    public void NewNormaLevel(int level) {
        if (level == 6) {
            winner = getPlayer();
        }
    }



    /**
     * @return the winner of the game
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * Reset the current player after each turn
     */
    public void resetcurrentPlayer() {
        this.player = listPlayers.get((turn - 1) % listPlayers.size());
        player.addNormaLevelListener(NormaLevelListener);


    }


    /**
     * Method tha implements everything necessary after the turn has finished
     */
    public void finishTurn() {
        if (turn % listPlayers.size() == 0) {
            chapter++;
        }
        turn++;
        setMovesLeft(0);
        resetcurrentPlayer();
        player = getPlayer();
    }


    /**
     * @return the current chapter
     */
    public int getChapter() {
        return chapter;
    }

    /**
     * Set the normaGoal
     * @param goal new NormaGoal
     */
    public void setNormaGoal(String goal) {
        getPlayer().setNormaGoal(goal);
    }

    /**
     * Gets the final attack of a unit
     */
    public int attack(IUnit unit) {
        return unit.getFinalAttack();
    }


    /**
     * Methods for evading or defending the attack
     * @param attacker
     * @param victim
     */
    public void evade(IUnit attacker, IUnit victim) throws InvalidAction, InvalidPhase {
        int attack = attack(attacker);
        victim.esquivar(attack);

        afterAttack(attacker, victim);
    }
    public void defend(IUnit attacker, IUnit victim) throws InvalidAction, InvalidPhase {
        int attack = attack(attacker);
        victim.defense(attack);

        afterAttack(attacker, victim);
    }

    /**
     * Once the attack is finished, this methods verifies if the victim is ko and then it leads up the posible counterattack
     * @param attacker
     * @param victim
     */
    public void afterAttack(IUnit attacker, IUnit victim) throws InvalidPhase {
        if (victim.isKO()) {
            setActualUnit(getPlayer());
            setOponnent(null);
            victim.defeatByUnit(attacker);
            phase.toEndPhase();
        } else if (!victim.equals(getPlayer())) {
            counterattack(victim, attacker);
        }
    }

    /**
     * Sets the opponent for the battle
     * @param unit
     */
    private void setOponnent(IUnit unit) {
        this.oponnent = unit;
    }

    /**
     * Sets the unit for the battle
     * @param unit
     */
    private void setActualUnit(IUnit unit) {
        this.actualUnit = unit;
    }

    /**
     * CounterAttack method
     * @param attacker
     * @param victim
     * */
    public void counterattack(IUnit attacker, IUnit victim) {
        Battle(attacker, victim);
    }

    /**
     * Here the battle will be programed, but I was not able to do it because it is mainly done by the visual interface for there is a lot of inputs
     * such as weather the victim chooses to defend or evade
     * @param attacker
     * @param victim
     */

    public void Battle(IUnit attacker, IUnit victim) {
        int attack = attacker.getFinalAttack();
    }

    public void MoreThanOnePath() throws InvalidPhase {
        if (movesLeft > 0) {
            stopMoving();
            try {
                phase.toDecisionMovingPhase();
            } catch (InvalidPhase invalidPhase) {
                invalidPhase.printStackTrace();
            }
        }
    }

    public void MorePlayers(boolean newValue) throws InvalidPhase {
        if (!newValue) {
            stopMoving();
            List<Player> opponents = new ArrayList<>();
            opponents.addAll(getPlayer().getCurrentPanel().getPlayers());
            opponents.remove(getPlayer());
            numberOfOpponents = opponents.size();
            setOponnent(opponents.get(0));
            try {
                phase.toWaitBattlePhase();
            } catch (InvalidAction e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void chooseFight() throws InvalidPhase {
        stopMoving();
        try {
            phase.toWaitBattlePhase();
        } catch (InvalidAction e) {
            throw new RuntimeException(e);
        }
    }








    }
