package vendingmachine;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		int amount = InputData.setAmount();

		VendingMachine vendingmachine = new VendingMachine();
		List<Integer> coinList = vendingmachine.randomCoin(amount);
		Items[] items = vendingmachine.makeItem();
		VendingMachine.start(items, coinList, amount);
	}
}
