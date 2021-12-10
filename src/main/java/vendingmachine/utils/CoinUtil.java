package vendingmachine.utils;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

public class CoinUtil {

	public static VendingMachine makeCoin(int cost, VendingMachine vendingMachine) {
		while (cost > 0) {
			int randomCoin = Randoms.pickNumberInList(
				Arrays.asList(Coin.COIN_500.getAmount(), Coin.COIN_100.getAmount(),
					Coin.COIN_50.getAmount(), Coin.COIN_10.getAmount()));

			if (randomCoin > cost) {
				continue;
			}

			vendingMachine.addCoin(randomCoin);
			cost -= randomCoin;
		}

		return vendingMachine;
	}

}
