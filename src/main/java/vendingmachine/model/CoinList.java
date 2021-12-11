package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.OutputView;

// TODO: 2021/12/08 더 좋은 이름
public class CoinList {

	private final LinkedHashMap<Coin, Integer> hashMap;
	private final int totalMoney;

	public CoinList(int totalMoney) {
		this.totalMoney = totalMoney;
		this.hashMap = new LinkedHashMap<>();
		hashMap.put(Coin.COIN_500, 0);
		hashMap.put(Coin.COIN_100, 0);
		hashMap.put(Coin.COIN_50, 0);
		hashMap.put(Coin.COIN_10, 0);
	}

	public Set<Map.Entry<Coin, Integer>> getHashMap() {
		return hashMap.entrySet();
	}

	public void init() {
		int leftMoney = totalMoney;
		List<Integer> coinAmountList = Coin.toList();
		while (leftMoney > 0) {
			int pickedCoinAmount = Randoms.pickNumberInList(coinAmountList);
			if (leftMoney < pickedCoinAmount) {
				continue;
			}
			leftMoney -= pickedCoinAmount;
			Coin coin = Coin.of(pickedCoinAmount);
			addCoin(coin);
		}

		System.out.println(this);
	}

	private void addCoin(Coin coin) {
		Integer oldValue = hashMap.get(coin);
		hashMap.replace(coin, oldValue + 1);
	}

	public void subtractCoin(Coin coin, int remainingCoins) {
		hashMap.replace(coin, remainingCoins);
	}

	public String toString() {
		return "\n자판기가 보유한 동전\n" +
			Coin.COIN_500.getAmount() + OutputView.MONETARY_UNIT + " - " + hashMap.get(Coin.COIN_500) + "개\n" +
			Coin.COIN_100.getAmount() + OutputView.MONETARY_UNIT + " - " + hashMap.get(Coin.COIN_100) + "개\n" +
			Coin.COIN_50.getAmount() + OutputView.MONETARY_UNIT + " - " + hashMap.get(Coin.COIN_50) + "개\n" +
			Coin.COIN_10.getAmount() + OutputView.MONETARY_UNIT + " - " + hashMap.get(Coin.COIN_10) + "개\n";
	}

}
