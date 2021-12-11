package vendingmachine.domain;

import java.util.EnumMap;

import vendingmachine.enums.Coin;

public class VendingMachineCoin {
	private EnumMap<Coin, Integer> coinStorage;

	public VendingMachineCoin(int coinMoney) {
		init();
		randomGenerate(coinMoney);
	}

	private void init() {
		this.coinStorage = new EnumMap<Coin, Integer>(Coin.class);
	}

	private void randomGenerate(int coinMoney) {

	}
}
