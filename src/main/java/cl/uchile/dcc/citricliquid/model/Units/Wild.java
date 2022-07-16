package cl.uchile.dcc.citricliquid.model.Units;

public class Wild extends AbstractUnit {

    /**
     * Creates the wild unit
     * @param name
     * @param hp
     * @param atk
     * @param def
     * @param evd
     */
    public Wild(String name,int hp, final int atk, final int def, final int evd) {
        super(name, hp,atk, def, evd);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * player won the batlle agains a wild unit
     * @param player
     */
    @Override
    public void defeatedByPlayer(Player player) {
        player.increaseStarsBy(this.getStars());
        player.increasevictoriesBy(3);
    }

    /**
     * Return a copy of the wild unit
     * @return
     */

    @Override
    public Wild copy(){
        return new Wild(getName(), getMaxHp(), getAtk(), getDef(), getEvd());
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
