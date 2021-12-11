package vendingmachine;

import vendingmachine.machine.VendingMachine;
import vendingmachine.machine.VendingMachineMaker;
import vendingmachine.payments.Payments;
import vendingmachine.payments.PaymentsController;
import vendingmachine.trade.Trade;

public class Application {
	public static void main(String[] args) {
		VendingMachine vendingMachine = readyToService();
		Payments payments = insertMoney();
		Trade trade = new Trade(vendingMachine, payments);
		trade.start();
		trade.returnChangeCoins();
	}

	public static VendingMachine readyToService() {
		VendingMachineMaker vendingMachineMaker = new VendingMachineMaker();
		return vendingMachineMaker.readyToService();
	}

	public static Payments insertMoney() {
		PaymentsController paymentsController = new PaymentsController();
		return paymentsController.insertMoney();
	}
}
