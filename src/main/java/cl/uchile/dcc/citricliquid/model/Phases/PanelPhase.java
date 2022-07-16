package cl.uchile.dcc.citricliquid.model.Phases;

public class PanelPhase extends Phase{
    public PanelPhase(){
        this.canIStart = false;
        this.amIKo = false;
        this.choosingCard = false;
        this.canIMove = false;
        this.canIattack = false;
        this.canIrest = false;
        this.battle = false;
        this.waitAtHome = false;
        this.playCard = false;
        this.activatePanel = true;
        this.canIfinish = false;
    }

    @Override
    public void toBattlePhase() {
        changePhase(new BattlePhase());
    }

    @Override
    public void toEndPhase() {
        changePhase(new EndPhase());
    }
}
