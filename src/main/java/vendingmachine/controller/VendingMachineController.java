package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;

public class VendingMachineController {
    private VendingMachineService vendingMachineService;
    private VendingMachine vendingMachine;

    public VendingMachineController() {
        this.vendingMachineService = new VendingMachineService();
    }

    public void setVendingMachine(){
        VendingMachine vendingMachine = vendingMachineService.setVendingMachine();
        this.vendingMachine = vendingMachine;
    }



}
