package vendingmachine.controller;

import vendingmachine.service.ChangeService;
import vendingmachine.view.InputViews;

public class ChangeController {

    private static ChangeService changeService;

    public static void initUserChange() {
        String inputMoney = InputViews.inputUserMoney();
    }

}
