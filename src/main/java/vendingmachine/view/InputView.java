package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.ExceptionUtils;

public class InputView {

	private InputView() {
	}

	public static String writeVendingMachineAmount() {
		OutputView.askVendingMachineAmount();
		String inputMoney = Console.readLine();
		try {
			ExceptionUtils.validateMoney(inputMoney);
			return inputMoney;
		} catch (IllegalArgumentException IAE) {
			OutputView.printError(IAE);
			return writeVendingMachineAmount();
		}
	}
}
