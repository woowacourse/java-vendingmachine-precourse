package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class InputData {
	private static final String SET_AMOUNT_MSG = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String SET_ITEM_MSG = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUT_MONEY_MSG = "투입 금액을 입력해 주세요.";

	public int setAmount() {
		String amount;
		do {
			System.out.println(SET_AMOUNT_MSG);
			amount = Console.readLine();
		} while (!checkAmount(amount));

		return Integer.parseInt(amount);
	}

	public boolean checkAmount(String amount) {
		try {
			InputException.checkAmount(amount);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public String[] setItem() {
		String[] items;
		do {
			System.out.println(SET_ITEM_MSG);
			items = Console.readLine().split(";");
		} while (!checkItem(items));

		return items;
	}

	public boolean checkItem(String[] items) {
		try {
			InputException.checkItem(items);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public int inputMoney() {
		String Money;
		do {
			System.out.println(INPUT_MONEY_MSG);
			Money = Console.readLine();
		} while (!checkInputMoney(Money));
		return Integer.parseInt(Money);
	}

	public boolean checkInputMoney(String Money) {
		try {
			InputException.checkInputMoney(Money);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
