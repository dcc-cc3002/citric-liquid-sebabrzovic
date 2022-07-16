package cl.uchile.dcc.citricliquid.model.Phases;

import cl.uchile.dcc.citricliquid.model.Controller.Controller;
import cl.uchile.dcc.citricliquid.model.Units.Player;

public abstract class Phase {
    private Controller Controller;
    public boolean canIStart;
    public boolean amIKo;
    public boolean choosingCard;
    public boolean canIMove;
    public boolean canIattack;
    private boolean canIcounterattack;
    public boolean canIrest;
    public boolean battle;
    public boolean waitAtHome;
    public boolean playCard;
    public boolean activatePanel;
    public boolean canIfinish;

    public void setController(Controller controller){
        this.Controller = controller ;

    }
    public void changePhase(Phase fase){
        this.Controller.setPhase(fase);
    }

    public void StartPhase() throws InvalidAction, InvalidPhase{
        throw new InvalidPhase("You cannot start");
    }

    public void toStartphase(){}

    public void RecoveryPhase() throws InvalidAction, InvalidPhase{
        throw new InvalidPhase("You cannot recover ");
    }

    public void toRecoveryPhase(){};

    public void ChooseCardPhase() throws InvalidAction, InvalidPhase {
        throw new InvalidPhase("You cannot choose a card");
    }

    public void toChooseCardPhase(){};

    public void MovingPhase() throws InvalidAction{
        throw new InvalidAction("Wrong move");
    }

    public void toMovingPhase(){};

    public  void DecisionPhase() throws InvalidAction, InvalidPhase{
        throw new InvalidPhase("");
    }

    public void toDecisionPhase(){};

    public  void BattlePhase() throws InvalidAction{
        throw new InvalidAction("You cannot attack");
    }

    public void toBattlePhase(){};

    public void HomaPanelPhase() throws InvalidAction{
        throw new InvalidAction("You cannot rest");
    }

    public void toHomePhase(){
    }

    public void MovesLeftPhase() throws InvalidPhase{

    }

    public void toMovesleftPhase(){}

    public void ActivateCardPhase() throws InvalidPhase{

    }

    public void toActivateCardPhase(){

    }

    public void PanelPhase() throws  InvalidPhase{

    }

    public void toPanelPhase(){};

    public void EndPhase() throws InvalidPhase{

    }

    public void toEndPhase(){}


    public void toHomePanelPhase(){

    };
}
