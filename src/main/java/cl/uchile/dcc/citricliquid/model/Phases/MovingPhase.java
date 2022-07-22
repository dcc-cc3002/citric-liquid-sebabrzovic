package cl.uchile.dcc.citricliquid.model.Phases;

public class MovingPhase extends Phase{
    /**
     * when there is more than one option it will go to desicion phase
     */
    @Override
    public void toDecisionMovingPhase() {
        changePhase(new DecisionMovingPhase());
    }
    /**
     * if there is an oponent it will battle
     */
    @Override
    public void toWaitBattlePhase() throws InvalidAction {
        changePhase(new WaitToBattlePhase());
    }
    /**
     * if the player land at home panel he will stop
     */
    @Override
    public void toWaitHomaPhase() throws InvalidAction {
        changePhase(new WaitToHomePhase());
    }

    /**
     * once it has no moves left it will go to a stop Phase
     */
    @Override
    public void toStopPhase() throws InvalidPhase {
        changePhase(new StopPhase());
    }
}
