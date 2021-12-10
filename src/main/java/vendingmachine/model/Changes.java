package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.view.OutputView;

public class Changes {

	private final LinkedHashMap<Coin, Integer> hashMap = new LinkedHashMap<>();

	public void addCoin(Coin coin, int numberOfCoins) {
		hashMap.put(coin, numberOfCoins);
	}

	public String toString() {
		StringBuilder message = new StringBuilder("잔돈\n");

		for (Map.Entry<Coin, Integer> entry : hashMap.entrySet()) {
			message.append(entry.getKey().getAmount())
				.append(OutputView.MONETARY_UNIT)
				.append(" - ")
				.append(entry.getValue()).append("개\n");
		}

		return message.toString();
	}

}
