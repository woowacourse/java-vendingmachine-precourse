package vendingmachine.service;

import static constant.NumberConstant.*;
import static constant.StringConstant.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.Coin;

public class CoinService {
	private Map<Coin, Integer> coins = new HashMap<>();

	public Map<Coin, Integer> getCoinsByBalance(int balance) {
		List<Integer> coinUnitList = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coinUnitList.add(coin.getAmount());
			coins.put(coin, ZERO);
		}
		while(balance > ZERO) {
			int coinUnit = gatherCoin(balance, coinUnitList);
			updateCoinQuantity(coinUnit);
			balance -= coinUnit;
		}
		return coins;
	}

	private int gatherCoin(int balance, List<Integer> coinList) {
		while (balance < Collections.max(coinList)) {
			coinList.remove(ZERO);
		}
		return Randoms.pickNumberInList(coinList);
	}

	private void updateCoinQuantity(int coinUnit) {
		Coin coin = Coin.valueOf(COIN_ENUM_PREFIX + coinUnit);
		int previousQuantity = coins.get(coin);
		coins.put(coin, ++previousQuantity);
	}

}
