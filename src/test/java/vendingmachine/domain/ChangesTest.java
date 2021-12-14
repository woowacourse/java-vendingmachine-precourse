package vendingmachine.domain;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Coin;

import static org.assertj.core.api.Assertions.*;
import static vendingmachine.Coin.*;

public class ChangesTest {
	private Changes changes = new Changes();

	@BeforeEach
	void setUp() {
		for (Coin coin : Coin.values()) {
			changes.setChanges(coin, 1);
		}
	}

	@DisplayName("동전들의 총합")
	@Test
	void getTotalMoney() {
		assertThat(changes.getTotalMoney().compareTo(new Money(660))).isEqualTo(0);
	}

	@DisplayName("입력받은 돈을 최소한의 동전 개수로 반환")
	@Test
	void toChangesMinCount() {
		Changes actual = changes.toChangesMinCount(new Money(600));
		Map<Coin, Integer> actualValue = actual.getChanges();
		assertThat(actualValue.get(COIN_500)).isEqualTo(1);
		assertThat(actualValue.get(COIN_100)).isEqualTo(1);
		assertThat(actualValue.get(COIN_50)).isEqualTo(0);
		assertThat(actualValue.get(COIN_10)).isEqualTo(0);
	}
}
