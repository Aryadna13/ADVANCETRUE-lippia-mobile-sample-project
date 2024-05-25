@LogIn @Demo

Feature: Me logueo en la app de clockify

  Scenario: logueo exitoso en la aplicacion de clockify
    Given la app carga correctamente
    When el usuario ingresa su email y password
    Then se muestra la Hopa page
