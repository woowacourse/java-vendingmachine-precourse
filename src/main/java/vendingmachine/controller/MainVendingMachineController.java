package vendingmachine.controller;

import vendingmachine.domain.Purchaser;
import vendingmachine.domain.VendingMachine;

public class MainVendingMachineController {
    private  MainVendingMachineController(){
    }

    public static void start() {
        VendingMachine vendingMachine = VendingMachineController.requestVendingMachine();
        Purchaser purchaser = PurchaserController.requestPurchaseOrder();
        OrderController.from(vendingMachine, purchaser);
    }
}
