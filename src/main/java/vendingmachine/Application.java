package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.RandomPossessionCoinsGenerator;

public class Application {
    public static void main(String[] args) {
        VendingMachineController vendingMachineController = new VendingMachineController(
            new RandomPossessionCoinsGenerator());

        vendingMachineController.run();
    }
}
