package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class InputData {
	private static final String SET_AMOUNT_MSG = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String SET_ITEM_MSG = "\n상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUT_MONEY_MSG = "\n투입 금액을 입력해 주세요.";
	private static final String BUY_ITEM_MSG = "구매할 상품명을 입력해 주세요.";

	public static int setAmount() {
		String amount;
		do {
			System.out.println(SET_AMOUNT_MSG);
			amount = Console.readLine();
		} while (!checkAmount(amount));

		return Integer.parseInt(amount);
	}

	public static boolean checkAmount(String amount) {
		try {
			InputException.checkAmount(amount);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static String[] setItem() {
		String[] items;
		do {
			System.out.println(SET_ITEM_MSG);
			items = Console.readLine().split(";");
		} while (!checkItem(items));

		return items;
	}

	public static boolean checkItem(String[] items) {
		try {
			InputException.checkItem(items);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static int inputMoney() {
		String Money;
		do {
			System.out.println(INPUT_MONEY_MSG);
			Money = Console.readLine();
		} while (!checkInputMoney(Money));

		Output.printMoney(Integer.parseInt(Money));
		return Integer.parseInt(Money);
	}

	public static boolean checkInputMoney(String Money) {
		try {
			InputException.checkInputMoney(Money);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static int buyItem(Items[] items) {
		String item;
		do {
			System.out.println(BUY_ITEM_MSG);
			item = Console.readLine();
		} while (checkBuyItem(items, item) == -1);
		return checkBuyItem(items, item);
	}

	public static int checkBuyItem(Items[] items, String item) {
		try {
			int itemsIndex = InputException.canBuy(items, item);
			return itemsIndex;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
}
