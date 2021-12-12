package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.service.GivingChangesService;
import vendingmachine.service.MakingRandomCoinService;
import vendingmachine.service.SettingMoneyService;

public class Changes {
	private List<Integer> coinList;
	private int changes;

	public Changes() {
		coinList = new ArrayList<Integer>();
		changes = 0;
	}

	public void setCoinList(String initCoin) {
		changes = SettingMoneyService.setMoney(initCoin);
		coinList = MakingRandomCoinService.getRandomCoinList(changes);
	}

	public int countCoin(Coin coin) {
		return coinList.get(coin.ordinal());
	}

	public int giveChanges(Coin coin) {
		int givingCoin = GivingChangesService.countCoinForChanges(coinList, coin, changes);
		changes -= givingCoin * coin.getAmount();
		return givingCoin;
	}
}
