package cl.uchile.dcc.citricliquid.model.Phases;

public abstract class Phase {


    public void StartPhase() throws InvalidAction, InvalidPhase{
        throw new InvalidPhase("You cannot start");
    }

    public void RecoveryPhase() throws InvalidAction, InvalidPhase{
        throw new InvalidPhase("You cannot recover ");
    }

    public void ChooseCardPhase() throws InvalidAction, InvalidPhase {
        throw new InvalidPhase("You cannot choose a card");
    }

    public void MovingPhase() throws InvalidAction{
        throw new InvalidAction("Wrong move");
    }

    public  void DecisionPhase() throws InvalidAction, InvalidPhase{
        throw new InvalidPhase("");
    }

    public  void BattlePhase() throws InvalidAction{
        throw new InvalidAction("You cannot attack");
    }

    public void HomaPanelPhase() throws InvalidAction{
        throw new InvalidAction("You cannot rest");
    }

    public void MovesLeftPhase() throws InvalidPhase{

    }

    public void ActivateCardPhase() throws InvalidPhase{

    }

    public void PanelPhase() throws  InvalidPhase{

    }

    public void EndPhase() throws InvalidPhase{
        
    }


}
