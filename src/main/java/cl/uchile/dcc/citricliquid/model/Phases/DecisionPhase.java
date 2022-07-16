package cl.uchile.dcc.citricliquid.model.Phases;

public class DecisionPhase extends Phase{
    public DecisionPhase(){
        this.canIStart = false;
        this.amIKo = false;
        this.choosingCard = false;
        this.canIMove = true;
        this.canIattack = false;
        this.canIrest = false;
        this.battle = false;
        this.waitAtHome = false;
        this.playCard = false;
        this.activatePanel = false;
        this.canIfinish = false;
    }

    @Override
    public void toBattlePhase() {
        changePhase(new BattlePhase());
    }


    @Override
    public void toHomePhase(){
        changePhase(new HomePanelPhase());
    }

    @Override
    public void toMovesleftPhase(){
        changePhase(new MovesLeftPhase());
    }
}
