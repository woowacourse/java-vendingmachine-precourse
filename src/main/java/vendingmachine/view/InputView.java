package vendingmachine.view;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Money;
import vendingmachine.validator.InputValidator;

public class InputView {
	private static final String INPUT_HAVING_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String INPUT_ITEM_PRICE_STOCK = "\n상품명과 가격, 수량을 입력해 주세요.";
	private static final String USER_INPUT_MONEY = "\n투입 금액을 입력해 주세요.";
	private static final String INPUT_PURCHASE_ITEM_NAME = "구매할 상품명을 입력해 주세요.";

	public static Money getHavingMoney() {
		System.out.println(INPUT_HAVING_MONEY);
		return new Money(InputValidator.checkMoneyForm(Console.readLine()));

	}

	public static ArrayList<String> getItemPriceStock() {
		System.out.println(INPUT_ITEM_PRICE_STOCK);
		String input = Console.readLine();
		return InputValidator.checkInputForm(input);
	}

	public static Money getUserInputMoney() {
		System.out.println(USER_INPUT_MONEY);
		return new Money(InputValidator.checkMoneyForm(Console.readLine()));
	}

	public static String getItemName() {
		System.out.println(INPUT_PURCHASE_ITEM_NAME);
		return Console.readLine();
	}
}
