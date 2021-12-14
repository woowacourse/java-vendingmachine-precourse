package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Count;

public class OutputView {
	private static final String HOLDING_COINS_GUIDE_MESSEAGE = "자판기가 보유한 동전";
	private static final String HOLDING_COINS_CONNECTOR = "원 - ";
	private static final String HOLDING_COINS_GUIDE_MESSEAGE_SUFFIX = "개";
	private static final String INPUT_MONEY_GUIDE_MESSEAGE = "투입 금액: ";
	private static final String INPUT_MONEY_GUIDE_MESSEAGE_SUFFIX = "원";
	private static final String CHANGE_GUIDE_MESSEAGE = "잔돈";
	private static final String CHANGE_GUIDE_MESSEAGE_SUFFIX = "개";
	private static final String NOT_HAVE_PRODUCT_GUIDE_MESSEEAGE = "[ERROR] 구매하려는 상품이 자판기 내에 없습니다. 다른 상품을 선택해주세요.";
	private static final String PRODUCT_PRICE_EXPENSIVE_GUIDE_MESSEEAGE = "[ERROR] 구매하려는 상품이 투입한 금액보다 비쌉니다. 다른 상품을 선택해주세요.";

	public static void printHoldingCoins(Map<Coin, Count> coins) {
		System.out.println();
		System.out.println(HOLDING_COINS_GUIDE_MESSEAGE);
		for (Coin coin : coins.keySet()) {
			System.out.print(coin.getAmount());
			System.out.print(HOLDING_COINS_CONNECTOR);
			System.out.print(coins.get(coin).getCount());
			System.out.println(HOLDING_COINS_GUIDE_MESSEAGE_SUFFIX);
		}
	}

	public static void printInputMoney(int inputMoney) {
		System.out.println();
		System.out.print(INPUT_MONEY_GUIDE_MESSEAGE);
		System.out.print(inputMoney);
		System.out.println(INPUT_MONEY_GUIDE_MESSEAGE_SUFFIX);
	}

	public static void printChange(Map<Integer, Integer> changes) {
		System.out.println(CHANGE_GUIDE_MESSEAGE);
		for (Integer coin : changes.keySet()) {
			if (changes.get(coin) == 0) {
				continue;
			}
			System.out.print(coin);
			System.out.print(HOLDING_COINS_CONNECTOR);
			System.out.print(changes.get(coin));
			System.out.println(CHANGE_GUIDE_MESSEAGE_SUFFIX);
		}
	}

	public static void printErrorNotHaveProduct() {
		try {
			throw new IllegalArgumentException(NOT_HAVE_PRODUCT_GUIDE_MESSEEAGE);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void printErrorProductPriceHigherThanInputMoney() {
		try {
			throw new IllegalArgumentException(PRODUCT_PRICE_EXPENSIVE_GUIDE_MESSEEAGE);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}
}
