package vendingmachine;

import vendingmachine.app.ObjectContainer;
import vendingmachine.controller.ApplicationController;
import vendingmachine.service.VendingMachineService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachineService vendingMachineService = ObjectContainer.getVendingMachineService();
        new ApplicationController(vendingMachineService).startVendingMachine();
    }
}
