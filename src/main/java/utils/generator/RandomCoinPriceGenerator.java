package utils.generator;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCoinPriceGenerator {
	private static final int COIN_500 = 500;
	private static final int COIN_100 = 100;
	private static final int COIN_50 = 50;
	private static final int COIN_10 = 10;

	private RandomCoinPriceGenerator() {
	}

	public static int pickRandomCoinPrice() {
		return Randoms.pickNumberInList(Arrays.asList(COIN_10, COIN_50, COIN_100, COIN_500));
	}
}
