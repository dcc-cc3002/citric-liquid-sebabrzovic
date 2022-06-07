package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
class PanelTest {
  private final static String PLAYER_NAME = "Suguri";
  private final static int BASE_HP = 4;
  private final static int BASE_ATK = 1;
  private final static int BASE_DEF = -1;
  private final static int BASE_EVD = 2;
  private Home testHomePanel;
  private Neutral testNeutralPanel;
  private Bonus testBonusPanel;
  private Drop testDropPanel;
  private Encounter testEncounterPanel;
  private Boss testBossPanel;
  private Player suguri;
  private Player neo;
  private long testSeed;

  @BeforeEach
  public void setUp() {
    testBonusPanel = new Bonus(10);
    testBossPanel = new Boss(20);
    testDropPanel = new Drop(30);
    testEncounterPanel = new Encounter(40);
    testHomePanel = new Home(50);
    testNeutralPanel = new Neutral(60);
    testSeed = new Random().nextLong();
    suguri = new Player(PLAYER_NAME, BASE_HP, BASE_ATK, BASE_DEF, BASE_EVD);
    Player neo = new Player("Neo", 4, 2, -1, 2);
  }

  @Test
  public void constructorTest() {
    Bonus testBonusPanel2 = new Bonus(10);
    Boss testBossPanel2 = new Boss(20);
    Drop testDropPanel2 = new Drop(30);
    Encounter testEncounterPanel2 = new Encounter(40);
    Home testHomePanel2 = new Home(51);
    Neutral testNeutralPanel2 = new Neutral(61);

    assertEquals(testBonusPanel, testBonusPanel2);
    assertEquals(testBossPanel, testBossPanel2);
    assertEquals(testDropPanel, testDropPanel2);
    assertEquals(testEncounterPanel, testEncounterPanel2);
    assertFalse(testHomePanel.equals(testHomePanel2));
    assertFalse(testNeutralPanel.equals(testNeutralPanel2));
  }

  @Test
  public void nextPanelTest() {
    assertTrue(testNeutralPanel.getNextPanels().isEmpty());
    final var expectedPanel1 = new Neutral(61);
    final var expectedPanel2 = new Neutral(62);

    testNeutralPanel.addNextPanel(expectedPanel1);
    assertEquals(1, testNeutralPanel.getNextPanels().size());

    testNeutralPanel.addNextPanel(expectedPanel2);
    assertEquals(2, testNeutralPanel.getNextPanels().size());

    testNeutralPanel.addNextPanel(expectedPanel2);
    assertEquals(2, testNeutralPanel.getNextPanels().size());

    assertEquals(Set.of(expectedPanel1, expectedPanel2),
                 testNeutralPanel.getNextPanels());
  }

  @Test
  public void homePanelTest() {
    suguri.setHomeId(50);
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    testHomePanel.activatedBy((Player) suguri);
    assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());

    suguri.increaseHpBy(1);
    testHomePanel.activatedBy((Player) suguri);
    assertEquals(2, suguri.getCurrentHp());
  }

  @Test
  public void neutralPanelTest() {
    final var expectedSuguri = suguri.copy();
    testNeutralPanel.activatedBy((Player) suguri);
    assertEquals(expectedSuguri, suguri);
  }

  // region : Consistency tests
  @RepeatedTest(100)
  public void bonusPanelConsistencyTest() {
    int expectedStars = 0;
    assertEquals(expectedStars, suguri.getStars());
    final var testRandom = new Random(testSeed);
    suguri.setSeed(testSeed);
    for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
      final int roll = testRandom.nextInt(6) + 1;
      testBonusPanel.activatedBy((Player) suguri);
      expectedStars += roll * Math.min(3, normaLvl);
      assertEquals(expectedStars, suguri.getStars(),
                   "Test failed with seed: " + testSeed);
      ((Player) suguri).normaClear();
    }
  }

  @RepeatedTest(100)
  public void dropPanelConsistencyTest() {
    int expectedStars = 30;
    suguri.increaseStarsBy(30);
    assertEquals(expectedStars, suguri.getStars());
    final var testRandom = new Random(testSeed);
    suguri.setSeed(testSeed);
    for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
      final int roll = testRandom.nextInt(6) + 1;
      testDropPanel.activatedBy((Player) suguri);
      expectedStars = Math.max(expectedStars - roll * normaLvl, 0);
      assertEquals(expectedStars, suguri.getStars(),
                   "Test failed with seed: " + testSeed);
      ((Player) suguri).normaClear();
    }
  }

  @Test
  public void playersInPanels(){
    testBonusPanel.addPlayer(neo);
    testNeutralPanel.addPlayer(neo);
    assertEquals(testBonusPanel.getPlayers(), testNeutralPanel.getPlayers());

  }

  @Test
  public void PanelSide(){
    testBonusPanel.setDown(testHomePanel);
    testNeutralPanel.setUp(testHomePanel);
    testEncounterPanel.setLeft(testNeutralPanel);
    testBossPanel.setRight(testNeutralPanel);
    assertEquals(testBonusPanel.getDown(), testNeutralPanel.getUp());
    assertEquals(testBossPanel.getRight(), testEncounterPanel.getLeft());

  }

  // endregion
}