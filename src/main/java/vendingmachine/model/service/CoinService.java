package vendingmachine.model.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.Coin;
import vendingmachine.model.Customer;
import vendingmachine.model.repository.CoinRepository;

public class CoinService {

	public static final int ADD_COIN_COUNT_NUMBER = 1;
	public static final int EMPTY_CHANGE_NUMBER = 0;
	public static final String COIN_NAME_PREFIX = "COIN_";

	CoinRepository coinRepository = CoinRepository.instance;

	public void addCoin(String coinName) {
		coinRepository.getCoinRepository()
			.put(Coin.valueOf(coinName),
				coinRepository.getCoinRepository().get(Coin.valueOf(coinName)) + ADD_COIN_COUNT_NUMBER);
	}

	public void fillCoin(int change) {
		List<Integer> coinAmountList = getCoinAmountList();

		while (change != EMPTY_CHANGE_NUMBER) {
			int amount = Randoms.pickNumberInList(coinAmountList);
			if (change - amount >= EMPTY_CHANGE_NUMBER) {
				addCoin(makeCoinName(amount));
				change -= amount;
			}
		}
	}

	private String makeCoinName(int amount) {
		String coinName = COIN_NAME_PREFIX + amount;
		return coinName;
	}

	public HashMap<Coin, Integer> calculateCoinForChange(int restMoney, Customer customer) {
		HashMap<Coin, Integer> coinForChange = new HashMap<>();
		for (int amount : getCoinAmountList()) {
			int availableCount = restMoney / amount;
			Integer maxCount = coinRepository.getCoinRepository().get(Coin.valueOf(makeCoinName(amount)));
			if (maxCount < availableCount) {
				restMoney = putCoinForChange(restMoney, coinForChange, amount, maxCount, customer);
				continue;
			}
			restMoney = putCoinForChange(restMoney, coinForChange, amount, availableCount, customer);
		}

		return coinForChange;
	}

	private int putCoinForChange(int restMoney, HashMap<Coin, Integer> coinForChange, int amount, Integer count,
		Customer customer) {
		coinForChange.put(Coin.valueOf(makeCoinName(amount)), count);
		restMoney -= count * amount;
		customer.setMoney(restMoney);
		return restMoney;
	}

	public List<Integer> getCoinAmountList() {
		return Arrays.stream(Coin.values()).map(coin -> coin.getAmount()).collect(Collectors.toList());
	}
}
