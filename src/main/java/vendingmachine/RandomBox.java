package vendingmachine;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.Coin.*;

import java.util.Map;
import java.util.TreeMap;

public enum RandomBox {
	RANDOM_COIN_BOX;

	public Map<Integer, Integer> getNumOfCoins(int amount){
		Map<Integer, Integer> coins = new TreeMap<>();
		while(amount>0) {
			int num = pickNumberInList(COIN_LIST);
			if (amount >= num) {
				amount -= num;
				// System.out.println(num+" -- " + amount);
				coins.put(num, coins.getOrDefault(num,0)+1);
			}
		}

		// System.out.println("----");
		// for(int key : coins.keySet()){
		// 	System.out.println(key +" - " + coins.get(key));
		// }
		return coins;
	}
}
