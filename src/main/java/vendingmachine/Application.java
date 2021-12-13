package vendingmachine;

import vendingmachine.process.ProcessController;

public class Application {
    public static void main(String[] args) {

        ProcessController.makeHoldingAmount();
        ProcessController.makeCoins();
        ProcessController.printMachineCoins();
        ProcessController.inputGoods();
        ProcessController.inputUserMoney();
        ProcessController.buyGoods();
        ProcessController.makeChanges();
    }
}
