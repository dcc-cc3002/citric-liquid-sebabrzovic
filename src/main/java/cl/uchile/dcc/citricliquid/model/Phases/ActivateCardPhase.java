package cl.uchile.dcc.citricliquid.model.Phases;

public class ActivateCardPhase extends Phase{
    public ActivateCardPhase(){
        this.canIStart = false;
        this.amIKo = false;
        this.choosingCard = false;
        this.canIMove = false;
        this.canIattack = false;
        this.canIrest = false;
        this.battle = false;
        this.waitAtHome = false;
        this.playCard = true;
        this.activatePanel = false;
        this.canIfinish = false;
    }

    @Override
    public void toPanelPhase() {
        changePhase(new PanelPhase());
    }
}
