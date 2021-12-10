package vendingmachine.controller;

import vendingmachine.service.VendingMachineService;

public class VendingMachineController {
    private VendingMachineService vendingMachineService;

    public VendingMachineController() {
        this.vendingMachineService = new VendingMachineService();
    }

    public void setVendingMachine(){
        vendingMachineService.setVendingMachine();
    }

}
