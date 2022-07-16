package cl.uchile.dcc.citricliquid.model.Listeners;

import cl.uchile.dcc.citricliquid.model.Controller.Controller;
import java.beans.PropertyChangeEvent;

public class moreThanOneNextStep implements Listeners{
    private final Controller controller;

    public moreThanOneNextStep(final Controller controller){
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.areMoreSteps((boolean)evt.getNewValue());
    }
}
