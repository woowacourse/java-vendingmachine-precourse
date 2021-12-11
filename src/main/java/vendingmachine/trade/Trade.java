package vendingmachine.trade;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.machine.VendingMachine;
import vendingmachine.payments.Payments;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Trade {
	private VendingMachine vendingMachine;
	private Payments payments;

	public Trade(VendingMachine vendingMachine, Payments payments) {
		this.vendingMachine = vendingMachine;
		this.payments = payments;
	}

	public void start() {
		while (vendingMachine.isUsable(payments.getRemainMoney())) {
			requestTrading();
		}
	}

	private void requestTrading() {
		try {
			OutputView.printRemainMoney(payments.getRemainMoney());
			InputView.printProductForBuyingMessage();
			Integer amount = vendingMachine.trade(Console.readLine());
			payments.payProductValue(amount);
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
		}
	}

	public void returnChangeCoins() {
		OutputView.printRemainMoney(payments.getRemainMoney());
		OutputView.printChange(vendingMachine.returnChange(payments.getRemainMoney()));
	}
}

