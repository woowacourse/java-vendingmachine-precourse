package vendingmachine.domain.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.repository.CoinRepository;

public class CoinService {
	private static final int ADD_COIN_COUNT = 1;
	private static final int FIRST_MONEY_END = 0;
	private final CoinRepository coinRepository = new CoinRepository();
	private final List<Integer> coinUnit = Arrays.asList(
		Coin.COIN_500.getAmount(),
		Coin.COIN_100.getAmount(),
		Coin.COIN_50.getAmount(),
		Coin.COIN_10.getAmount()
	);

	public void createFirstCoins(int firstMoney) {
		while(firstMoney != FIRST_MONEY_END) {
			int coin = Randoms.pickNumberInList(coinUnit);

			if(firstMoney < coin)
				continue;

			addCoin(coin);
			firstMoney -= coin;
		}
	}

	public Map<Coin, Integer> getCoins() {
		return coinRepository.getCoins();
	}

	private void addCoin(int coin) {
		coinRepository.addCoin(Coin.getCoin(coin), ADD_COIN_COUNT);
	}
}
