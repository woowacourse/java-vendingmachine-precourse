package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Changes {

	private final LinkedHashMap<Coin, Integer> hashMap;

	public Changes() {
		this.hashMap = new LinkedHashMap<>();
	}

	public Changes(CoinList coinList) {
		this.hashMap = new LinkedHashMap<>();

		LinkedHashMap<Coin, Integer> coinListHashMap = coinList.getHashMap();
		for (Map.Entry<Coin, Integer> entry : coinListHashMap.entrySet()) {
			if (entry.getValue() == 0) {
				continue;
			}

			hashMap.put(entry.getKey(), entry.getValue());
		}
	}

}
