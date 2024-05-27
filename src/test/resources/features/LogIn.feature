@Regression @LogIn

Feature: Me logueo en la app de clockify

  @LogueoExitoso @smoke
  Scenario: logueo exitoso en la aplicacion de clockify
    Given la app carga correctamente
    And el usuario clickea el boton Log in manually
    When el usuario ingresa su "email" y "password"
    Then se muestra la Home page
