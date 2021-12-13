package vendingmachine.controller;

import vendingmachine.service.MachineCoinService;

public class MachineCoinController {

    private static MachineCoinService machineCoinService;

    public static void initMachineCoin() {
        machineCoinService = new MachineCoinService();

        int inputMoney = machineCoinService.getInitMachineMoney();
        machineCoinService.initRemainCoin(inputMoney);
    }
}
