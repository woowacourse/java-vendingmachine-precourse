package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.domain.Coin;

public class OutputView {
	public static final String HOLDING_MONEY_ERROR = "[ERROR] 금액은 10이상의 숫자여야 합니다.";
	public static final String ITEM_INFORMATION_ERROR = "[ERROR] 형식에 맞게 입력해 주세요.";
	public static final String INPUT_MONEY_ERROR = "[ERROR] 투입 금액은 1이상의 숫자여야 합니다.";
	public static final String NOT_EXISTING_ITEM_ERROR = "[ERROR] 존재하지 않는 상품 입니다.";
	public static final String MONEY_EXCESS_ERROR = "[ERROR] 선택하신 상품의 금액이 투입 금액을 초과하였습니다.";

	public static final String COIN_500_STRING = "500원";
	public static final String COIN_100_STRING = "100원";
	public static final String COIN_50_STRING = "50원";
	public static final String COIN_10_STRING = "10원";

	public static final String MACHINE_OWN_COINS = "자판기가 보유한 동전";
	public static final String DASH_SIGN = " - ";
	public static final String COUNT_SIGN = "개";

	public static final String INPUT_MONEY = "투입 금액: ";
	public static final String WON_SIGN = "원";

	public static final String CHANGE = "잔돈";

	public static void printMoneyError() {
		System.out.println(HOLDING_MONEY_ERROR);
	}

	public static void printHoldingCoins(HashMap<Coin, Integer> holdingCoins) {
		System.out.println();
		System.out.println(MACHINE_OWN_COINS);
		System.out.println(COIN_500_STRING + DASH_SIGN + holdingCoins.get(Coin.COIN_500) + COUNT_SIGN);
		System.out.println(COIN_100_STRING + DASH_SIGN + holdingCoins.get(Coin.COIN_100) + COUNT_SIGN);
		System.out.println(COIN_50_STRING + DASH_SIGN + holdingCoins.get(Coin.COIN_50) + COUNT_SIGN);
		System.out.println(COIN_10_STRING + DASH_SIGN + holdingCoins.get(Coin.COIN_10) + COUNT_SIGN);
		System.out.println();
	}

	public static void printItemError() {
		System.out.println(ITEM_INFORMATION_ERROR);
	}

	public static void printInputMoneyError() {
		System.out.println(INPUT_MONEY_ERROR);
	}

	public static void printInputMoney(int money) {
		System.out.println(INPUT_MONEY + money + WON_SIGN);
	}

	public static void printNotExistingItemError() {
		System.out.println(NOT_EXISTING_ITEM_ERROR);
	}

	public static void printMoneyExcessError() {
		System.out.println(MONEY_EXCESS_ERROR);
	}

	public static void printChange(HashMap<Coin, Integer> coinCount) {
		System.out.println(CHANGE);
		for (Coin coin : Coin.getCoinArray()) {
			if (coinCount.get(coin) != 0) {
				System.out.println(
					coin.getAmount() + WON_SIGN + DASH_SIGN + coinCount.get(coin) + COUNT_SIGN);
			}
		}
	}
}
