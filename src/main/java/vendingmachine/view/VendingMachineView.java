package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.model.Coin;
import vendingmachine.model.repository.CoinRepository;

public class VendingMachineView {

	public static final String INPUT_MONEY_FOR_CHANGE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String COINS_IN_VENDING_MACHINE_MESSAGE = "자판기가 보유한 동전";
	public static final String MONEY_COUNT_UNIT = "원";
	public static final String COIN_COUNT_UNIT = "개";
	public static final String HYPHEN = " - ";

	public void inputMoneyForChange() {
		System.out.println(INPUT_MONEY_FOR_CHANGE_MESSAGE);
	}

	public void showCoinsInVendingMachine() {
		System.out.println(COINS_IN_VENDING_MACHINE_MESSAGE);

		HashMap<String, Integer> coinRepository = CoinRepository.instance.getCoinRepository();
		for (Coin coin : Coin.values()) {
			int amount = coin.getAmount();
			Integer coinCount = coinRepository.get(String.valueOf(amount));
			System.out.println(amount + MONEY_COUNT_UNIT + HYPHEN + coinCount + COIN_COUNT_UNIT);
		}
	}

	public void makeEmptyLine() {
		System.out.println();
	}
}
