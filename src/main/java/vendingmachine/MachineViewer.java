package vendingmachine;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MachineViewer {

	public void showCoinBoxStatus(HashMap<Coin, Integer> coinBox) {
		System.out.println("\n자판기가 보유한 동전");
		Arrays.stream(Coin.values())
				.sorted(Comparator.comparing(Enum::ordinal))
				.forEach(coin -> System.out.println(coin.toString() + coinBox.get(coin) + "개"));
	}
}
