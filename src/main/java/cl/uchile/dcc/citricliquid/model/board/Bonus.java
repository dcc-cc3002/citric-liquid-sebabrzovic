package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Units.Player;

public class Bonus extends Panel{


    public Bonus(float id){
        super(id);
    }
    /**
     * Increases the player's star count by the D6 roll multiplied by the maximum between the player's
     * norma level and three.
     */
    @Override
    public void activatedBy(Player player) {
        player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
    }



}
