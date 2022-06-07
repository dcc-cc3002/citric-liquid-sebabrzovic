package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.AbstractUnit;
import cl.uchile.dcc.citricliquid.model.Player;
import org.jetbrains.annotations.NotNull;

public class Drop extends Panel{

    public Drop(float id){
        super(id);
    }


    /**
     * Reduces the player's star count by the D6 roll multiplied by the player's norma level.
     */
    @Override
    public void activatedBy(Player player) {
        player.reduceStarsBy(player.roll() * player.getNormaLevel());
    }




}
