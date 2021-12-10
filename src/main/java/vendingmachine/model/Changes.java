package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.util.Money;

public class Changes {
	private List<Integer> coinList;
	private int changes;

	public Changes() {
		coinList = new ArrayList<Integer>();
		changes = 0;
	}

	public void setCoinList() {
		changes = Money.setMoney();
		coinList = Coin.getRandomCoinList(changes);
	}

	public int countCoin(int idx) {
		return coinList.get(idx);
	}

	public int giveChanges(Coin coin) {
		int givingCoin = changes / coin.getAmount();

		if (givingCoin > coinList.get(coin.ordinal())) {
			givingCoin = coinList.get(coin.ordinal());
		}

		changes -= givingCoin * coin.getAmount();
		return givingCoin;
	}
}
