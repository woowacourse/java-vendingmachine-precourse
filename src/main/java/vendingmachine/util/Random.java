package vendingmachine.util;

import static vendingmachine.NumberConstant.*;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

	public static int generateAmount() {
		return Randoms.pickNumberInList(Arrays.asList(TEN, FIFTY, HUNDRED, FIVE_HUNDRED));
	}
}
