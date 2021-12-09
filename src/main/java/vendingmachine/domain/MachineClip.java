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

	MachineClip(){
		this.amountToChanges = new HashMap<>();
		this.numOfCoins = new TreeMap<>((o1,o2)->o2-o1);
	}

	public void initMachine(Map<Integer, Integer> input) {
		getCoinStream().forEach(c -> numOfCoins.put(c.getValue(), 0));

		for (int key : input.keySet()) {
			numOfCoins.put(key, input.get(key));
		}
	}

	public Map<Integer,Integer> getAmountToChanges(int amount){
		this.amount = amount;

		for (int key : numOfCoins.keySet()) {
			exchangeAmountToChanges(key);
		}
		return amountToChanges;
	}

	private void exchangeAmountToChanges(int key) {
		if(amount>0 && amount >= key){
			int c = amount/key;
			if(c > numOfCoins.get(key)){
				getAmountToChanges(key, numOfCoins.get(key), numOfCoins.get(key));
				return;
			}
			getAmountToChanges(key, numOfCoins.get(key), c);
		}
	}

	private void getAmountToChanges(int key, int total, int numOfCoin) {
		amount -= key*numOfCoin;
		amountToChanges.put(key, numOfCoin);
		numOfCoins.put(key, total-numOfCoin);
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
