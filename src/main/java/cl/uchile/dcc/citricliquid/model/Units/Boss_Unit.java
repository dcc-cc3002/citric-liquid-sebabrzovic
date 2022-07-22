package cl.uchile.dcc.citricliquid.model.Units;

public class Boss_Unit extends AbstractUnit {

    public Boss_Unit(String name, int hp, final int atk, final int def, final int evd) {
        super(name, hp,atk, def, evd);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * As it was described in the abstract, these are the methods for the double dispatch, defeated by player and unit
     * @param player
     */
    @Override
    public void defeatedByPlayer(Player player) {
        player.increaseStarsBy(this.getStars());
        player.increasevictoriesBy(3);
    }

    @Override
    public void defeatByUnit(IUnit unit) {
        unit.defeatedByBoss(this);
    }

    @Override
    public Boss_Unit copy(){
        return new Boss_Unit(getName(), getMaxHp(), getAtk(), getDef(), getEvd());
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }


}
