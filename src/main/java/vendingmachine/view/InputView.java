package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.ExceptionUtils;

public class InputView {

	private InputView() {
	}

	public static int writeVendingMachineAmount() {
		OutputView.askVendingMachineAmount();
		String inputMoney = Console.readLine();
		try {
			ExceptionUtils.validateInputMoney(inputMoney);
			int money = Integer.parseInt(inputMoney);
			ExceptionUtils.validateMoney(money);
			return money;
		} catch (IllegalArgumentException IAE) {
			OutputView.printError(IAE);
			return writeVendingMachineAmount();
		}
	}

	public static String writeProductsInfo() {
		OutputView.askProductInfo();
		try {
			return ExceptionUtils.validateInputProductsInfo(Console.readLine());
		} catch (IllegalArgumentException IAE) {
			OutputView.printError(IAE);
			return writeProductsInfo();
		}
	}
}
