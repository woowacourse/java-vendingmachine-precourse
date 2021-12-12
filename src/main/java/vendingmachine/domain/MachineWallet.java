package vendingmachine.domain;

import static vendingmachine.config.ConstantConfig.*;
import static vendingmachine.domain.Coin.*;

import java.util.Map;
import java.util.TreeMap;

public class MachineWallet {
	private Map<Integer, Integer> numOfCoins;
	private Map<Integer, Integer> numOfChanges;
	private int customerAmount;

	public MachineWallet() {
		this.numOfChanges = new TreeMap<>((o1, o2) -> o2 - o1);
		this.numOfCoins = new TreeMap<>((o1, o2) -> o2 - o1);
	}

	public void save(Map<Integer, Integer> numOfCoins) {
		getCoinStream().forEach(c -> this.numOfCoins.put(c.getValue(), 0));
		numOfCoins.keySet().stream().forEach(k -> this.numOfCoins.put(k, numOfCoins.get(k)));
	}

	public Map<Integer, Integer> saveChangesByAmount(int amount) {
		this.customerAmount = amount;
		numOfCoins.keySet().stream().forEach(k -> exchangeAmountToChanges(k));
		return numOfChanges;
	}

	private void exchangeAmountToChanges(int coinType) {
		int numOfCoin = numOfCoins.get(coinType);
		if (customerAmount > 0 && customerAmount >= coinType) {
			int numOfChangeCoin = customerAmount / coinType;
			if (numOfChangeCoin > numOfCoin) {
				getChange(coinType, numOfCoin, numOfCoin);
				return;
			}
			getChange(coinType, numOfCoin, numOfChangeCoin);
		}
	}

	private void getChange(int key, int total, int numOfCoin) {
		customerAmount -= (key * numOfCoin);
		numOfChanges.put(key, numOfCoin);
		numOfCoins.put(key, total - numOfCoin);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		getCoinStream()
			.map(c -> c.getValue())
			.forEach(
				c -> sb.append(String.format(OUTPUT_CUSTOMER_NUN_OF_CHANGES + LINE_SEPARATOR, c, numOfCoins.get(c))));
		return sb.toString();
	}
}
