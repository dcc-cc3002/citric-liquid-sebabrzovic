package cl.uchile.dcc.citricliquid.model.Phases;

public class StartPhase extends Phase{
    /**
     * If it is ko it will go to recovery phase
     */

    @Override
    public void toRecoveryPhase(){
        changePhase(new RecoveryPhase());
    }

    /**
     * If the player is not KO it will roll the dice and go to moving phase
     */
    @Override
    public void toMovingPhase() throws InvalidPhase {
        changePhase(new MovingPhase());
    }
}
