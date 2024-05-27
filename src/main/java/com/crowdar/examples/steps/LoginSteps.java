package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;
import com.crowdar.examples.services.LoginService;
import cucumber.api.java.en.*;


public class LoginSteps extends PageSteps {

    @Given("The app is loaded correctly")



    @Then("Login page is displayed")
    public void isLoginPageVisible() {
       // LoginService.isViewLoaded();
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

