package vendingmachine.view;

import vendingmachine.model.Coin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MachineViewer {

	public void showCoinBoxStatus(HashMap<Coin, Integer> coinBox) {
		System.out.println("\n자판기가 보유한 동전");
		Arrays.stream(Coin.values())
				.sorted(Comparator.comparing(Enum::ordinal))
				.forEach(coin -> System.out.println(coin.toString() + coinBox.get(coin) + "개"));
	}

	public void showRemainMoney(int money) {
		System.out.println("\n투입 금액: " + money + "원");
	}

	public void showReturnCoins(HashMap<Integer, Integer> coins) {
		Arrays.sort(coins.keySet().toArray());
		for (int coinAmount : coins.keySet()) {
			System.out.println(Coin.getCoinByAmount(coinAmount).toString() + coins.get(coinAmount) + "개");
		}
	}
}
