package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import com.crowdar.examples.constants.TimeTrackerConstants;
import org.testng.Assert;

public class TimeTrackerService {

    public static void tapPlusButton() {
        MobileActionManager.click(TimeTrackerConstants.NEW_TIME_TRACKER);
    }

    public static void tapManualButton() {
        MobileActionManager.click(TimeTrackerConstants.MANUAL_BUTTON);
        MobileActionManager.click(TimeTrackerConstants.CANCEL_DURATION_BUTTON);
    }

    public static void startButton() {
        MobileActionManager.click(TimeTrackerConstants.START_BUTTON);
        MobileActionManager.click(TimeTrackerConstants.START_HOUR_9AM);
        //MobileActionManager.click(TimeTrackerConstants.MINUTES_00);
        MobileActionManager.click(TimeTrackerConstants.OK_BUTTON);
    }

    public static void endButton() {
        MobileActionManager.click(TimeTrackerConstants.END_BUTTON);
        MobileActionManager.click(TimeTrackerConstants.END_HOUR_18AM);
        //MobileActionManager.click(TimeTrackerConstants.MINUTES_00);
        MobileActionManager.click(TimeTrackerConstants.OK_BUTTON);
    }

    public static void nameNewEntry(String nombre) {
        MobileActionManager.setInput(TimeTrackerConstants.NAME_ENTRY_INPUT, nombre);
    }

    public static void saveTimeEntry() {
        MobileActionManager.click(TimeTrackerConstants.SAVE_BUTTON);
    }

    public static void nuevoTimeEntryCreado() {
        MobileActionManager.waitVisibility(TimeTrackerConstants.ENTRY_CREATED_MESSAGE);
        Assert.assertTrue(MobileActionManager.isVisible(TimeTrackerConstants.ENTRY_CREATED_MESSAGE), HomeConstants.VIEW_NOT_DISPLAYED_MESSAGE);
    }
}
