package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinBox {
	private static final int NUMBER_OF_NO_COIN = 0;
	private static final int NO_REMAINING_AMOUNT = 0;

	private final EnumMap<Coin, Integer> coinEnumMap = new EnumMap<>(Coin.class);

	CoinBox(int holdingAmount) {
		Arrays.stream(Coin.values()).forEach(coin -> coinEnumMap.put(coin, NUMBER_OF_NO_COIN));
		makeCoins(holdingAmount);
	}

	public List<String> getCoinInfoList() {
		List<String> coinInfoList = new ArrayList<>();
		coinEnumMap.forEach((coin, numberOfCoin) -> coinInfoList.add(coin.toString() + " - " + numberOfCoin + "개"));
		return coinInfoList;
	}

	public List<String> getChangeInfoListForCustomer(int changeAmount) {
		List<String> changeInfoList = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			int numberOfCoin = Math.min(changeAmount / coin.getAmount(), coinEnumMap.get(coin));
			if (numberOfCoin > NUMBER_OF_NO_COIN) {
				changeInfoList.add(coin.toString() + " - " + numberOfCoin + "개");
				changeAmount -= coin.getAmount() * numberOfCoin;
			}
		}
		return changeInfoList;
	}

	private void makeCoins(int amount) {
		while (amount > NO_REMAINING_AMOUNT) {
			int randomCoinAmount = pickRandomCoinAmount(amount);
			Coin coin = Coin.from(randomCoinAmount);
			int beforeNumberOfCoin = coinEnumMap.get(coin);
			coinEnumMap.replace(coin, beforeNumberOfCoin + 1);
			amount -= randomCoinAmount;
		}
	}

	private int pickRandomCoinAmount(int amountLimit) {
		return Randoms.pickNumberInList(Coin.getAmountList(amountLimit));
	}
}
