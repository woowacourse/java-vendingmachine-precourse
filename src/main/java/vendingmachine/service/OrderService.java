package vendingmachine.service;

import vendingmachine.domain.Purchaser;
import vendingmachine.domain.VendingMachine;

public class OrderService {
    private final VendingMachine vendingMachine;
    private final Purchaser purchaser;

    public OrderService(VendingMachine vendingMachine, Purchaser purchaser){
        this.vendingMachine = vendingMachine;
        this.purchaser = purchaser;
    }

    public int getCurrentMoney(){
        return purchaser.getMoney();
    }

    public void getOrderMenu(String menu){

    }
}
