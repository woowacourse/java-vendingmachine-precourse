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

	private static int getRandomCoin(ArrayList<Item> coins, int money) {
		return camp.nextstep.edu.missionutils.Randoms.pickNumberInList(coins.stream()
			.filter(eachCoin -> eachCoin.getPrice() <= money)
			.map(Item::getPrice)
			.collect(Collectors.toList()));
	}

	private static int calculateReturnedCoinValue(ArrayList<Item> coinList, int money) {
		return coinList.stream()
			.sorted((coin1, coin2) -> coin2.getPrice() - coin1.getPrice())
			.filter(eachCoin -> (!eachCoin.isOverThisPrice(money) && !eachCoin.isAmountZero()))
			.findFirst()
			.get()
			.getPrice();
	}

	private static int calculateReturnedCoinAmount(ArrayList<Item> coinList, int coinValue, int money) {
		return coinList.stream()
			.filter(eachCoin -> eachCoin.getPrice() == coinValue)
			.map(eachCoin -> Math.min(money / coinValue, eachCoin.getAmount()))
			.findFirst()
			.get();
	}

	private static void decreaseCoinAmount(ArrayList<Item> coinList, int valueOfReturnedCoin, int amountOfReturnedCoin) {
		coinList.stream()
			.filter(eachCoin -> eachCoin.getPrice() == valueOfReturnedCoin)
			.forEach(eachCoin -> eachCoin.decreaseAmount(amountOfReturnedCoin));
	}

	private static int isCoinListEmpty(ArrayList<Item> coinList) {
		return coinList.stream().mapToInt(Item::getAmount).sum();
	}

	private static void increaseCoinAmount(ArrayList<Item> coinList, int valueOfNowCoin, int amountOfNowCoin) {
		coinList.stream()
			.filter(eachCoin -> eachCoin.getPrice() == valueOfNowCoin)
			.forEach(eachCoin -> eachCoin.increaseAmount(amountOfNowCoin));
	}
}
