# LIPPIA Mobile Example Project

## Purpose:
The following project has the purpose of demonstrate and let test automation developers to
to test a Mobile App using Lippia Automation Framework and Docker Android stack https://github.com/budtmo/docker-android, based on Budi Utomo Docker Android project.

## System Requirements: 
+ jdk: https://docs.oracle.com/en/java/javase/index.html 
+ maven: https://maven.apache.org/download.cgi 
+ git client: https://www.atlassian.com/git/tutorials/install-git 
+ docker 18.09+: https://docs.docker.com/install/linux/docker-ce/ubuntu/  _OPTIONAL_ 
+ docker compose 1.24+: https://docs.docker.com/compose/install/ _OPTIONAL_ 

# Getting started

- Mobile emulated solution only using Maven [`Getting started - Running only with Maven`](docs/README_Linux.md)
- Mobile emulated solution using Docker [`Getting started - Running with Docker`](docs/README_Linux.md)
- Mobile emulated solution using Vagrant [`Getting started - Running with Vagrant`](docs/README_Linux.md)

# Reports integrations   

We believe that the reports should express the results of our tests in the most legible, detailed and pleasant way possible, so that in this way, our clients have at their disposal a report on the operation and behavior of their product, as well as the performance of the team. That is why Lippia, in addition to supporting the integration with **ExtentReport**, provides a **ReportServer** for each client.   
Next, we will see the structure of the project and from where we can access them.

### Reports are generated in the folder called **target**, which will be generated once the execution of the test suite is finished.   
Note that the following structure is part of the report generated with **ExtentReport** library.
```
├── lippia-mobile-sample-project
    ├── docs
    |   └── ...
    ├── src
    |   └── ...
    ├── target
    |   └── reports
    |       └── index.html
    └── ...
```

### index.html
![ExtentReport example](docs/img/extentReportExample.png)

## Project structure

A typical Lippia Test Automation project usually looks like this

```
	.
├── main
│   ├── java
│   │   └── com
│   │       └── crowdar
│   │           └── examples
│   │               ├── constants
|   |		    |	|   |   |   |   └── HomeConstants.java
|   |		    |	|   |   |   |   └── LoginConstants.java
|   |		    |	|   |   |   |   └── SignUpConstants.java
│   │               ├── services
|   |		    |	|   |   |   |   └── HomeService.java
|   |		    |	|   |   |   |   └── LoginService.java
|   |		    |	|   |   |   |   └── SignUpService.java
│   │               ├── pages
│   │               │   └── ApiDemoHome.java
│   │               └── steps
│   │                   └── ApkApiDemoSteps.java
│   │                   └── HomeSteps.java
│   │                   └── LoginSteps.java
│   │                   └── SignUpSteps.java
│   └── resources
|   |	|   └── locators
|   |	|   |   └── LoginView.properties
|   |	|   |   └── HomeView.properties
|   |	|   |   └── SignUpView.properties
|	├── capabilities
|	|   └── androidCapabilities
|	|   └── browserStackCapabilities	
│       └── config.properties
│       └── cucumber.properties
└── test
    ├── java
    │   ├── CrowdTestNgParallelRunner.java
    │   ├── CrowdTestNgRunner.java
    │   └── com
    │       └── crowdar
    │           └── Hooks.java
    └── resources
        └── features
            └── ApiDemos.feature
	    └── Demo.feature
```

Folder's description:

|Path   |Description    |
|-------|----------------|
|main\java\\...\examples\pages\\\*.java|Folder with all the **PageObjects** matching steps with java code|
|main\java\\...\examples\steps\\\*Steps.java|Folder with all the **steps** which match with Gherkin Test Scenarios |
|main\resources\locators\\\*.properties|Folder with all the **locators** which match with properties |
|test\resources\features\\\*.feature|Folder with all the **feature files** containing **Test Scenarios** and **Sample Data** |
|main\resources|Folder with all configuration needed to run Lippia |
|main\resources\capabilities\\\*json|Folder with all the capabilities availables for the driver |

In this example, *ApiDemos* is the Apk the framework will interact with.
The **steps** defined in *ApkApiDemoSteps.java* to execute the *Test Scenarios* defined in Gherkin language.


|File   | Description    |
|-------|----------------|
|ApiDemoHome.java   | PageObject: between each element in the aplication *ApiDemoHome* you want to interact with. You need to add one new file for each page you want to navigate in your tests. |
|ApkApiDemoSteps.java   | StepOpject: Code to support the behaviour of each **step** coded into the feature files for the *ApiDemoHome*. This code executes the interaction between the Framework and the web application and match the steps with the code who run interactions. |
|ApiDemos.feature| Feature file: Definition of the **Test Scenarios** with all the **steps** written in Cucumber format|

