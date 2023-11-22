package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import javax.xml.bind.ValidationEvent;

import static vendingmachine.view.InputView.readTotalMoney;
import static vendingmachine.view.OutputView.askMachineTotalMoney;

public class MainController {
    VendingMachineController vendingMachineController = new VendingMachineController();

    public void run(){
        VendingMachine vendingMachine = askTotalMoney();

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


}
