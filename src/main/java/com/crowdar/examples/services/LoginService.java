package com.crowdar.examples.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.LoginConstants;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.crowdar.core.actions.ActionManager.setInput;


public class LoginService {

    public static void usuarioyPassword(String usuario, String password) {

        Properties properties = new Properties();
        InputStream input = null;

        try {
            input = LoginService.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(input);

            usuario = properties.getProperty("clocky.user");
            password = properties.getProperty("clocky.password");

            setInput(LoginConstants.EMAIL_INPUT, usuario);
            setInput(LoginConstants.PASSWORD_INPUT, password);

            MobileActionManager.click(LoginConstants.LOG_IN_BUTTON_LOCATOR);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    /*public static void isViewLoaded(){
        MobileActionManager.waitVisibility(LoginConstants.LOG_IN_BUTTON_LOCATOR);
        Assert.assertTrue(MobileActionManager.isVisible(LoginConstants.EMAIL_INPUT_LOCATOR), LoginConstants.VIEW_NOT_DISPLAYED_MESSAGE);
    }*/
    }
}
