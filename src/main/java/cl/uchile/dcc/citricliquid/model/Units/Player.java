package cl.uchile.dcc.citricliquid.model.Units;

import cl.uchile.dcc.citricliquid.model.Phases.Phase;
import cl.uchile.dcc.citricliquid.model.board.Boss;
import cl.uchile.dcc.citricliquid.model.board.Ipanel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

public class Player extends AbstractUnit {
    private int normaLevel;
    private int victories;
    private int homePanel;
    private String NormaGoal; /** STARS OR WINS*/
    private Ipanel currentPanel = null;
    private boolean canImove;
    private boolean amIKO = false;

    private final PropertyChangeSupport NormaLevelListener= new PropertyChangeSupport(this);
    private final PropertyChangeSupport atHomePanel= new PropertyChangeSupport(this);
    private final PropertyChangeSupport moreThanOnePlayer= new PropertyChangeSupport(this);
    private final PropertyChangeSupport moreThanOnePath= new PropertyChangeSupport(this);



    /**
     * creates the player
     * @param name
     * @param hp
     * @param atk
     * @param def
     * @param evd
     */
    public Player(String name, int hp, int atk, int def, int evd){
        super(name, hp,atk, def, evd);
        victories = 1;
        normaLevel = 1;
        NormaGoal = "STARS";


    }


    /**
     * Returns this player's victory count.
     */
    public int getVictories() {
        return victories;
    }

    /**
     * Increases this player's star count by an amount.
     */
    public void increasevictoriesBy(final int amount) {
        victories += amount;
    }



    /**
     * Returns the current norma level.
     */
    public int getNormaLevel() {
        return normaLevel;
    }

    /**
     * Performs a norma clear action; the {@code norma} counter increases in 1.
     */
    public void normaClear() {
        normaLevel++;
        NormaLevelListener.firePropertyChange("New_Normalevel",normaLevel-1,normaLevel);
    }


    /**
     *Here we set the goal to pass the next Norma, weather its by stars or wins
     * @param normaGoal
     */
    public void setNormaGoal(String normaGoal){
        this.NormaGoal = normaGoal;
    }


    /**
     * Checks if the player has what it takes to pass level
     * */

    public void normaCheck(){

        if(NormaGoal== "STARS"){
            List<Integer> starGoal= List.of(10,30, 70, 120, 200);
            int stars=this.getStars();
            if(stars >= starGoal.get(normaLevel-1)){
                normaClear();
            }
        }
        if(NormaGoal=="WINS"){
            List<Integer> winsGoal= List.of(0,2, 5, 9, 14);
            int victories=getVictories();
            if(victories>= winsGoal.get(normaLevel-1)){
                normaClear();
            }

        }
    }
    /**
     * set and get the players home panel for a futher call
     * @param Id
     */
    public void setHomeId(int Id){
        this.homePanel = Id;
    }
    public int getHomePanelId(){
        return homePanel;
    }

    /**
     * Set the current panel which the player is on, adding the handlers so it can detects moments when it needs to do something
     *
     * @param panel
     */

    public void setCurrentPanel(Ipanel panel){
        this.currentPanel = panel;
        if(this.homePanel==panel.getId()) {
            atHomePanel.firePropertyChange("AM_I_at_Home", false,true);
        }
        else if(panel.getPlayers().size()>1) {
                     moreThanOnePlayer.firePropertyChange("More_than_one_player", true,false);
        }
        else if(panel.getNextPanels().size()>1) {
            moreThanOnePath.firePropertyChange("More_than_one_path", true,false);
        }
    }

    public Ipanel getCurrentPanel() {
        return currentPanel;
    }


    /**
     * returns a copy of the player
     * @return
     */
    @Override
    public Player copy(){
        return new Player(getName(), getCurrentHp(), getAtk(), getDef(), getEvd());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return normaLevel == player.normaLevel && victories == player.victories && homePanel == player.homePanel && NormaGoal.equals(player.NormaGoal);
    }

    /**
     * Preparing methods for the battle, starting by creating increase stars and victory by units
     */


    public void defeatAgainstUnit(IUnit unit){
        unit.defeatedByPlayer(this);
    }

    @Override
    public void defeatedByPlayer(Player unit) {
        unit.increasevictoriesBy(2);
        unit.increaseStarsBy((int)Math.floor(this.getStars()*0.5));
        this.reduceStarsBy((int)Math.floor(this.getStars()*0.5));
    }

    @Override
    public void defeatedByBoss(Boss_Unit unit) {

    }

    /**
     * the current player wins the battle against another player
     * @param e_player
     */

    @Override
    public void victory_against_player(Player e_player){
        this.increasevictoriesBy(2);
    }

    /**
     * Victory against wild unit
     * @param wild
     */
    public void victoryAgainstWild(Wild wild){
        this.increasevictoriesBy(1);
        this.increaseStarsBy(wild.getStars());
    }

    /**
     * Victory against boss Unit
     * @param boss
     */
    public void victoryAgainstBoss(Boss_Unit boss){
        this.increasevictoriesBy(3);
        this.increaseStarsBy(boss.getStars());
    }


    /**
     * Method that adss a listener in the unit
     * @param Listener new Listener
     */

    public void addAtHomePanelnotification(PropertyChangeListener Listener){
        atHomePanel.addPropertyChangeListener(Listener);
    }

    public void setMovement(boolean move){
        this.canImove = move;
    }

    /**
     * Method that adss a listener in the unit
     * @param Listener new Listener
    }

     */

    public void addNormaLevelListener(PropertyChangeListener Listener) {
        NormaLevelListener.addPropertyChangeListener(Listener);
    }

    public void addAmountOfPlayerListener(PropertyChangeListener Listener){
        moreThanOnePlayer.addPropertyChangeListener(Listener);
    }


    public void addMoreTanOnePathnotification(PropertyChangeListener Listener){
        moreThanOnePath.addPropertyChangeListener(Listener);
    }

    public boolean isKO(){
        return amIKO;
    }


}