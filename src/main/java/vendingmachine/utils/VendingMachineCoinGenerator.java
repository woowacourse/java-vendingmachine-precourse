package vendingmachine.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class VendingMachineCoinGenerator {
	private static Map<Coin, Integer> vendingMachineCoinCounts = new LinkedHashMap<>();
	private static List<Integer> coinAmounts = new ArrayList<>();

	static {
		Arrays.stream(Coin.values()).forEach(coin -> vendingMachineCoinCounts.put(coin, 0));
		Arrays.stream(Coin.values()).map(coin -> coin.getAmount()).forEach(coinAmounts::add);
	}

	public static Map<Coin, Integer> generateVendingMachineCoin(int money) {
		int vendingMachineMoneyRemaining = money;

		while (vendingMachineMoneyRemaining > 0) {
			int randomCoinAmount = Randoms.pickNumberInList(coinAmounts);
			Coin coin = Coin.of(randomCoinAmount);

			if (vendingMachineMoneyRemaining - randomCoinAmount < 0) {
				continue;
			}

			vendingMachineMoneyRemaining -= randomCoinAmount;
			vendingMachineCoinCounts.put(coin, vendingMachineCoinCounts.get(coin) + 1);
		}

		return vendingMachineCoinCounts;
	}
}
