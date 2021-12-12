package vendingmachine.controller;

import vendingmachine.model.Item;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.OutputManager;

import java.util.ArrayList;

public class VendingMachineController {
    private VendingMachine vendingMachine;

    public void run() {
        vendingMachine = InputManager.setVendingMachine();
        OutputManager.printVendingMachineStatus(vendingMachine);
        ItemController itemController = new ItemController();
        UserController userController = new UserController(InputManager.setUserAmount());
    }
}
