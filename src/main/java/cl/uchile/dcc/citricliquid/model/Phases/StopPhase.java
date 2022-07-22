package cl.uchile.dcc.citricliquid.model.Phases;

public class StopPhase extends Phase{

    /**
     *
     * @throws InvalidPhase
     */
    @Override
    public void toMovingPhase() throws InvalidPhase {
        changePhase(new MovingPhase());
    }

    /**
     * when it decides to attack or counterattack
     * @throws InvalidAction
     */
    @Override
    public void toWaitBattlePhase() throws InvalidAction {
        changePhase(new WaitToBattlePhase());
    }

    /**
     * Once it stops it will go to and end phase
     */
    @Override
    public void toEndPhase() throws InvalidPhase {
        changePhase(new EndPhase());
    }
}
