package vendingmachine.view;

import vendingmachine.model.CoinStock;

import java.util.List;

public class MachineViewer {
	public void showCoinBoxStatus(List<CoinStock> coins) {
		System.out.println("\n자판기가 보유한 동전");
		coins.stream().forEach(System.out::println);
	}

	public void showRemainMoney(int money) {
		System.out.println("\n투입 금액: " + money + "원");
	}

	public void showReturnCoins(List<CoinStock> coins) {
		coins.stream().forEach(System.out::println);
	}
}
