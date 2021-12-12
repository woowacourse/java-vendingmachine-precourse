package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.domain.Machine;
import vendingmachine.util.CoinGenerator;

public class MachineService {
	public void addCoins(Machine machine, Integer totalCoin) {
		Map<Coin, Integer> generatedCoins = CoinGenerator.generate(Coin.getCoinList(), totalCoin);
		machine.addCoins(generatedCoins);
	}

	public void addInputCoins(Machine machine, Integer amount) {
		machine.addInputCoinAmount(amount);
	}

	public void addItems(Machine machine, Map<String, Item> items) {
		machine.addItems(items);
	}

	public void purchase(Machine machine, String itemName) throws IllegalArgumentException{
		machine.purchase(itemName);
	}

	public Boolean isPurchasable(Machine machine) {
		return machine.isPurchasable();
	}
}
