package vendingmachine.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.Coin;
import vendingmachine.view.OutputView;

public class CoinRepository {

	private final LinkedHashMap<Coin, Integer> coins;
	private final int totalMoney;

	public CoinRepository(int totalMoney) {
		this.totalMoney = totalMoney;
		this.coins = new LinkedHashMap<>();
		coins.put(Coin.COIN_500, 0);
		coins.put(Coin.COIN_100, 0);
		coins.put(Coin.COIN_50, 0);
		coins.put(Coin.COIN_10, 0);
	}

	public Set<Map.Entry<Coin, Integer>> getCoins() {
		return coins.entrySet();
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
		Integer oldValue = coins.get(coin);
		coins.replace(coin, oldValue + 1);
	}

	public void subtractCoin(Coin coin, int remainingCoins) {
		coins.replace(coin, remainingCoins);
	}

	public String toString() {
		return "\n자판기가 보유한 동전\n" +
			Coin.COIN_500.getAmount() + OutputView.MONETARY_UNIT + " - " + coins.get(Coin.COIN_500) + "개\n" +
			Coin.COIN_100.getAmount() + OutputView.MONETARY_UNIT + " - " + coins.get(Coin.COIN_100) + "개\n" +
			Coin.COIN_50.getAmount() + OutputView.MONETARY_UNIT + " - " + coins.get(Coin.COIN_50) + "개\n" +
			Coin.COIN_10.getAmount() + OutputView.MONETARY_UNIT + " - " + coins.get(Coin.COIN_10) + "개\n";
	}

}
