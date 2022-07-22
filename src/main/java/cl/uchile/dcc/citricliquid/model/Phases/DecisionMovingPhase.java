package cl.uchile.dcc.citricliquid.model.Phases;

public class DecisionMovingPhase extends Phase {

    /**
     * Once it decides where to go it will continue in moving phase
     * @throws InvalidPhase
     */
    @Override
    public void toMovingPhase() throws InvalidPhase {
        changePhase(new MovingPhase());
    }
}

