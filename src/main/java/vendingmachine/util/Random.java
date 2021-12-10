package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class Random {

	public static int generateAmount() {
		return Randoms.pickNumberInList(Coin.amountList);
	}
}
