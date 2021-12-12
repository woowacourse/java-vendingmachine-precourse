package vendingmachine.model;

import java.util.List;

import vendingmachine.service.CountingCoinForGivingChangesService;
import vendingmachine.service.MakingRandomCoinService;
import vendingmachine.service.SettingMoneyService;

public class Changes {
	private List<Integer> coinList;
	private int changes;

	public Changes(String initCoin) {
		changes = SettingMoneyService.setMoney(initCoin);
		coinList = MakingRandomCoinService.getRandomCoinList(changes);
	}

	public int countCoin(Coin coin) {
		return coinList.get(coin.ordinal());
	}

	public int give(Coin coin, int remainMoney) {
		int givingCoin = CountingCoinForGivingChangesService.countCoinForChanges(coinList.get(coin.ordinal()), coin,
			remainMoney);
		changes -= givingCoin * coin.getAmount();
		coinList.set(coin.ordinal(), coinList.get(coin.ordinal()) - givingCoin);
		return givingCoin;
	}
}
