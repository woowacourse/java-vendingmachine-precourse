package vendingmachine.utill;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCoinGenerator {
	public static int generateRandomCoin(List<Integer> coins) {
		return Randoms.pickNumberInList(coins);
	}
}
