@LogIn @Demo

  Feature: Interactuo con el login de clockify

Scenario Outline: El usuario se loguea exitosamente en la aplicacion de clockify
Given The app is loaded correctly
When el usuario ingresa su <email> y <password>
Then Home page is displayed

Examples:
| email                       | password |
| garciaariadna139@gmail.com  | 123456   |
| automation@gmail.com        | 456789   |

