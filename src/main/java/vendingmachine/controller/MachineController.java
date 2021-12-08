package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.Validator;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private VendingMachine vendingMachine;

    public void run() {
        initMachine();
    }

    private void initMachine() {
        createVendingMachine();
        createProducts();
    }

    private void createVendingMachine() {
        vendingMachine = new VendingMachine(inputAmount());
        OutputView.printRemainingCoins(vendingMachine.getCoins());
    }

    private int inputAmount() {
        InputView.printInputAmountMessage();

        while (true) {
            try {
                return Validator.validateAmountInput(Console.readLine());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }


    private void createProducts() {
        inputProducts();
    }

    private void inputProducts() {
        InputView.printInputProductMessage();

        while (true) {
            try {
                String str = Validator.validateProductInput(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
