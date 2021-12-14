package vendingmachine.view;

import java.util.Map;

import vendingmachine.model.domain.Coin;

public class OutputView {
	private static final String INSERT_MONEY = "투입 금액: %d원";
	private static final String COIN_AMOUNT = "%d원 - %d개";
	public static final String CHANGE = "잔돈";
	public static final String MACHINE_MONEY = "자판기가 보유한 동전";

	public void printInsertMoney(int insertMoney) {
		String insertMoneyMessage = String.format(INSERT_MONEY, insertMoney);
		System.out.println(insertMoneyMessage);
	}

	public void printCoinChange(Map<Coin, Integer> coinMap) {
		coinMap.forEach((key, value) -> {
			String coinMessage = String.format(COIN_AMOUNT, key.getAmount(), value);
			System.out.println(coinMessage);
		});
	}
}
