package vendingmachine.service;

import static vendingmachine.NumberConstant.*;

import java.util.Map;

import vendingmachine.domain.Coin;

public class OutputService {

	private static final CoinService coinService = new CoinService();

	private static final String MONEY_OF_VENDING_MACHINE = "자판기가 보유한 동전";
	public static final String WON = "원";
	private static final String STICK = " - ";
	private static final String UNIT = "개";
	private static final String CHANGE = "잔돈";
	private static final String INPUT_MONEY_MESSAGE = "투입 금액: ";

	public void printAllCoinCount() {
		System.out.println(MONEY_OF_VENDING_MACHINE);
		Coin.amountList
			.stream()
			.forEach(amount ->
				System.out.println(amount + WON + STICK + coinService.getCoinCount(amount) + UNIT));
		enter();
	}

	public void printChange(Map<Coin, Integer> change) {
		System.out.println(CHANGE);
		Coin.amountList
			.stream()
			.forEach(amount -> printChangeOfOneCoin(change, amount));
	}

	private void printChangeOfOneCoin(Map<Coin, Integer> change, int amount) {
		if (change.containsKey(Coin.getByAmount(amount)) && change.get(Coin.getByAmount(amount)) > ZERO) {
			System.out.println(amount + WON + STICK + change.get(Coin.getByAmount(amount)) + UNIT);
		}
	}

	public void printUserMoney(int money) {
		System.out.println((INPUT_MONEY_MESSAGE + money + WON));
	}

	public void enter() {
		System.out.println();
	}
}
