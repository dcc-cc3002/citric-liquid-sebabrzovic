package cl.uchile.dcc.citricliquid.model.Phases;

public class StartPhase extends Phase{
    public StartPhase(){
        this.canIStart = true;
        this.amIKo = false;
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
     * If it is not ko it will go to the phase where it decides the card or not
     */
    @Override
    public void toChooseCardPhase() {
        changePhase(new ChooseCardPhase());
    }


    /**
     * If it is ko it will go to recovery phase
     */

    @Override
    public void toRecoveryPhase(){
        changePhase(new RecoveryPhase());
    }


}
