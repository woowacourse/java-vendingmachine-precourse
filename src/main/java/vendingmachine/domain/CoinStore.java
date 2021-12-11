package vendingmachine.domain;

import static vendingmachine.utils.Constant.*;

import java.util.EnumMap;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinStore {
	private static final int INITIAL_VALUE = 0;
	private final EnumMap<Coin, Integer> coins = new EnumMap<Coin, Integer>(Coin.class) {
		{
			put(Coin.COIN_500, INITIAL_VALUE);
			put(Coin.COIN_100, INITIAL_VALUE);
			put(Coin.COIN_50, INITIAL_VALUE);
			put(Coin.COIN_10, INITIAL_VALUE);
		}
	};
	private final EnumMap<Coin, Integer> changeCoins = new EnumMap<>(coins);

	public CoinStore(int money) {
		createRandomCoins(money);
	}

	private void createRandomCoins(int money) {
		while (Coin.checkIsAtLeastCoin(money)) {
			int randomCoin = findRandomCoin();
			if (randomCoin <= money) {
				money -= randomCoin;
				plusCoin(randomCoin);
			}
		}
	}

	private void plusCoin(int money) {
		Coin findCoin = Coin.findCoin(money);
		coins.put(findCoin, coins.get(findCoin) + PLUS_COIN_ELEMENT);
	}

	private int findRandomCoin() {
		return Randoms.pickNumberInList(Coin.findCoinListByInteger());
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int amountOfCoin : Coin.getAmountListOfCoin()) {
			stringBuilder.append(amountOfCoin).append(WON_REPRESENT_UNIT);
			stringBuilder.append(DELIMITER_OF_COIN_STORE_STATUS_REPRESENT);
			stringBuilder.append(coins.get(Coin.findCoin(amountOfCoin))).append(COIN_REPRESENT_UNIT);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	private void makeChangeCoins(int amount) {
		while (Coin.checkIsAtLeastCoin(amount)) {
			Coin biggestChangeCoin = findBiggestPossibleChangeCoin();
			if (biggestChangeCoin == null) {
				return;
			}
			amount = biggestChangeCoin.getChangeAmount(amount);
			changeCoins.put(biggestChangeCoin, changeCoins.get(biggestChangeCoin) + ONE_COIN);
		}
	}

	private Coin findBiggestPossibleChangeCoin() {
		for (Coin coin : coins.keySet()) {
			if (coins.get(coin) > NO_COIN) {
				coins.put(coin, coins.get(coin) - ONE_COIN);
				return coin;
			}
		}
		return null;
	}

	public String changeCoinsToString(int amount) {
		makeChangeCoins(amount);
		StringBuilder stringBuilder = new StringBuilder();
		for (Coin amountOfCoin : changeCoins.keySet()) {
			if (changeCoins.get(amountOfCoin) > NO_COIN) {
				stringBuilder.append(amountOfCoin.toString());
				stringBuilder.append(DELIMITER_OF_COIN_STORE_STATUS_REPRESENT);
				stringBuilder.append(changeCoins.get(amountOfCoin)).append(COIN_REPRESENT_UNIT);
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}
}
