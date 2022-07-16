package cl.uchile.dcc.citricliquid.model.Phases;

public class ChooseCardPhase extends Phase{
    public ChooseCardPhase(){
        this.canIStart = false;
        this.amIKo = false;
        this.choosingCard = true;
        this.canIMove = false;
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
}
