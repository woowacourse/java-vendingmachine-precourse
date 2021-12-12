package vendingmachine.domain.coin;

import static vendingmachine.constant.OutputMessage.*;

import java.util.Map;

public class CoinCounter {
	private Map<Integer, Integer> coinCounter;

	public CoinCounter(Map<Integer, Integer> coinCounter) {
		this.coinCounter = coinCounter;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		coinCounter.forEach(
			(coinAmount, numberOfCoins) -> result.append(coinAmount + WON + numberOfCoins + AMOUNT_UNIT + "\n")
		);
		return result.toString();
	}
}
