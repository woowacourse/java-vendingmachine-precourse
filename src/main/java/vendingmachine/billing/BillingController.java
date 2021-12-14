package vendingmachine.billing;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class BillingController {
	private static final String CHANGES_PREFIX = "자판기가 보유하는 ";
	private static final String PAYMENTS_PREFIX = "자판기에 투입하는 ";

	private MoneyValidator moneyValidator;
	private Changes changes;
	private Payments payments;

	public BillingController() {
		moneyValidator = new MoneyValidator();
		changes = new Changes();
		payments = new Payments();
	}

	public Changes readyToChanges() {
		InputView.printInitialMoneySettingMessage();
		requestInitialMoney();
		return changes;
	}

	private void requestInitialMoney() {
		try {
			String initialMoney = Console.readLine();
			moneyValidator.validate(initialMoney, CHANGES_PREFIX);
			changes.input(new Money(initialMoney));
			changes.createRandomCoins();
			OutputView.printVendingMachineOwnCoins(changes.getCoins());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.printMessage(illegalArgumentException);
			requestInitialMoney();
		}
	}

	public Payments insertMoney() {
		InputView.printInsertMoneyMessage();
		requestInsertMoney();
		return payments;
	}

	private void requestInsertMoney() {
		try {
			String paymentsMoney = Console.readLine();
			moneyValidator.validate(paymentsMoney, PAYMENTS_PREFIX);
			payments.insert(new Money(paymentsMoney));
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.printMessage(illegalArgumentException);
			requestInsertMoney();
		}
	}

	public void returnChangeCoins() {
		OutputView.printRemainMoney(payments.getRemainMoney());
		OutputView.printChange(changes.calculateChange(payments.getRemainMoney()));
	}
}
