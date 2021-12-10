package vendingmachine.util;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

	// TODO: 2021/12/10 Delete this
	public static int generateNumberOfCoins(int maxNumberOfCoins) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i <= maxNumberOfCoins; i++) {
			numbers.add(i);
		}

		return Randoms.pickNumberInList(numbers);
	}

}
