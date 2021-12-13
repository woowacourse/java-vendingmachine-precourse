package vendingmachine.controller.classes;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vendingmachine.controller.CoinGeneratorInterface;
import vendingmachine.model.Coin;

public class CoinGenerator implements CoinGeneratorInterface {
	private List<Integer> coinList = new ArrayList<>();

	@Override
	public HashMap<Integer, Integer> getRandomCoins(int price) {
		HashMap<Integer, Integer> coinMap = new HashMap<>();
		initCoinMap(coinMap);
		while(price != 0) {
			int pickedCoin = pickNumberInList(coinList);
			if (price < pickedCoin) {
				continue;
			}
			price -= pickedCoin;
			int settingCount = coinMap.get(pickedCoin) + 1;
			coinMap.put(pickedCoin, settingCount);
		}
		return coinMap;
	}

	private void initCoinMap(HashMap<Integer, Integer> coinMap) {
		coinList.add(Coin.COIN_500.getAmount());
		coinList.add(Coin.COIN_100.getAmount());
		coinList.add(Coin.COIN_50.getAmount());
		coinList.add(Coin.COIN_10.getAmount());
		coinMap.put(Coin.COIN_500.getAmount(), 0);
		coinMap.put(Coin.COIN_100.getAmount(), 0);
		coinMap.put(Coin.COIN_50.getAmount(), 0);
		coinMap.put(Coin.COIN_10.getAmount(), 0);
	}
}
