package vendingmachine;

import java.util.List;

public class ResultView {
	private static final String REMAINS_MESSAGE = "자판기가 보유한 동전";

	public static void printRemains(List<Coin> coinList) {
		System.out.println(REMAINS_MESSAGE);
		for (Coin coin : coinList) {
			System.out.println(coin.getValue() + "원 - " + coin.getCount() + "개");
		}
	}

	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine();
		machine.generateRemainCoins(3000);
		printRemains(machine.getCoins());
	}
}
