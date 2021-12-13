package vendingmachine.controller;

import vendingmachine.service.MachineCoinService;

import static vendingmachine.view.OutputViews.printMachineInitCoin;

public class MachineCoinController {

    private static MachineCoinService machineCoinService;

    public static void initMachineCoin() {
        machineCoinService = new MachineCoinService();

        int inputMoney = machineCoinService.getInitMachineMoney();
        machineCoinService.initRemainCoin(inputMoney);
        printMachineInitCoin(machineCoinService.getNumOfCoin());
    }
}
