package cl.uchile.dcc.citricliquid.model.Units;

public interface IUnit {

    void increaseStarsBy(final int amount);

    int getStars();

    void setSeed(final long seed);

    int roll();

    int getMaxHp();

    int getAtk();

    int getDef();

    int getEvd();

    void increaseHpBy(final int newHp);

    int getCurrentHp();

    void reduceStarsBy(final int amount);

    IUnit copy();

    String getName();

    int getFinalAttack();

    void esquivar(int attack);

    void defense(int attack);

    boolean isKO();


    void increasevictoriesBy(int i);

    void defeatByUnit(IUnit unit);

    void defeatedByPlayer(Player unit);

    void defeatedByWild(Wild unit);

    void defeatedByBoss(Boss_Unit unit);
}
