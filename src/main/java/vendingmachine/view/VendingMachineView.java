package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.model.Coin;
import vendingmachine.model.repository.CoinRepository;
import vendingmachine.model.Customer;

public class VendingMachineView {

	public static final String INPUT_MONEY_FOR_CHANGE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String COINS_IN_VENDING_MACHINE_MESSAGE = "자판기가 보유한 동전";
	public static final String MONEY_COUNT_UNIT = "원";
	public static final String COIN_COUNT_UNIT = "개";
	public static final String HYPHEN = " - ";
	public static final String INPUT_PRODUCT_INFO_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String INPUT_MONEY_FOR_BUY_MESSAGE = "투입 금액을 입력해 주세요.";
	public static final String MONEY_FOR_BUY_AVAILABLE_PREFIX = "투입 금액: ";
	public static final String INPUT_NAME_FOR_BUY = "구매할 상품명을 입력해 주세요.";
	public static final String GIVE_CHANGE = "잔돈";

	public void inputMoneyForChange() {
		System.out.println(INPUT_MONEY_FOR_CHANGE_MESSAGE);
	}

	public void showCoinsInVendingMachine() {
		System.out.println(COINS_IN_VENDING_MACHINE_MESSAGE);

		HashMap<Coin, Integer> coinRepository = CoinRepository.instance.getCoinRepository();
		for (Coin coin : Coin.values()) {
			int amount = coin.getAmount();
			Integer coinCount = coinRepository.get(coin);
			System.out.println(amount + MONEY_COUNT_UNIT + HYPHEN + coinCount + COIN_COUNT_UNIT);
		}
	}

	public void inputProductInfo() {
		System.out.println(INPUT_PRODUCT_INFO_MESSAGE);
	}

	public void inputMoneyForBuy() {
		System.out.println(INPUT_MONEY_FOR_BUY_MESSAGE);
	}

	public void buyProduct(Customer customer) {
		System.out.println(MONEY_FOR_BUY_AVAILABLE_PREFIX + customer.getMoney() + MONEY_COUNT_UNIT);
		System.out.println(INPUT_NAME_FOR_BUY);
	}

	public void giveChange(int restMoney, HashMap<Coin, Integer> coinForChange) {
		System.out.println(MONEY_FOR_BUY_AVAILABLE_PREFIX + restMoney);
		System.out.println(GIVE_CHANGE);

		for (Coin coin : Coin.values()) {
			int amount = coin.getAmount();
			Integer coinCount = coinForChange.get(coin);
			if (coinCount != 0) {
				System.out.println(amount + MONEY_COUNT_UNIT + HYPHEN + coinCount + COIN_COUNT_UNIT);
			}
		}
	}

	public void makeEmptyLine() {
		System.out.println();
	}
}
