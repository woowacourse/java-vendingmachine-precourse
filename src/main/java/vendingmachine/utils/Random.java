package vendingmachine.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

	public static int pickRandomCoin(List<Integer> numbers) {
		return Randoms.pickNumberInList(numbers);
	}
}
