package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;

public class Neutral extends Panel{
    public Neutral(float id){
        super(id);
    }
    /**
     * Here the neutral panel does nothing
     */
    @Override
    public void activatedBy(Player player) {
    }
}
