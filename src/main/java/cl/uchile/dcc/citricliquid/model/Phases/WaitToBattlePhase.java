package cl.uchile.dcc.citricliquid.model.Phases;

public class WaitToBattlePhase extends Phase{

    /**
     * Here the player will stop and it can decide what type of attack will it do, but once the fight is over the turn end
     */
    @Override
    public void toEndPhase() throws InvalidPhase {
        changePhase(new EndPhase());
    }

    @Override
    public void toStopPhase() throws InvalidPhase {
        changePhase(new StopPhase());
    }
}
