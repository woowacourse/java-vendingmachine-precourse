package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RandomCoinSelector {

	private HashMap<Coin, Integer> coinBox = new HashMap<>(Coin.getCoinTypes());

	public RandomCoinSelector() {
		initCoinBox();
	}

	public HashMap<Coin, Integer> makeRandomCoinMix(int total) {
		List<Integer> coinAmounts = Coin.getCoinAmounts();
		int coinsSum = 0;
		while(coinsSum < total) {
			Coin pickedCoin = getRandomCoin(coinAmounts);
			if(coinsSum + pickedCoin.getAmount() <= total) {
				coinBox.put(pickedCoin, coinBox.get(pickedCoin) + 1);
				coinsSum += pickedCoin.getAmount();
			}
		}
		return coinBox;
	}

	private Coin getRandomCoin(List<Integer> coinAmounts) {
		int pick = Randoms.pickNumberInList(coinAmounts);
		return Coin.getCoinByAmount(pick);
	}

	private void initCoinBox() {
		Arrays.stream(Coin.values())
				.forEach(coin -> coinBox.put(coin, 0));
	}
}
