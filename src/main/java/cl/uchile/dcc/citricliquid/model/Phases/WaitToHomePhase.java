package cl.uchile.dcc.citricliquid.model.Phases;

public class WaitToHomePhase extends Phase{

    /**
     * Here the player can either decide to stay in his home panel or continue moving
     */
    @Override
    public void toEndPhase() throws InvalidPhase {
        changePhase(new EndPhase());
    }

    @Override
    public void toMovingPhase() throws InvalidPhase {
        changePhase(new MovingPhase());
    }

}
