package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.ItemValidator;
import vendingmachine.utils.MachineMoneyValidator;

public class InputView {
	public static final String REQUEST_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String REQUEST_ITEM_INFO = "상품명과 가격, 수량을 입력해 주세요.";

	private MachineMoneyValidator machineMoneyValidator = new MachineMoneyValidator();
	private ItemValidator itemValidator = new ItemValidator();

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

	public String enterItems() {
		try {
			System.out.println(REQUEST_ITEM_INFO);
			String inputValue = Console.readLine();
			itemValidator.validateItems(inputValue);
			return inputValue;//TODO 입력값을 세미콜론 기준으로 나눠서 목록으로 제공
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return enterItems();
		}
	}
}
