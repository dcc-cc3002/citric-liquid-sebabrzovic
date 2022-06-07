package cl.uchile.dcc.citricliquid.model;

import java.util.Objects;

public class Boss_Unit extends AbstractUnit{

    public Boss_Unit(String name, int hp, final int atk, final int def, final int evd) {
        super(name, hp,atk, def, evd);
    }

    @Override
    public String getName() {
        return super.getName();
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
