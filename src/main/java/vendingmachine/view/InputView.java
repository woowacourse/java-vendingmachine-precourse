package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.MachineMoneyValidator;

public class InputView {
	public static final String REQUEST_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	private MachineMoneyValidator machineMoneyValidator = new MachineMoneyValidator();

	public int enterMachineMoney() {
		try {
			System.out.println(REQUEST_MACHINE_MONEY);
			String inputValue = Console.readLine();
			machineMoneyValidator.validateMachineMoney(inputValue);
			return Integer.parseInt(inputValue);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return enterMachineMoney();
		}
	}
}
