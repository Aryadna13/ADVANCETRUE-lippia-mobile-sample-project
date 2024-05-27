package com.crowdar.examples.steps;

import com.crowdar.examples.services.TimeTrackerService;
import io.cucumber.java.en.*;

public class TimeEntrySteps {

    @Given("el usuario clickea el boton +")
    public void elUsuarioClickeaElBoton() {
        TimeTrackerService.tapPlusButton();
    }

    @And("el usuario clickea sobre el boton Manual")
    public void elUsuarioClickeaSobreElBotonManual() {
        TimeTrackerService.tapManualButton();
    }

    @And("el usuario clickea el boton Start y setea una hora de inicio")
    public void elUsuarioClickeaElBotonStartYSeteaUnaHoraDeInicio() {
        TimeTrackerService.startButton();
    }

    @And("el usuario clickea el boton End y setea una hora final")
    public void elUsuarioClickeaElBotonEndYSeteaUnaHoraFinal() {
        TimeTrackerService.endButton();
    }

    @And("el usuario nombra su nuevo time entry (.*)")
    public void elUsuarioNombraSuNuevoTimeEntry(String NuevoTest) {
        TimeTrackerService.nameNewEntry(NuevoTest);
    }

    @And("el usuario clickea el boton Save")
    public void elUsuarioClickeaElBotonSave() {
        TimeTrackerService.saveTimeEntry();
    }

    @Then("se crea un nuevo time entry")
    public void seCreaUnNuevoTimeEntry() {
        TimeTrackerService.nuevoTimeEntryCreado();
    }
}


