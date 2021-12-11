package vendingmachine.payments;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;

public class PaymentsController {

	public Payments insertMoney() {
		InputView.printInsertMoneyMessage();
		Payments payments = new Payments();
		requestInsertMoney(payments);
		return payments;
	}

	private void requestInsertMoney(Payments payments) {
		try {
			payments.insert(Console.readLine());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
			requestInsertMoney(payments);
		}
	}
}
