package vendingmachine.Utils;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Util {
	public static int randomCoinNumber() {
		return Randoms.pickNumberInList(Arrays.asList(Constants.COIN_NUMBERS));
	}

	public static String getInput() {
		return Console.readLine();
	}
}
