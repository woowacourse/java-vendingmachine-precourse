package vendingmachine;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class InputData {
	private static final String SET_AMOUNT_MSG = "자판기가 보유하고 있는 금액을 입력해 주세요.";

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
			System.out.println("상품명과 가격, 수량을 입력해 주세요.");
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
}
