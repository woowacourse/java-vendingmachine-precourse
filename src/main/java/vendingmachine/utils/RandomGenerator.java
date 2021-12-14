package vendingmachine.utils;

import static vendingmachine.constants.Constant.*;

import java.util.EnumMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class RandomGenerator {
	private final Map<Coin, Integer> vendingMachineRemainedCoins = new EnumMap<>(Coin.class);

	public Map<Coin, Integer> createCoins(int possession) {
		initCoinType();
		generateRandomCoins(possession);

		return vendingMachineRemainedCoins;
	}

	private void initCoinType() {
		for (Coin coinType : Coin.values()) {
			vendingMachineRemainedCoins.put(coinType, INIT_COUNT);
		}
	}

	private void generateRandomCoins(int possession) {
		int generatedCoinAmount = INIT_COUNT;

		while (!isCompleted(possession, generatedCoinAmount)) {
			int randomCoin = Randoms.pickNumberInList(COIN_VALUES);
			generatedCoinAmount = addRandomCoin(possession, generatedCoinAmount, randomCoin);
		}
	}

	private boolean isCompleted(int possession, int totalCoin) {
		return totalCoin == possession;
	}

	private int addRandomCoin(int limit, int generatedCoinAmount, int randomCoin) {
		if (generatedCoinAmount + randomCoin <= limit) {
			generatedCoinAmount += randomCoin;

			Coin coinType = Coin.findType(randomCoin);
			int coinCount = incrementCoinCount(coinType);

			vendingMachineRemainedCoins.put(coinType, coinCount);
		}
		return generatedCoinAmount;
	}

	private int incrementCoinCount(Coin coin) {
		return vendingMachineRemainedCoins.getOrDefault(coin, INIT_COUNT) + ADD_ONE;
	}
}
