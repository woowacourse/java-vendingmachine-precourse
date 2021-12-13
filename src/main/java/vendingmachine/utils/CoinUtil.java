package vendingmachine.utils;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enumclass.Coin;

public class CoinUtil {

	public static int generateRandomCoin() {
		return Randoms.pickNumberInList(
			Arrays.asList(Coin.COIN_500.getAmount(), Coin.COIN_100.getAmount(),
				Coin.COIN_50.getAmount(), Coin.COIN_10.getAmount()));
	}
}
