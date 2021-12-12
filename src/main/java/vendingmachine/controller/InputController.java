package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;

public class InputController {

    public static void makeProductsList(VendingMachine vendingMachine) {
        String inputProducts = InputView.inputProducts();
        System.out.println(inputProducts);
    }
}
