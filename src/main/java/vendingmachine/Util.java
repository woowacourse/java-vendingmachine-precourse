package vendingmachine;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Model.Coin;

public class Util {
	public static Coin randomCoin() {
		return Coin.getCoin(
			Randoms.pickNumberInList(Arrays.asList(Constants.COIN_NUMS))
		);
	}
}
