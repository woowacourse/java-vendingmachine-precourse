package view;

import java.util.List;
import java.util.stream.IntStream;

public class OutputDisplay {

	private OutputDisplay() {
	}

	public static void showEachCoinInCoinBox(List<Integer> eachCoinValue, List<Integer> eachCoinCount) {
		System.out.println();
		System.out.println("자판기가 보유한 동전");
		IntStream.range(0, eachCoinCount.size())
			.forEach(index -> showCoin(eachCoinValue.get(index), eachCoinCount.get(index)));
	}

	private static void showCoin(int coinValue, int coinCount) {
		System.out.println(coinValue + "원 - " + coinCount + "개");
	}
}
