package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import org.testng.Assert;

public class HomeService {

    public static void menuHome() {
        MobileActionManager.waitVisibility(HomeConstants.HAMBURGUER_MENU);
        Assert.assertTrue(MobileActionManager.isVisible(HomeConstants.HAMBURGUER_MENU), HomeConstants.VIEW_NOT_DISPLAYED_MESSAGE);
    }
}
