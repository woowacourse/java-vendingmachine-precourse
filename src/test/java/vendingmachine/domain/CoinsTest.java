package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;

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

	@Test
	void 잔돈_반환() {
		// given
		int changes = 2000;
		int moneyLeft = 1500;
		int sum = 0;

		// when
		Coins coins = new Coins(changes);
		EnumMap<Coin, Integer> coinChanges = coins.changeCoins(moneyLeft);
		for (Coin coin : Coin.values()) {
			sum += coin.getAmount() * coinChanges.get(coin);
		}

		// then
		assertThat(sum).isEqualTo(moneyLeft);
	}

	@Test
	void 잔돈_부족() {

		// given
		int changes = 2000;
		int moneyLeft = 2500;
		int sum = 0;

		// when
		Coins coins = new Coins(changes);
		EnumMap<Coin, Integer> coinChanges = coins.changeCoins(moneyLeft);
		for (Coin coin : Coin.values()) {
			sum += coin.getAmount() * coinChanges.get(coin);
		}

		// then
		assertThat(sum).isLessThan(moneyLeft);
	}
}