@Regression @TimeTracker
Feature: El usuario agrega horas de trabajo a su proyecto

  Background:
    Given el usuario clickea el boton Log in manually
    And el usuario ingresa su "email" y "password"

   @RegistroConFechayHora @Smoke
  Scenario: Creo un nuevo registro de horas trabajadas
    Given el usuario clickea el boton +
    And el usuario clickea sobre el boton Manual
    And el usuario añade una fecha
    And el usuario setea una hora de inicio "08:00"
#And seteo una hora final "18:00"
    And el usuario clickea el boton " Add "
    Then  se crea un nuevo time entry