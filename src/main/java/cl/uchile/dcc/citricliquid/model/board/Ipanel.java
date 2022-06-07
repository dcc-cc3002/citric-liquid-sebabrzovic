package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;

import java.util.List;
import java.util.Set;

public interface Ipanel {

    Set<Panel> getNextPanels();

    float getId();

    void addNextPanel(final Panel panel);

    void addPlayer(Player player);

    List<Player> getPlayers();

    Ipanel getLeft();

    Ipanel getRight();

    Ipanel getUp();

    Ipanel getDown();

    void setLeft(Ipanel left);

    void setRight(Ipanel right);

    void setUp(Ipanel up);

    void setDown(Ipanel down);

}
