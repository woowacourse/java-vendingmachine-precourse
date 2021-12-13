package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CoinTest {

	@Test
	void 입력한_코인의_금액_검증() {
		int inputMachineMoney = 780;
		Coin.add(inputMachineMoney);
		List<Coin> coins = Coin.get();
		assertThat(Coin.getTotal()).isEqualTo(inputMachineMoney);
	}
}