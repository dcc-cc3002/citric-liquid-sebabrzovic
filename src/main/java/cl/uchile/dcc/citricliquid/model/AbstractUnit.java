package cl.uchile.dcc.citricliquid.model;

import cl.uchile.dcc.citricliquid.model.board.Ipanel;

import java.util.Random;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 */
public abstract class AbstractUnit implements IUnit{
  private final Random random;
  private final int maxHp;
  private final int atk;
  private final int def;
  private final int evd;
  private final String playerName;
  private int stars;
  private int currentHp;

  /**
   * Creates a new character.
   * @param hp
   *     the initial (and max) hit points of the character.
   * @param atk
   *     the base damage the character does.
   * @param def
   *     the base defense of the character.
   * @param evd
   *     the base evasion of the character.
   */
  public AbstractUnit( final String name, final int hp, final int atk, final int def,
                      final int evd) {
    this.maxHp = currentHp = hp;
    this.playerName = name;
    this.atk = atk;
    this.def = def;
    this.evd = evd;
    random = new Random();
  }
  /**
   * Returns the character's name.
   */
  public String getName() {
    return playerName;
  }
  /**
   * Increases this player's star count by an amount.
   * @param amount
   */
  public void increaseStarsBy(final int amount) {
    stars += amount;
  }

  /**
   * Returns this player's star count.
   */
  public int getStars() {
    return stars;
  }

    /**
   * Set's the seed for this player's random number generator.
   *
   * <p>The random number generator is used for taking non-deterministic decisions, this method is
   * declared to avoid non-deterministic behaviour while testing the code.
   */
  public void setSeed(final long seed) {
    random.setSeed(seed);
  }

  /**
   * Returns a uniformly distributed random value in [1, 6].
   */
  public int roll() {
    return random.nextInt(6) + 1;
  }


  /**
   * Returns the character's max hit points.
   */
  public int getMaxHp() {
    return maxHp;
  }

  /**
   * Returns the current character's attack points.
   */
  public int getAtk() {
    return atk;
  }

  /**
   * Returns the current character's defense points.
   */
  public int getDef() {
    return def;
  }

  /**
   * Returns the current character's evasion points.
   */
  public int getEvd() {
    return evd;
  }

  /**
   * Returns the current hit points of the character.
   */
  public int getCurrentHp() {
    return currentHp;
  }

  /**
   *
   *
   * <p>The character's hit points have a constraint to always be between 0 and maxHP, both
   * inclusive.
   * @param newHp
   * Sets the current character's hit points.
   */
  public void increaseHpBy(final int newHp) {
    this.currentHp = Math.max(Math.min(this.currentHp + newHp, maxHp), 0);
  }

  /**
   * Reduces this player's star count by a given amount.
   *
   * <p>The star count will must always be greater or equal to 0
   * @param amount
   */
  public void reduceStarsBy(final int amount) {
    stars = Math.max(0, stars - amount);
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final AbstractUnit player)) {
      return false;
    }
    return getMaxHp() == player.getMaxHp()
           && getAtk() == player.getAtk()
           && getDef() == player.getDef()
           && getEvd() == player.getEvd()
           && getStars() == player.getStars() && playerName==player.getName()
           && getCurrentHp() == player.getCurrentHp();

  }

  /**
   * Returns a copy of this character.
   */
  public abstract AbstractUnit copy();
}
