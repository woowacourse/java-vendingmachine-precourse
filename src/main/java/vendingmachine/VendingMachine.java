package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private ArrayList<Product> products = null;

	public VendingMachine(int amount) {
		getRandomCoin(1, 1);
		for (Coin c: Coin.values()) {
			if (c.getAmount() == 10) {
				c.increaseCount(amount / c.getAmount());
				break;
			}
			int num = getRandomCoin(0, amount / c.getAmount());
			c.increaseCount(num);
			amount -= c.getAmount() * num;
		}
	}

	public int getRandomCoin(int start, int end) {
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < end + 1; i++) {
			li.add(start + i);
		}
		return Randoms.pickNumberInList(li);
	}


}
