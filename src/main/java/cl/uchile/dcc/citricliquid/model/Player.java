package cl.uchile.dcc.citricliquid.model;

import java.util.Random;

public class Player extends AbstractUnit{
    private final String name;
    private int normaLevel;
    private int victories;

    /**
     * Returns this player's victory count.
     */
    public int getVictories() {
        return victories;
    }

    /**
     * Returns the character's name.
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the current norma level.
     */
    public int getNormaLevel() {
        return normaLevel;
    }

    /**
     * Performs a norma clear action; the {@code norma} counter increases in 1.
     */
    public void normaClear() {
        normaLevel++;
    }

}
