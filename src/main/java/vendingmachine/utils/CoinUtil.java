package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enumclass.Coin;

public class CoinUtil {

	public static int generateRandomCoin() {
		return Randoms.pickNumberInList(Coin.getCoinList());
	}
}
