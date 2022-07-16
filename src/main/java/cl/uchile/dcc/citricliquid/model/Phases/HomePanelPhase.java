package cl.uchile.dcc.citricliquid.model.Phases;

public class HomePanelPhase extends Phase{
    public HomePanelPhase(){
        this.canIStart = false;
        this.amIKo = true;
        this.choosingCard = false;
        this.canIMove = true;
        this.canIattack = false;
        this.canIrest = true;
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
