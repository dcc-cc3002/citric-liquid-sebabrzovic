package cl.uchile.dcc.citricliquid.model.Listeners;

import cl.uchile.dcc.citricliquid.model.Controller.Controller;
import cl.uchile.dcc.citricliquid.model.Phases.InvalidPhase;

import java.beans.PropertyChangeEvent;

public class moreThanOnePlayer implements Listeners{

    private final Controller controller;

    public moreThanOnePlayer(Controller controler){
        this.controller=controler;
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        try {
            controller.MorePlayers((boolean) evt.getNewValue());
        } catch (InvalidPhase e) {
            throw new RuntimeException(e);
        }
    }
}
