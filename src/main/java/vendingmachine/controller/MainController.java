package vendingmachine.controller;

import vendingmachine.domain.VendingMachineMoney;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class MainController {
    VendingMachineMoney vendingMachineMoney;

    public MainController() {
    }

    public void playGame(){
        int vendingMachineChange = Input.InputVendingMachineChange();
        vendingMachineMoney = new VendingMachineMoney(vendingMachineChange);
        MakeCoinController.makeCoin(vendingMachineMoney);
        Output.printVendingMachineCoin(vendingMachineMoney);
    }
}
