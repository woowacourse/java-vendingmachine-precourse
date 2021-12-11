package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.Coin;
import vendingmachine.model.CoinStock;

import java.util.*;
import java.util.stream.Collectors;

public class RandomCoinSelector {

	private HashMap<Coin, Integer> coinBox = new HashMap<>(Coin.getCoinTypes());

	public RandomCoinSelector() {
		initCoinBox();
	}

	public List<CoinStock> makeRandomCoinMix(int total) {
		int coinsSum = 0;
		while(coinsSum < total) {
			Coin pickedCoin = getRandomCoin(Coin.getCoinAmounts());
			if(coinsSum + pickedCoin.getAmount() <= total) {
				coinBox.put(pickedCoin, coinBox.get(pickedCoin) + 1);
				coinsSum += pickedCoin.getAmount();
			}
		}
		return convertCoins();
	}

	private Coin getRandomCoin(List<Integer> coinAmounts) {
		int pick = Randoms.pickNumberInList(coinAmounts);
		return Coin.getCoinByAmount(pick);
	}

	private void initCoinBox() {
		Arrays.stream(Coin.values())
				.forEach(coin -> coinBox.put(coin, 0));
	}

	private List<CoinStock> convertCoins() {
		List<CoinStock> coins = new ArrayList<>();
		for (Coin coin : coinBox.keySet()) {
			CoinStock coinStock = new CoinStock(coin.getAmount(), coinBox.get(coin));
			coins.add(coinStock);
		}
		coins = coins.stream()
				.sorted(Comparator.comparing(CoinStock::getAmount).reversed())
				.collect(Collectors.toList());
		return coins;
	}
}
