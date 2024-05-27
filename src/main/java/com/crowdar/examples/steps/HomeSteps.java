package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.HomeService;
import cucumber.api.java.en.*;


public class HomeSteps extends PageSteps {


    @io.cucumber.java.en.Then("se muestra la Home page")
    public void seMuestraLaHomePage() {
        HomeService.menuHome();
    }
}
