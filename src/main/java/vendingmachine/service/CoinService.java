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
	//순서 보장을 위한 LinkedHashMap타입 선택
	private LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>();

	public LinkedHashMap<Coin, Integer> getCoinsByBalance(int balance) {
		List<Integer> coinUnitList = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coinUnitList.add(coin.getAmount());
			coins.put(coin, ZERO);
		}
		while(balance > ZERO) {
			int coinUnit = getRandomCoin(balance, coinUnitList);
			updateCoinQuantity(coinUnit);
			balance -= coinUnit;
		}
		return coins;
	}

	private int getRandomCoin(int balance, List<Integer> coinList) {
		while (balance < Collections.max(coinList)) { //잔액이 400원인 경우 500원 동전은 생성될 필요X
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
			&& isCoinLeft(coinState)) { //동전이 없거나 잔돈 금액을 충족할때 까지 동전 반환
			left -= coinAmount;
			coinState.put(coin, --coinStateQuantity);
			coins.put(coin, ++changeCoinQuantity);
		}
		return left;
	}

	private boolean shouldChange(int coinQuantity, int coinAmount, int left) {
		//각각의 동전에 대해서 갯수가 없거나
		//단위가 잔액보다 큰 경우는 해당 동전을 돌려줄 수 없음
		if (coinQuantity == ZERO
			|| coinAmount > left) {
			return false;
		}
		return true;
	}

	//자판기의 동전이 존재하는지 확인
	private boolean isCoinLeft(Map<Coin, Integer> coins) {
		int coinQuantity = ZERO;
		for (Integer value : coins.values()) {
			coinQuantity += value;
		}
		if (coinQuantity == ZERO) {
			return false;
		}
		return true;
	}

}
