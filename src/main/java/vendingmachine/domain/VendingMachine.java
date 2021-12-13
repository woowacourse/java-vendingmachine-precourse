package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private final Money vendingMachineMoney;
	private Merchandises merchandises;
	private final LinkedHashMap<Coin, Integer> coinCounts;
	private final LinkedHashMap<Coin, Integer> returnCoinCounts;

	public VendingMachine(Money vendingMachineMoney) {
		this.vendingMachineMoney = vendingMachineMoney;
		coinCounts = new LinkedHashMap<>();
		initCoinCounts(coinCounts);
		returnCoinCounts = new LinkedHashMap<>();
		initCoinCounts(returnCoinCounts);
	}

	public static boolean isUserBuyMerchandise(User user, Merchandises merchandises) {
		List<Merchandise> notBuyMerchandise = merchandises.getMerchandiseList().stream()
			.filter((merchandise -> merchandise.isBigMerchandiseMoney(user.getUserMoney().getMoney())))
			.collect(Collectors.toList());

		return notBuyMerchandise.size() != merchandises.getMerchandiseList().size();
	}

	public static LinkedHashMap<Integer, Integer> castingCoinToInteger(LinkedHashMap<Coin, Integer> coinStatus) {
		LinkedHashMap<Integer, Integer> intCoinStatus = new LinkedHashMap<>();
		for (Coin coin : coinStatus.keySet()) {
			intCoinStatus.put(coin.getAmount(), coinStatus.get(coin));
		}
		return intCoinStatus;
	}

	public Merchandises getMerchandises() {
		return merchandises;
	}

	public void initCoinCounts(LinkedHashMap<Coin, Integer> coinMap) {
		for (Coin coin : Coin.values()) {
			coinMap.put(coin, 0);
		}
	}

	public void plusCoin(Coin coin) {
		coinCounts.put(coin, coinCounts.get(coin) + 1);
	}

	public void updateReturnCoinMap(LinkedHashMap<Coin,Integer> coinMap, Coin coin, int changeCount) {
		coinMap.put(coin, changeCount);
	}

	public void stockMerchandises(Merchandises merchandises) {
		this.merchandises = merchandises;
	}

	public LinkedHashMap<Coin, Integer> saveCoinStatus() {
		int tempMoney = vendingMachineMoney.getMoney();
		while (tempMoney != 0) {
			int randomCoinValue = Randoms.pickNumberInList(Coin.generateCoinAmountList());
			if (randomCoinValue > tempMoney) {
				continue;
			}
			tempMoney -= randomCoinValue;
			plusCoin(Coin.findCoinByAmount(randomCoinValue));
		}
		return coinCounts;
	}

	public int returnCoin(int changeMoney, Coin coin) {
		int coinChangeMaxCount = changeMoney / coin.getAmount();
		int returnCoinCount = Math.min(coinChangeMaxCount, coinCounts.get(coin));
		changeMoney -= returnCoinCount * coin.getAmount();
		updateReturnCoinMap(returnCoinCounts,coin, returnCoinCount);
		updateReturnCoinMap(coinCounts, coin, coinCounts.get(coin) - returnCoinCount);
		return changeMoney;
	}

	public LinkedHashMap<Coin, Integer> changeCoinStatus(Money lastMoney) {
		int returnMoney = lastMoney.getMoney();
		if (returnMoney >= vendingMachineMoney.getMoney()) {
			return coinCounts;
		}
		for (Coin coin : coinCounts.keySet()) {
			returnMoney = returnCoin(returnMoney, coin);
			if (returnMoney == 0) {
				break;
			}
		}
		return returnCoinCounts;
	}
}
