package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CoinTest {

	@Test
	void 보유_금액_랜덤() {
		Map<Coin, Integer> balanceMap = Coin.decideCoinRandomly(10000, new LinkedHashMap<>());

		assertThat(balanceMap.size()).isEqualTo(Coin.values().length);

		int sum = 0;
		for (Map.Entry<Coin, Integer> entry : balanceMap.entrySet()) {
			sum += entry.getKey().getAmount() * entry.getValue();
		}
		assertThat(sum).isEqualTo(10000);
	}
}
