package vendingmachine.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.repository.Coin;
import vendingmachine.view.InputView;

public class CoinService {

	CoinValidator coinValidator = new CoinValidator();

	public void generate() {
		while (true) {
			try {
				String money = InputView.getMoney();
				coinValidator.isValid(money);
				exchangeMoneyToCoin(Integer.parseInt(money));
				return;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void exchangeMoneyToCoin(int money) {
		List<Integer> number = new ArrayList<>(
			Arrays.asList(Coin.COIN_500.getAmount(), Coin.COIN_100.getAmount(), Coin.COIN_50.getAmount(),
				Coin.COIN_10.getAmount()));
		HashMap<Integer, String> numberMap = new HashMap<>();
		numberMap = makeNumberMap(numberMap);
		while (money != 0) {
			int randomCoin = Randoms.pickNumberInList(number);
			if (randomCoin <= money) {
				Coin coin = Coin.valueOf(numberMap.get(randomCoin));
				coin.addStock();
				money -= randomCoin;
			}
		}
	}

	public HashMap<Integer, String> makeNumberMap(HashMap<Integer, String> numberMap) {
		numberMap.put(Coin.COIN_500.getAmount(), "COIN_500");
		numberMap.put(Coin.COIN_100.getAmount(), "COIN_100");
		numberMap.put(Coin.COIN_50.getAmount(), "COIN_50");
		numberMap.put(Coin.COIN_10.getAmount(), "COIN_10");
		return numberMap;
	}
}