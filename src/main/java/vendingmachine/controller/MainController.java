package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import static vendingmachine.view.OutputView.askMachineTotalMoney;
import static vendingmachine.view.OutputView.printVendingMachineCoins;

public class MainController {
//    VendingMachineController vendingMachineController = new VendingMachineController();

    public void run(){
        VendingMachine vendingMachine = askTotalMoney();
        showCoins(vendingMachine);
    }

    private VendingMachine askTotalMoney(){
        while (true){
            try {
                askMachineTotalMoney();
                return new VendingMachine(InputView.readTotalMoney());
            } catch (IllegalArgumentException exception) {
                OutputView.errorMessage(exception.getMessage());
            }
        }
    }

    private void showCoins(VendingMachine vendingMachine) {
        printVendingMachineCoins(vendingMachine.showCoinBox());
    }


}
