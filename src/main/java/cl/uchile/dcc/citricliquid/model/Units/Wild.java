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
