package cl.uchile.dcc.citricliquid.model.Units;

import cl.uchile.dcc.citricliquid.model.board.Ipanel;

import java.util.*;

public class Player extends AbstractUnit {
    private int normaLevel;
    private int victories;
    private int homePanel;
    private String NormaGoal; /** STARS OR WINS*/
    private Ipanel currentPanel = null;



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
     * Set the current panel which the player is on, for a future use
     * @param panel
     */

    public void setCurrentPanel(Ipanel panel){
        this.currentPanel = panel;
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



}