## Page Object @DEPRECATED
***    
This is replaced by Services
```
public class ApiDemoHome extends PageBase{

	public ApiDemoHome(SharedDriver driver){
		super(driver);
	}

    public String getTitle(){
    	return getMobileElement(By.xpath("//*[@resource-id='android:id/action_bar']")).findElement(By.xpath("//android.widget.TextView")).getText();
    }

    private WebElement getMenuElement(String menu){
    	return getMobileElement(By.xpath("//android.widget.TextView[@content-desc="+"\""+menu+"\""+"]"));
    }

   public void clickMenuElement(String menu){
       WebElement element = getMenuElement(menu);
        element.click();
   }

}
```

## Services
***    

(Services) contains the business logic, we call the locators hardcoded here or, in this case,located in the constants class, and then, the action we need to do.

```
public class LoginService {

    public static void doLogin(String email, String password){
        MobileActionManager.setInput(LoginConstants.EMAIL_INPUT_LOCATOR, email);
        MobileActionManager.setInput(LoginConstants.PASSWORD_INPUT_LOCATOR, password);
        MobileActionManager.click(LoginConstants.SIGN_IN_BUTTON_LOCATOR + DriverManager.getName());
    }

    public static void isViewLoaded(){
        MobileActionManager.waitVisibility(LoginConstants.SIGN_UP_BUTTON_LOCATOR);
        Assert.assertTrue(MobileActionManager.isVisible(LoginConstants.EMAIL_INPUT_LOCATOR), LoginConstants.VIEW_NOT_DISPLAYED_MESSAGE);
    }
}

```

## Step Object   
***

In the steps files we connect the gherkin with java code, and here is the connection with the services, in these classes there should not be logic 

```
public class LoginSteps extends PageSteps {

    @Given("The app is loaded correctly")
    @Then("Login page is displayed")
    public void isLoginPageVisible() {
        LoginService.isViewLoaded();
    }

    @When("The user goes to the Sign Up page")
    public void goToSignUp() {
        MobileActionManager.click(LoginConstants.SIGN_UP_BUTTON_LOCATOR);
    }

    @When("The user logs in the application with: (.*), (.*)")
    public void doLoginProcess(String email, String password) {
        LoginService.doLogin(email, password);
    }

}
```

## Locators properties
***

The locators can be written in .properties file located in src/main/resources/locators For example, to access email input in LoginView.properties we write: loginView.emailInput

```
emailInput=accessibility_id:emailAddressInputLogin
passwordInput=accessibility_id:passwordInputLogin
signInButtonAndroid=accessibility_id:signInButtonLogin
signInButtonIos=accessibility_id:signInButtonLogin
signUpButton=accessibility_id:signUpButtonLogin
```


## Feature File
***

The Test Scenarios can be written using BDD metodology. This project includes Cucumber as BDD interpreter which is supported by Lippia by default. On each declared step you can insert the calls defined from service classes            

```
Feature: As a potential client i want to interact with the mobile application

  @Smoke
  Scenario: The client starts the applicacion ApiDemos accesing to Bouncing Balls
    Given The user opens the 'API Demos' application
    When The user clicks over 'Animation' menu element
    When The user clicks over 'Bouncing Balls' menu element
    Then The user sees the application 'Animation/Bouncing Balls' open

  @Smoke
  Scenario: The client starts the applicacion ApiDemos accesing to cloning
    Given The user opens the 'API Demos' application
    When The user clicks over 'Animation' menu element
    When The user clicks over 'Cloning' menu element
    Then The user sees the application 'Animation/Cloning' open

  @Smoke
  Scenario: The client starts the applicacion ApiDemos accesing to Multiple Properties
    Given The user opens the 'API Demos' application
    When The user clicks over 'Animation' menu element
    When The user clicks over 'Multiple Properties' menu element
    Then The user sees the application 'Animation/Multiple Properties' open
```


## Capabilities
***

The capabilities are located in a json file. This file is mandatory. The values that are inside "{{}}" are replaced with the values located in config.properties and in that file, the key must be equal to the property to replace. For example, in config.properties: deviceName=Android ; Avd property must be empty in case of using a real device.

```
{
  "deviceName": "{{deviceName}}",
  "app": "{{app}}",
  "platformName": "Android",
  "avd": "{{avd}}",
  "resetKeyboard": "true",
  "unicodeKeyboard": "true"
}
```
