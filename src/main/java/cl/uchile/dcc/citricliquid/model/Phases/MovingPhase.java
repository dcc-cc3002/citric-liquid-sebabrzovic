package cl.uchile.dcc.citricliquid.model.Phases;

public class MovingPhase extends Phase{
    public MovingPhase(){
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

    /**
     * This phase will only be about rolling the dice and moving
     */
    @Override
    public void toDecisionPhase() {
        super.toDecisionPhase();
    }
}
