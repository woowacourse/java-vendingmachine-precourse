package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String ENTER_VENDING_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public int getInputOfVendingMachineMoney() {
		try {
			System.out.println(ENTER_VENDING_MACHINE_MONEY);
			String vendingMachineMoney = Console.readLine();
			MoneyValidation.validateVendingMachineMoney(vendingMachineMoney);
			return Integer.parseInt(vendingMachineMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_MESSAGE + e.getMessage());
			return getInputOfVendingMachineMoney();
		}
	}
}
