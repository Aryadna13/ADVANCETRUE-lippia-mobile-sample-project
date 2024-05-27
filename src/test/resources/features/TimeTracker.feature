@Regression @TimeTracker @TimeEntry
Feature: El usuario agrega horas de trabajo a su proyecto

  Background:
    Given el usuario clickea el boton Log in manually
    And el usuario ingresa su "email" y "password"

  @RegistroConFechayHora @Smoke
  Scenario: Creo un nuevo registro de horas trabajadas
    Given el usuario clickea el boton +
    And el usuario clickea sobre el boton Manual
    And el usuario clickea el boton Start y setea una hora de inicio
    And el usuario clickea el boton End y setea una hora final
    And el usuario nombra su nuevo time entry "NuevoTest"
    And el usuario clickea el boton Save
    Then se crea un nuevo time entry