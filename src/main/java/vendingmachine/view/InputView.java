package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.VendingMachine;
import vendingmachine.utils.exception.MoneyException;
import vendingmachine.utils.exception.ProductException;

public class InputView {

	private InputView() {
	}

	public static int writeVendingMachineAmount() {
		OutputView.askVendingMachineAmount();
		return writeInputMoney();
	}

	public static String writeProductsInfo() {
		OutputView.askProductInfo();
		String inputProductsInfo = Console.readLine();
		ProductException.validateInputProductsInfo(inputProductsInfo);
		return inputProductsInfo;
	}

	public static int writeInsertMoney() {
		OutputView.askInsertMoney();
		return writeInputMoney();
	}

	public static String writeProductNameToBuy(VendingMachine vendingMachine) {
		OutputView.printInsertedMoney(vendingMachine);
		OutputView.askProductToBuy();
		String inputName = Console.readLine();
		try {
			ProductException.validateName(inputName, vendingMachine);
			ProductException.validateSoldOut(inputName, vendingMachine.getProducts());
			return inputName;
		} catch (IllegalArgumentException IAE) {
			OutputView.printError(IAE);
			return writeProductNameToBuy(vendingMachine);
		}
	}

	private static int writeInputMoney() {
		try {
			String inputMoney = Console.readLine();
			MoneyException.validateInputMoney(inputMoney);
			int money = Integer.parseInt(inputMoney);
			MoneyException.validateMoney(money);
			return money;
		} catch (IllegalArgumentException IAE) {
			OutputView.printError(IAE);
			return writeVendingMachineAmount();
		}
	}
}
