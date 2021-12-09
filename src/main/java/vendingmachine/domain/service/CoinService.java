package vendingmachine.domain.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.repository.CoinRepository;

public class CoinService {
	private static final int ADD_COIN_COUNT = 1;
	private static final int FIRST_MONEY_END = 0;
	private final CoinRepository coinRepository = new CoinRepository();

	public void createFirstCoins(int firstMoney) {
		List<Integer> coinUnit = new ArrayList<>();
		coinUnit.add(Coin.COIN_10.getAmount());
		coinUnit.add(Coin.COIN_50.getAmount());
		coinUnit.add(Coin.COIN_100.getAmount());
		coinUnit.add(Coin.COIN_500.getAmount());
		while(firstMoney != FIRST_MONEY_END) {
			int coin = Randoms.pickNumberInList(coinUnit);

			if(firstMoney < coin)
				continue;

			addCoin(coin);
			firstMoney -= coin;
		}
	}

	private void addCoin(int coin) {
		if(coin == Coin.COIN_500.getAmount()) {
			coinRepository.addCoin(Coin.COIN_500, ADD_COIN_COUNT);
			return;
		}
		if(coin == Coin.COIN_100.getAmount()) {
			coinRepository.addCoin(Coin.COIN_100, ADD_COIN_COUNT);
			return;
		}
		if(coin == Coin.COIN_50.getAmount()) {
			coinRepository.addCoin(Coin.COIN_50, ADD_COIN_COUNT);
			return;
		}
		if(coin == Coin.COIN_10.getAmount()) {
			coinRepository.addCoin(Coin.COIN_10, ADD_COIN_COUNT);
		}
	}
}
