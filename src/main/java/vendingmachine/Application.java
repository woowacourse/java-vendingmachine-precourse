package vendingmachine;

import vendingmachine.controller.RequestController;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachine vendingMachine = RequestController.requestVendingMachine();
        System.out.println(vendingMachine.compareCheapestPrice(new Money(1000)));
    }
}
