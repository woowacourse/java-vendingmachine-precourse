package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.constant.SystemMessage.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CoinService {
	public Map<Integer, Integer> getCoinCounter(int amount) {
		Map<Integer, Integer> coinCounter = new LinkedHashMap<>();
		initializeCoinCounter(coinCounter);
		setCoinCounter(coinCounter, amount);
		return coinCounter;
	}

	private void initializeCoinCounter(Map<Integer, Integer> coinCounter) {
		List<Integer> allCoinAmount = Coin.getAllCoinAmount();
		allCoinAmount.forEach(coinAmount -> coinCounter.put(coinAmount, DEFAULT_NUMBER));
	}

	private void setCoinCounter(Map<Integer, Integer> coinCounter, int amount) {
		int randomCoinAmount;
		while (amount > 0) {
			randomCoinAmount = pickRandomCoinAmount(amount);
			coinCounter.put(randomCoinAmount, coinCounter.get(randomCoinAmount) + 1);
			amount -= randomCoinAmount;
		}
	}
	private int pickRandomCoinAmount(int amount) {
		int randomCoinAmount;
		List<Integer> allCoinAmount = Coin.getAllCoinAmount();
		do {
			randomCoinAmount = pickNumberInList(allCoinAmount);
		} while (amount < randomCoinAmount);
		return randomCoinAmount;
	}
}
