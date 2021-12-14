package vendingmachine.domain;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.constants.Message;
import vendingmachine.utils.View;

class CoinsTest {
	@Test
	void generateRandomCoins() {
		Coins coins = new Coins();
		int possession = 450;
		Map<Coin, Integer> entry = coins.createCoins(possession);

		View.showCoins(entry, Message.ANSWER_POSSESSION_COIN);

		int totalCoinAmount = 0;
		for (Map.Entry<Coin, Integer> e : entry.entrySet()) {
			totalCoinAmount += e.getValue() * (e.getKey().getAmount());
		}

		Assertions.assertThat(totalCoinAmount).isEqualTo(possession);
	}
}
