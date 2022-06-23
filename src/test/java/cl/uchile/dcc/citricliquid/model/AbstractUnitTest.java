package cl.uchile.dcc.citricliquid.model;

import cl.uchile.dcc.citricliquid.model.Units.Boss_Unit;
import cl.uchile.dcc.citricliquid.model.Units.Player;
import cl.uchile.dcc.citricliquid.model.Units.Wild;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Test suite for the players of the game.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
public class AbstractUnitTest {
  private final static String PLAYER_NAME = "Suguri";
  private Player suguri;
  private Wild wild1;
  private Boss_Unit boss1;

  @BeforeEach
  public void setUp() {
    suguri = new Player(PLAYER_NAME, 4,1, -1, 2);
    wild1 = new Wild("CHICKEN", 3, -1, -1, +1 );
    boss1 = new Boss_Unit("SHIFU ROBOT", 7, 2, 3, -2);


  }

  @Test
  public void constructorTest() {
    final var expectedSuguri = new Player(PLAYER_NAME, 4, 1, -1, 2);
    /**final var expectedwild1 = new Wild("CHICKEN", 3, -1, -1, +1 );
    final var expectedboss1 = new Boss_Unit("SHIFU ROBOT", 7, 2, 3, -2);*/
    final var expectedwild1 = wild1.copy();
    final var expectedboss1 = boss1.copy();
    Assertions.assertEquals(expectedSuguri, suguri);
    Assertions.assertEquals(expectedwild1, wild1);
    Assertions.assertEquals(expectedboss1, boss1);


  }



  @Test
  public void testEquals() {
    final var o = new Object();
    Assertions.assertNotEquals(suguri, o);
    Assertions.assertEquals(suguri, suguri);
    final var expectedSuguri = new Player(PLAYER_NAME,4,  1, -1, 2);
    Assertions.assertEquals(expectedSuguri, suguri);
  }

  @Test
  public void testEquals2(){

  }


  @Test
  public void hitPointsTest() {
    Assertions.assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    suguri.increaseHpBy(2);
    Assertions.assertEquals(6, suguri.getCurrentHp());
    suguri.increaseHpBy(-10);
    Assertions.assertEquals(0, suguri.getCurrentHp());
    suguri.increaseHpBy(5);
    Assertions.assertEquals(5, suguri.getCurrentHp());
  }

  @Test
  public void normaClearTest() {
    suguri.increasevictoriesBy(5);
    suguri.setNormaGoal("WINS");
    suguri.normaCheck();
    Assertions.assertEquals(2, suguri.getNormaLevel());
  }

  @Test
  public void copyTest() {
    final var expectedSuguri = new Player(PLAYER_NAME, 4, 1, -1, 2);
    final var actualSuguri = suguri.copy();
    // Checks that the copied player have the same parameters as the original
    Assertions.assertEquals(expectedSuguri, actualSuguri);
    // Checks that the copied player doesn't reference the same object
    Assertions.assertNotSame(expectedSuguri, actualSuguri);
  }

  // region : consistency tests
  @RepeatedTest(100)
  public void hitPointsConsistencyTest() {
    final long testSeed = new Random().nextLong();
    // We're gonna try and set random hit points in [-maxHP * 2, maxHP * 2]
    final int testHP = new Random(testSeed).nextInt(4 * suguri.getMaxHp() + 1)
                       - 2 * suguri.getMaxHp();
    suguri.increaseHpBy(testHP);
    Assertions.assertTrue(0 <= suguri.getCurrentHp()
                          && suguri.getCurrentHp() <= suguri.getMaxHp(),
                          suguri.getCurrentHp() + "is not a valid HP value"
                          + System.lineSeparator() + "Test failed with random seed: "
                          + testSeed);
  }

  @RepeatedTest(100)
  public void normaClearConsistencyTest() {
    final long testSeed = new Random().nextLong();
    // We're gonna test for 0 to 5 norma clears
    final int iterations = Math.abs(new Random(testSeed).nextInt(6));
    final int expectedNorma = suguri.getNormaLevel() + iterations;
    for (int it = 0; it < iterations; it++) {
      suguri.normaClear();
    }
    Assertions.assertEquals(expectedNorma, suguri.getNormaLevel(),
                            "Test failed with random seed: " + testSeed);
  }

  @RepeatedTest(100)
  public void rollConsistencyTest() {
    final long testSeed = new Random().nextLong();
    suguri.setSeed(testSeed);
    final int roll = suguri.roll();
    Assertions.assertTrue(roll >= 1 && roll <= 6,
                          roll + "is not in [1, 6]" + System.lineSeparator()
                          + "Test failed with random seed: " + testSeed);
  }


  // endregion
}
