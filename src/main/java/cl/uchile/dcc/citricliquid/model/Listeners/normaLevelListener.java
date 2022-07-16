package cl.uchile.dcc.citricliquid.model.Listeners;

import cl.uchile.dcc.citricliquid.model.Controller.Controller;

import java.beans.PropertyChangeEvent;

public class normaLevelListener implements Listeners{
    private Controller controller;

    public normaLevelListener(Controller controler){
        this.controller=controler;
    }
    /**
     * This method gets called when a bound property is changed.
     * @param evt A PropertyChangeEvent object describing the event source
     * and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.NewNormaLevel((int) evt.getNewValue());
    }
}
