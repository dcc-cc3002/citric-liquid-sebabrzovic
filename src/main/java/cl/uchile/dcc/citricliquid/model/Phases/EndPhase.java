package cl.uchile.dcc.citricliquid.model.Phases;

public class EndPhase extends Phase{
    /**
     * once the turn is over it goes to a starting phase with another player
     */
    @Override
    public void toStartphase() throws InvalidPhase {
        changePhase(new StartPhase());
    }
}
