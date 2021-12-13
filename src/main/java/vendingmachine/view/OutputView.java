package vendingmachine.view;

import static vendingmachine.constant.Constant.*;

import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinStorage;

public class OutputView {

	public static void breakLine() {
		System.out.println();
	}

	public static void setVendingMachineMoney() {
		System.out.println(ENTER_VENDING_MACHINE_INITIAL_MONEY);
	}

	public static void showCoins(CoinStorage coinStorage) {
		System.out.println(VENDING_MACHINE_COINS);
		for (Coin coin : coinStorage.checkbox().keySet()) {
			System.out.println(coin.getAmount() + RULES_TO_SHOW + coinStorage.checkbox().get(coin) + NUMBER);
		}
		System.out.println();
	}

	public static void addProductAndNumbers() {
		System.out.println(ENTER_PRODUCT_AND_NUMBER);
	}

	public static void enterInputMoney() {
		System.out.println(ENTER_INPUT_MONEY);
	}

	public static void showRemainingMoney(int money) {
		System.out.println(INPUT_MONEY + money + WON);
	}

	public static void enterWantProduct() {
		System.out.println(ENTER_WANT_TO_BUY_PRODUCT);
	}

	public static void showCoinStorageState(CoinStorage coinStorage) {
		System.out.println(REMAINING_MONEY);
		coinStorage.checkbox().entrySet().stream()
			.filter(key -> key.getValue() > 0)
			.forEach(key -> System.out.println(key.getKey().getAmount() + RULES_TO_SHOW + key.getValue() + NUMBER));
	}
}
