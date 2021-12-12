package vendingmachine.service;

import static constant.NumberConstant.*;
import static constant.StringConstant.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.Coin;

public class CoinService {
	private LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>();

	public LinkedHashMap<Coin, Integer> getCoinsByBalance(int balance) {
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

	public Map<Coin,Integer> getMinCoinSet(Map<Coin, Integer> coinState, int left) {
		for (Coin coin : coinState.keySet()) {
			left = changeCoin(coin, left, coinState);
		}
		return coins;
	}

	private int changeCoin(Coin coin, int left, Map<Coin,Integer> coinState) {
		int coinStateQuantity = coinState.get(coin);
		int coinAmount = coin.getAmount();
		int changeCoinQuantity = ZERO;
		while (shouldChange(coinStateQuantity, coinAmount, left)
			&& getAllCoinQuantity(coinState) != ZERO) {
			left -= coinAmount;
			coinState.put(coin, --coinStateQuantity);
			coins.put(coin, ++changeCoinQuantity);
		}
		return left;
	}

	private boolean shouldChange(int coinQuantity, int coinAmount, int left) {
		if (coinQuantity == ZERO
			|| coinAmount > left) {
			return false;
		}
		return true;
	}

	private int getAllCoinQuantity(Map<Coin, Integer> coins) {
		int coinQuantity = ZERO;
		for (Integer value : coins.values()) {
			coinQuantity += value;
		}
		return coinQuantity;
	}

}
