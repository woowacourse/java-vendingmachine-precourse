package vendingmachine;

import vendingmachine.service.VendingMachineService;

public class Application {
    public static void main(String[] args) {
        new VendingMachineService().play();
    }
}
