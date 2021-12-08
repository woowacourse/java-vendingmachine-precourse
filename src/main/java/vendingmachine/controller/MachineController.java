package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.Validator;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.OutputView;

public class MachineController {
    private VendingMachine vendingMachine;

    public void run() {
        initMachine();
    }

    private void initMachine() {
        vendingMachine = new VendingMachine(inputAmount());
        OutputView.printRemainingCoins(vendingMachine.getCoins());
    }

    private int inputAmount() {
        while (true) {
            try {
                return Validator.validateAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
