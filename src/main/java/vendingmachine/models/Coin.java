package vendingmachine.models;

import java.util.ArrayList;
import java.util.stream.Collectors;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	private static int getNowCoin(ArrayList<Item> coins, int money) {
		return camp.nextstep.edu.missionutils.Randoms.pickNumberInList(coins.stream()
			.filter(eachCoin -> eachCoin.getPrice() <= money)
			.map(Item::getPrice)
			.collect(Collectors.toList()));
	}
}
