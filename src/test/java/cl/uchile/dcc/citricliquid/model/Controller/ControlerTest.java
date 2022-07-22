package cl.uchile.dcc.citricliquid.model.Controller;

import cl.uchile.dcc.citricliquid.model.Units.Boss_Unit;
import cl.uchile.dcc.citricliquid.model.Units.Player;
import cl.uchile.dcc.citricliquid.model.Units.Wild;
import cl.uchile.dcc.citricliquid.model.board.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlerTest {

    private final static String PLAYER_NAME_1 = "Ahsoka";
    private Player Ahsoka;
    private final static String PLAYER_NAME_2 = "Rex";
    private Player Rex;
    private final static String PLAYER_NAME_3 = "Anakin";
    private Player Anakin;
    private final static String PLAYER_NAME_4 = "Obi-wan";
    private Player Ben;
    private Player fakeAhsoka;
    private Player fakeRex;
    private Player fakeBen;
    private Player fakeAnakin;
    private List<Player> listOfPlayers= new ArrayList<>();
    private List<Ipanel> listOfPanels= new ArrayList<>();

    private Home testHomePanel1;
    private Home testHomePanel2;
    private Home testHomePanel3;
    private Home testHomePanel4;
    private Neutral testNeutralPanel;
    private Bonus testBonusPanel1;
    private Drop testDropPanel;
    private Encounter testEncounterPanel;
    private Boss testBossPanel;
    private Bonus testBonusPanel2;
    private Bonus testBonusPanel3;
    private Bonus testBonusPanel4;
    private Controller controller;

    private long testSeed;

    @BeforeEach
    public void setUp(){
        controller= new Controller();

        testBonusPanel1 = new Bonus(1);
        testBonusPanel2 = new Bonus(2);
        testBonusPanel3 = new Bonus(3);
        testBonusPanel4 = new Bonus(4);

        testHomePanel1 = new Home(100);
        testHomePanel2 = new Home(101);
        testHomePanel3 = new Home(102);
        testHomePanel4 = new Home(103);

        testBossPanel = new Boss(5);
        testDropPanel = new Drop(6);
        testEncounterPanel = new Encounter(7);
        testNeutralPanel = new Neutral(8);


        Rex = controller.addPlayer(PLAYER_NAME_2,6,3, 2,4, testHomePanel1, 100);
        Ahsoka =  controller.addPlayer(PLAYER_NAME_1,6, 5, 3, 3, testHomePanel2, 101);
        Anakin =  controller.addPlayer(PLAYER_NAME_3, 6, 6, 4, 3, testHomePanel3, 102);
        Ben =  controller.addPlayer(PLAYER_NAME_4, 6, 5, 6, 2, testHomePanel4, 103);

        testSeed = new Random().nextLong();


        listOfPlayers.add(Rex);
        listOfPlayers.add(Ahsoka);
        listOfPlayers.add(Anakin);
        listOfPlayers.add(Ben);


        controller.setPlayer(Rex);

        fakeAhsoka = new Player(Ahsoka.getName(), Ahsoka.getCurrentHp(), Ahsoka.getAtk(), Ahsoka.getDef(), Ahsoka.getEvd());
        fakeAnakin = new Player(Anakin.getName(), Anakin.getCurrentHp(), Anakin.getAtk(), Anakin.getDef(), Anakin.getEvd());
        fakeRex = new Player(Rex.getName(), Rex.getCurrentHp(), Rex.getAtk(), Rex.getDef(), Rex.getEvd());
        fakeBen = new Player(Ben.getName(), Ben.getCurrentHp(), Ben.getAtk(), Ben.getDef(), Ben.getEvd());



    }

    @Test
    public void turntest(){
        int chapter = controller.getChapter();
        assertEquals(Rex,controller.getPlayer());
        controller.finishTurn();
        assertEquals(Ahsoka,controller.getPlayer());
        controller.finishTurn();
        assertEquals(Anakin,controller.getPlayer());
        controller.finishTurn();
        assertEquals(Ben,controller.getPlayer());
        controller.finishTurn();
        assertEquals(Rex,controller.getPlayer());
        assertEquals(chapter +1, controller.getChapter());
    }

    @Test
    public void createPanel(){
        var HP=new Home(200);
        var expectedHP= controller.addHomePanel(200);
        assertEquals(HP,expectedHP);

        var BP=new Bonus(201);
        var expectedBP= controller.addBonusPanel(201);
        assertEquals(BP,expectedBP);

        var BossP=new Boss(202);
        var expectedBossP= controller.addBossPanel(202);
        assertEquals(BossP,expectedBossP);


        var DropP=new Drop(204);
        var expectedDropP= controller.addDropPanel(204);
        assertEquals(DropP,expectedDropP);

        var EP=new Encounter(205);
        var expectedEP= controller.addEncounterPanel(205);
        assertEquals(EP,expectedEP);

        var NP=new Neutral(206);
        var expectedNP= controller.addNeutralPanel(206);
        assertEquals(NP,expectedNP);

    }

    @Test
    public void unitTest(){

        assertEquals(Rex,fakeRex);
        assertEquals(Ahsoka,fakeAhsoka);
        assertEquals(Anakin,fakeAnakin);
        assertEquals(Ben,fakeBen);

        Boss_Unit Shifu= controller.addBossUnit("Shifu_ROBOT",4,5,6,7);
        Boss_Unit expected= new Boss_Unit("Shifu_ROBOT",4,5,6,7);
        assertEquals(Shifu,expected);

        Wild chicken= controller.addWildUnit("chicken",4,5,6,7);
        Wild expectedchicken= new Wild("chicken",4,5,6,7);
        assertEquals(Shifu,expected);
    }


}
