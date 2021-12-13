package vendingmachine.model.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.Coin;
import vendingmachine.model.repository.CoinRepository;

public class CoinService {

	public static final int ADD_COIN_COUNT_NUMBER = 1;
	public static final int EMPTY_CHANGE_NUMBER = 0;

	CoinRepository coinRepository = CoinRepository.instance;

	public void addCoin(String coinName) {
		coinRepository.getCoinRepository()
			.put(coinName, coinRepository.getCoinRepository().get(coinName) + ADD_COIN_COUNT_NUMBER);
	}

	public void fillCoin(int change) {
		List<Integer> coinAmountList = getCoinAmountList();

		while (change != EMPTY_CHANGE_NUMBER) {
			int coin = Randoms.pickNumberInList(coinAmountList);
			if (change - coin >= EMPTY_CHANGE_NUMBER) {
				addCoin(String.valueOf(coin));
				change -= coin;
			}
		}
	}

	public HashMap<String, Integer> calculateCoinForChange(int restMoney) {
		HashMap<String, Integer> coinForChange = new HashMap<>();
		for (int amount : getCoinAmountList()) {
			int availableCount = restMoney / amount;
			Integer maxCount = coinRepository.getCoinRepository().get(String.valueOf(amount));
			if (maxCount < availableCount) {
				restMoney = putCoinForChange(restMoney, coinForChange, amount, maxCount);
				continue;
			}
			restMoney = putCoinForChange(restMoney, coinForChange, amount, availableCount);
		}

		return coinForChange;
	}

	private int putCoinForChange(int restMoney, HashMap<String, Integer> coinForChange, int amount, Integer count) {
		coinForChange.put(String.valueOf(amount), count);
		restMoney -= count * amount;
		return restMoney;
	}

	public List<Integer> getCoinAmountList() {
		return Arrays.stream(Coin.values()).map(coin -> coin.getAmount()).collect(Collectors.toList());
	}
}
