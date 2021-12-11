package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CoinTest {

	@Test
	void 가능한_개수__목록() {
		assertThat(Coin.getPossibleQuantity(500, 0).size()).isEqualTo(1);
		assertThat(Coin.getPossibleQuantity(500, 499).size()).isEqualTo(1);
		assertThat(Coin.getPossibleQuantity(500, 500).size()).isEqualTo(2);
		assertThat(Coin.getPossibleQuantity(10, 0).size()).isEqualTo(1);
		assertThat(Coin.getPossibleQuantity(10, 19).size()).isEqualTo(2);
		assertThat(Coin.getPossibleQuantity(10, 20).size()).isEqualTo(3);
	}

	@Test
	void 잔여금_반환() {
		assertThat(Coin.calculateResidue(500, 10000, 2)).isEqualTo(9000);
		assertThat(Coin.calculateResidue(100, 7400, 20)).isEqualTo(5400);
		assertThat(Coin.calculateResidue(50, 300, 4)).isEqualTo(100);
		assertThat(Coin.calculateResidue(10, 14, 1)).isEqualTo(4);
	}

	@Test
	void 최대_가능_동전개수() {
		assertThat(Coin.getMaxQuantity(500, 2400)).isEqualTo(4);
		assertThat(Coin.getMaxQuantity(100, 220)).isEqualTo(2);
		assertThat(Coin.getMaxQuantity(50, 54)).isEqualTo(1);
		assertThat(Coin.getMaxQuantity(10, 53)).isEqualTo(5);
	}

	@Test
	void 보유_금액_랜덤() {
		Map<Integer, Integer> coinMap = Coin.decideCoinRandomly(new LinkedHashMap<>(), 10000);

		assertThat(coinMap.size()).isEqualTo(Coin.values().length);

		int sum = 0;
		for (Map.Entry<Integer, Integer> entry : coinMap.entrySet()) {
			sum += entry.getKey() * entry.getValue();
		}
		assertThat(sum).isEqualTo(10000);
	}
}
