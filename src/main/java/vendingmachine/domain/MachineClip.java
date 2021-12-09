package vendingmachine.domain;

import static vendingmachine.domain.Coin.*;

import java.util.Map;
import java.util.TreeMap;

public enum MachineClip {
	MACHINE_CLIP;
	private Map<Integer, Integer> numOfCoins;

	public void initMachine(Map<Integer, Integer> input) {
		numOfCoins = new TreeMap<Integer, Integer>((o1,o2)->o2-o1) {
			{
				getCoinStream()
					.forEach(c -> put(c.getValue(), 0));
			}
		};

		// System.out.println(numOfCoins.size());
		// for(int key : numOfCoins.keySet()){
		// 	System.out.println("#" + key);
		// }

		for (int key : input.keySet()) {
			numOfCoins.put(key, input.get(key));
		}
	}

	public void getChange(int amount){
		for (int key : numOfCoins.keySet()) {
			if(amount>0 && amount >= key){
				int c = amount/key;
				if(c > numOfCoins.get(key)){
					amount -= key*numOfCoins.get(key);
					System.out.println(key +"원 - " + numOfCoins.get(key) +"개");
					numOfCoins.put(key, 0);
					continue;
				}
				amount -= c*key;
				numOfCoins.put(key, numOfCoins.get(key)-c);
				System.out.println(key +"원 - " + c +"개");
			}
		}
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
