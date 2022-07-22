package cl.uchile.dcc.citricliquid.model.Phases;

public class RecoveryPhase extends Phase {

    @Override
    public void toEndPhase() throws InvalidPhase {
        changePhase(new EndPhase());
    }

    @Override
    public void toStartphase() throws InvalidPhase {
        super.toStartphase();
    }
}