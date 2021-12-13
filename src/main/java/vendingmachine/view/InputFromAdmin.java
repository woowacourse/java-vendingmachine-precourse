package vendingmachine.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utill.InputValidator;

public class InputFromAdmin {
	private static final String MACHINE_MONEY_INPUT_MSG = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String ITEM_INPUT_MSG = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String DELIMITER = ";";

	private InputValidator inputValidator = new InputValidator();

	public int inputMachineMoney() {
		System.out.println(MACHINE_MONEY_INPUT_MSG);
		String inputAmount = Console.readLine();

		int amount = inputValidator.validMachineMoney(inputAmount);

		if (amount >= 0) {
			return amount;
		}
		return inputMachineMoney();
	}

	public List<String> inputItems() {
		System.out.println(ITEM_INPUT_MSG);
		String items = Console.readLine();
		List<String> itemList = splitInputItems(items);

		if (inputValidator.validItemList(itemList)) {
			return itemList;
		}
		return inputItems();
	}

	private List<String> splitInputItems(String items) {
		return Arrays.asList(items.split(DELIMITER));
	}
}
