package vendingmachine.model;

import java.util.List;

import vendingmachine.service.CountingCoinForGivingChangesService;
import vendingmachine.service.MakingRandomCoinService;
import vendingmachine.service.SettingMoneyService;

public class Changes {
	private List<Integer> coinList;

	public Changes(String initCoin) {
		coinList = MakingRandomCoinService.getRandomCoinList(SettingMoneyService.setMoney(initCoin));
	}

	public int countCoin(Coin coin) {
		return coinList.get(coin.ordinal());
	}

	public int give(Coin coin, int remainMoney) {
		int givingCoin = CountingCoinForGivingChangesService.countCoinForChanges(coinList.get(coin.ordinal()), coin,
			remainMoney);
		coinList.set(coin.ordinal(), coinList.get(coin.ordinal()) - givingCoin);
		return givingCoin;
	}
}
