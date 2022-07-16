package cl.uchile.dcc.citricliquid.model.Phases;

public class RecoveryPhase extends Phase{
    public RecoveryPhase(){
        this.canIStart = false;
        this.amIKo = true;
        this.choosingCard = false;
        this.canIMove = false;
        this.canIattack = false;
        this.canIrest = false;
        this.battle = false;
        this.waitAtHome = false;
        this.playCard = false;
        this.activatePanel = false;
        this.canIfinish = false;
    }

    /**
     * once it recovers it will go on to choose a card
     */
    @Override
    public void toChooseCardPhase() {
        changePhase(new ChooseCardPhase());
    }
}
