package vendingmachine.controller;

import vendingmachine.view.Input;

public class VendingMachineController {

    private final Input input = new Input();

    public void run() {
        int money = input.readAmount();
    }
}
