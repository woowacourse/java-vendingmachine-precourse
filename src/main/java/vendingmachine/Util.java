package vendingmachine;

import java.util.Arrays;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Model.Coin;

public class Util {
	public static Coin randomCoin() {
		int value = Randoms.pickNumberInList(Arrays.asList(500, 100, 50, 10));
		return Coin.getCoin(value);
	}
}
