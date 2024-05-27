package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.LoginService;
import cucumber.api.java.en.*;


public class LoginSteps extends PageSteps {


    @io.cucumber.java.en.Given("la aplicacion carga correctamente")
    public void laAplicacionCargaCorrectamente() {
    }


    @io.cucumber.java.en.And("el usuario clickea el boton Log in manually")
    public void elUsuarioClickeaElBotonLogInManually() {
        LoginService.logInManuallyButton();
    }

    @io.cucumber.java.en.When("el usuario ingresa su (.*) y (.*)")
    public void elUsuarioIngresaSuEmailYPassword(String email, String password) {
        LoginService.usuarioyPassword(email, password);
    }


}

