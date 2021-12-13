package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Changes {
	private static final int ADD_VALUE = 1;
	private static final int NO_COIN = 0;

	private Map<Coin, Integer> coinMap = new TreeMap<>();

	private int totalChanges;

	Changes(int totalChanges) {
		this.totalChanges = totalChanges; //ㅈㅏ판기가 가지고있는 돈
		initCoinMap();

	}

	public void generateRandomCoins() {
		int tempChanges = 0;
		while (tempChanges != totalChanges) {
			int randomCoin = Randoms.pickNumberInList(Coin.getCoinAmountList());
			if (tempChanges + randomCoin > totalChanges) {
				continue;
			}
			tempChanges += randomCoin;
			Coin findCoin = Coin.getCoinByNumber(randomCoin);
			coinMap.put(findCoin, coinMap.get(findCoin) + ADD_VALUE);
		}
	}

	public Map<Coin, Integer> getCoinMap() {
		return coinMap;
	}

	public Map<Coin, Integer> returnChanges(int money) {
		if (money == 0 || totalChanges == 0) {
			return null;
		}

		Map<Coin, Integer> restChanges = getRestChanges();
		List<Coin> restCoins = new ArrayList<>(restChanges.keySet());

		return calculateChanges(money, restChanges, restCoins);
	}

	private Map<Coin, Integer> calculateChanges(int money, Map<Coin, Integer> restChanges, List<Coin> restCoins) {
		Map<Coin, Integer> calChangesMap = new TreeMap<>();
		for (Coin coin : restCoins) {
			int temp = getTempQuotientCompareWithRestChanges(restChanges, money, coin);
			money -= temp * coin.getAmount();
			putQuotientOnMap(calChangesMap, coin, temp);
			if (money == 0) {
				return calChangesMap;
			}
		}
		return calChangesMap;
	}

	private void putQuotientOnMap(Map<Coin, Integer> calChangesMap, Coin coin, int temp) {
		if (temp != 0) {
			calChangesMap.put(coin, temp);
		}
	}

	private int getTempQuotientCompareWithRestChanges(Map<Coin, Integer> restChanges, int money, Coin coin) {
		int temp = money / coin.getAmount();
		if (temp > restChanges.get(coin)) {
			temp = restChanges.get(coin);
		}
		return temp;
	}

	private Map<Coin, Integer> getRestChanges() {
		Map<Coin, Integer> tempCoinMap = new TreeMap<>();
		for (Map.Entry<Coin, Integer> coinEntry : coinMap.entrySet()) {
			if (coinEntry.getValue() > NO_COIN) {
				tempCoinMap.put(coinEntry.getKey(), coinEntry.getValue());
			}
		}
		return tempCoinMap;
	}

	private void initCoinMap() {
		coinMap.put(Coin.COIN_500, 0);
		coinMap.put(Coin.COIN_100, 0);
		coinMap.put(Coin.COIN_50, 0);
		coinMap.put(Coin.COIN_10, 0);
	}

}
