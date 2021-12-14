package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.constants.Message;
import vendingmachine.utils.View;

import java.util.Map;

class CoinsTest {
	@Test
	void generateRandomCoins() {
		Coins coins = new Coins();
		final int POSSESSION = 450;
		Map<Coin, Integer> entry = coins.createCoins(POSSESSION);

		View.showCoins(entry, Message.ANSWER_POSSESSION_COIN);

		int totalCoinAmount = 0;
		for (Map.Entry<Coin, Integer> e : entry.entrySet()) {
			totalCoinAmount += e.getValue() * (e.getKey().getAmount());
		}

		Assertions.assertThat(totalCoinAmount).isEqualTo(POSSESSION);
	}
}
