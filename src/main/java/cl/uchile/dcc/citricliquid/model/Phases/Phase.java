package cl.uchile.dcc.citricliquid.model.Phases;

import cl.uchile.dcc.citricliquid.model.Controller.Controller;
import cl.uchile.dcc.citricliquid.model.Units.Player;

public abstract class Phase {
    private Controller Controller;

    /**
     * Class Phase and Controller will be linked with each other, for that a Controller is set
     * @param controller
     */
    public void setController(Controller controller){
        this.Controller = controller ;

    }
    /**
     * Method used to change the phase the controller is
     */
    public void changePhase(Phase fase){
        this.Controller.setPhase(fase);
    }

    /**
     * The next Methods are used to change the phases in the controller, The names tells it where to which phase it will be changed
     * @throws InvalidPhase
     */
    public void toStartphase() throws InvalidPhase{
        throw new InvalidPhase("You cannot start");
    }

    public void toRecoveryPhase() throws InvalidPhase{
        throw new InvalidPhase("You cannot recover ");

    };

    public void toMovingPhase() throws InvalidPhase{
        throw new InvalidPhase("You cannot move");
    }
    public  void toDecisionMovingPhase() throws InvalidPhase{
        throw new InvalidPhase("You cannot move");
    }

    public  void toWaitBattlePhase() throws InvalidAction{
        throw new InvalidAction("You cannot attack");
    }

    public void toWaitHomaPhase() throws InvalidAction{
        throw new InvalidAction("You cannot rest");
    }

    public void toStopPhase() throws InvalidPhase{
        throw new InvalidPhase("You cannot stop");
    }

    public void toEndPhase() throws InvalidPhase{
        throw new InvalidPhase("You cannot finish your turn yet");
    }
}
