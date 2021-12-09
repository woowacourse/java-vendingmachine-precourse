package vendingmachine.domain;

import static vendingmachine.domain.Coin.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public enum MachineClip {
	MACHINE_CLIP;

	private Map<Integer, Integer> numOfCoins;
	private Map<Integer, Integer> amountToChanges;
	private int amount;

	MachineClip() {
		this.amountToChanges = new HashMap<>();
		this.numOfCoins = new TreeMap<>((o1, o2) -> o2 - o1);
	}

	public void initMachine(Map<Integer, Integer> numOfCoins) {
		getCoinStream().forEach(c -> this.numOfCoins.put(c.getValue(), 0));
		numOfCoins.keySet().stream().forEach(k -> this.numOfCoins.put(k, numOfCoins.get(k)));
	}

	public Map<Integer, Integer> getAmountToChanges(int amount) {
		this.amount = amount;
		numOfCoins.keySet().stream().forEach(k -> exchangeAmountToChanges(k));
		return amountToChanges;
	}

	private void exchangeAmountToChanges(int coinType) {
		int numOfCoin = numOfCoins.get(coinType);
		if (amount > 0 && amount >= coinType) {
			int numOfChangeCoin = amount / coinType;
			if (numOfChangeCoin > numOfCoin) { // 잔돈으로 반환해야하는 수(numOfChangeCoin)보다 현재 보유코인 갯수(numOfCoin)가 부족할 때
				getAmountToChanges(coinType, numOfCoin, numOfCoin);
				return;
			}
			getAmountToChanges(coinType, numOfCoin, numOfChangeCoin);
		}
	}

	private void getAmountToChanges(int key, int total, int numOfCoin) {
		amount -= key * numOfCoin;
		amountToChanges.put(key, numOfCoin);
		numOfCoins.put(key, total - numOfCoin);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		getCoinStream()
			.map(c -> c.getValue())
			.forEach(c -> sb.append(c + "원 - " + numOfCoins.get(c) + "개\n"));
		return sb.toString();
	}
}
