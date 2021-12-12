package vendingmachine.service;

import java.util.List;

import vendingmachine.model.Coin;

public class GivingChangesService {
	public static int countCoinForChanges(List<Integer> coinList, Coin coin, int totalChanges) {
		int givingCoin = totalChanges / coin.getAmount();

		if (givingCoin > coinList.get(coin.ordinal())) {
			givingCoin = coinList.get(coin.ordinal());
		}

		return givingCoin;
	}
}
