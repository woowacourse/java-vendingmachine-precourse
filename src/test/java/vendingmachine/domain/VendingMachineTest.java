package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class VendingMachineTest {

	@Test
	void 보유_금액_랜덤() {
		VendingMachine vendingMachine = VendingMachine.create();
		Map<Coin, Integer> coinMap = vendingMachine.decideCoinRandomly(Coin.values(), 10000);

		assertThat(coinMap.size()).isEqualTo(Coin.values().length);

		int[] coin = {500, 100, 50, 10};
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += coin[i] * coinMap.get(Coin.values()[i]);
		}
		assertThat(sum).isEqualTo(10000);
	}

}
