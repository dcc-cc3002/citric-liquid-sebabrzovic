package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;

public class Home extends Panel{

    public Home(float id){
        super(id);
    }




    /**
     * If the player lands in its home panel he will level up his Hp and do its norma check
     * */

    @Override
    public void activatedBy(Player player) {
        if (player.getHomePanelId()==this.getId())
            player.increaseHpBy(player.getCurrentHp() + 1);
            player.normaCheck();
    }




}
