package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinsTest {
	@Test
	void 동전_생성() {
		// given
		int changes = 1000;
		int sum = 0;

		// when
		Coins coins = new Coins(changes);
		for (Coin coin : Coin.values()) {
			sum += coin.getAmount() * coins.getCoinCount(coin);
		}

		// then
		assertThat(sum).isEqualTo(changes);
	}
}