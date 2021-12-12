package vendingmachine;

import vendingmachine.domain.Consumer;
import vendingmachine.domain.VendingMachine;
import vendingmachine.model.ChangeService;
import vendingmachine.model.Operation;
import vendingmachine.model.PurchaseService;

public class Application {
	public static void main(String[] args) {
		VendingMachine vendingMachine = Operation.turnOn();
		Consumer consumer = PurchaseService.serveCustomer(vendingMachine);
		ChangeService.giveChange(vendingMachine, consumer);
	}
}
