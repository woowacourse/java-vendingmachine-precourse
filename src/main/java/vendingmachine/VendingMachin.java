package vendingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachin {
	public List randomCoin(int amount) {
		List coinList = new ArrayList();

		while (amount != 0) {
			Coin coin = Coin.getRandomCoin(randomIndex());
			int coinValue = coin.getAmount();

			if (amount - coinValue >= 0) {
				amount -= coinValue;
				coinList.add(coinValue);
			}
		}
		Collections.sort(coinList, Collections.reverseOrder());
		System.out.println(coinList);
		return coinList;
	}

	public int randomIndex() {
		int index = Randoms.pickNumberInRange(0, 3);

		return index;
	}
}
