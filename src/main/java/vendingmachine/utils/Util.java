package vendingmachine.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {

	public static Integer convertStringToInt(String money) {
		return Integer.valueOf(money);
	}

	public static int pickRandomCoin(List<Integer> coinKinds) {
		return Randoms.pickNumberInList(coinKinds);
	}

	public static String removeSpace(String input) {
		return input.replaceAll(Constant.CONSTANT_SPACE, Constant.EMPTY_STRING);
	}
}
