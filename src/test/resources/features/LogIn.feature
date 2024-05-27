@Regression @LogIn

Feature: El usuario se loguea en la app de clockify

  @LogueoExitoso @smoke
  Scenario: logueo en la aplicacion de clockify
    Given la aplicacion carga correctamente
    And el usuario clickea el boton Log in manually
    When el usuario ingresa su "email" y "password"
    Then se muestra la Home page
