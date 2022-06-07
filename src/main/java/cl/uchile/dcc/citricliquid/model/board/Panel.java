package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.AbstractUnit;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

import cl.uchile.dcc.citricliquid.model.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a panel in the board of the game.
 *
 */
public abstract class Panel implements Ipanel{

  private float Id;
  private final Set<Panel> nextPanels = new HashSet<>();
  private ArrayList<Player> Players = new ArrayList<Player>();
  private Ipanel Up = null;
  private Ipanel Down = null;
  private Ipanel Left = null;
  private Ipanel Right = null;


  /**
   * create a Paneñ with an own id for every panel in order to identify each one and identify the players home panel and extract it
   * @param newId
   */

  public Panel(float newId){
    this.Id = newId;
  }
  /**
   * Returns a copy of this panel's next ones.
   */
  public Set<Panel> getNextPanels() {
    return Set.copyOf(nextPanels);
  }


  /**
   * Extract the ID for futher purpose
   * @return
   */
  public float getId() {
    return Id;
  }

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel the panel to be added.
   */
  public void addNextPanel(final Panel panel) {
    nextPanels.add(panel);
  }


  /**
   * add the player that has landed on the panel and then eliminate that player once it leaves
   * @param player
   */
  public void addPlayer(Player player) {
    Players.add(player);

  }

  /**
   * extract the player who are in the panel
   * @return
   */

  public List<Player> getPlayers() {
    return Players;
  }

  /**
   * Here we will set and get the panels in every side for an eventual need
   */


  public Ipanel getLeft() {
    return Left;
  }
  public Ipanel getRight() {
    return Right;
  }
  public Ipanel getUp() {return Up;}
  public Ipanel getDown() {
    return Down;
  }


  public void setLeft(Ipanel left) {
    this.Left = left;
  }

  public void setRight(Ipanel right) {
    this.Right = right;
  }

  public void setUp(Ipanel up) {
    this.Up = up;
  }

  public void setDown(Ipanel down) {
    this.Down = down;
  }





  /**
   * Here we will execute the action, it will be summoned in each panel
   */
  public abstract void activatedBy(Player player);

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Panel)) return false;
    Panel panel = (Panel) o;
    return Id == panel.Id && nextPanels.equals(panel.nextPanels) && Players.equals(panel.Players) && Objects.equals(panel.Up, Up) && Objects.equals(panel.Down, Down) && Objects.equals(panel.Left, Left) && Objects.equals(panel.Right, Right);

  }
}
