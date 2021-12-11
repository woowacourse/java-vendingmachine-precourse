package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CoinTest {

	@Test
	void valueOfTest() {
		Arrays.stream(Coin.values())
			.forEach(coin -> {
				assertEquals(coin, Coin.valueOf(coin.getAmount()));
			});

		assertThrows(IllegalArgumentException.class, () -> {
			Coin.valueOf(111);
		});
	}

}