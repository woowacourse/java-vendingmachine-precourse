package vendingmachine.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utill.InputItemValidator;
import vendingmachine.utill.InputMoneyValidator;

public class InputFromUserView {
	private static final String USER_MONEY_INPUT_MSG = "투입 금액을 입력해 주세요.";
	private static final String PURCHASE_ITEM_INPUT_MSG = "구매할 상품명을 입력해 주세요.";
	private static final int INVALID_USER_MONEY_BOUNDARY = 0;

	private InputMoneyValidator inputMoneyValidator;
	private InputItemValidator inputItemValidator;

	public InputFromUserView(InputMoneyValidator inputMoneyValidator, InputItemValidator inputItemValidator) {
		this.inputMoneyValidator = inputMoneyValidator;
		this.inputItemValidator = inputItemValidator;
	}

	public int inputMoneyFromUser() {
		System.out.println("\n" + USER_MONEY_INPUT_MSG);
		String inputAmount = Console.readLine();

		int amount = inputMoneyValidator.validateMoney(inputAmount, INVALID_USER_MONEY_BOUNDARY);
		if (amount >= 0) {
			return amount;
		}
		return inputMoneyFromUser();
	}

	public String inputItemName(List<String> itemList) {
		System.out.println(PURCHASE_ITEM_INPUT_MSG);
		String itemName = Console.readLine();

		if (inputItemValidator.validateInputItemName(itemList, itemName)) {
			return itemName;
		}
		return inputItemName(itemList);
	}
}
