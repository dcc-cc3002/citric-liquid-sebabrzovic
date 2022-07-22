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
     * As it was described in the abstract, these are the methods for the double dispatch, defeated by player and unit
     * @param unit
     */
    @Override
    public void defeatedByPlayer(Player unit) {
        unit.increaseStarsBy(this.getStars());
        unit.increasevictoriesBy(1);
    }

    @Override
    public void defeatByUnit(IUnit unit) {
        unit.defeatedByWild(this);
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
