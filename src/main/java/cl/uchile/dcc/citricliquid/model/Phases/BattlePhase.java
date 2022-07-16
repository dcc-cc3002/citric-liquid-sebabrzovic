package cl.uchile.dcc.citricliquid.model.Phases;

public class BattlePhase extends Phase{
    public BattlePhase(){
        this.canIStart = false;
        this.amIKo = false;
        this.choosingCard = false;
        this.canIMove = false;
        this.canIattack = true;
        this.canIrest = false;
        this.battle = false;
        this.waitAtHome = false;
        this.playCard = false;
        this.activatePanel = false;
        this.canIfinish = false;
    }

    @Override
    public void toMovesleftPhase() {
        changePhase(new MovesLeftPhase());

    }

    @Override
    public void toEndPhase() {
        changePhase(new EndPhase());
    }


}

