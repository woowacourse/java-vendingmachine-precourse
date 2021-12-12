package utils.generator;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCoinPriceGenerator {

	private RandomCoinPriceGenerator() {
	}

	public static int pickRandomCoinPrice() {
		return Randoms.pickNumberInList(Arrays.asList(10, 50, 100, 500));
	}
}
