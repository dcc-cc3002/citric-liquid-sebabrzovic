package cl.uchile.dcc.citricliquid.model.Phases;

public class MovesLeftPhase extends Phase{
    public MovesLeftPhase(){
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
    public void toMovingPhase() {
        changePhase(new MovingPhase());
    }

    @Override
    public void toActivateCardPhase() {
        changePhase(new ActivateCardPhase());
    }
}
