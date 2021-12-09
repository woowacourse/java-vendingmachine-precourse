package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoinTest {

	@Test
	void 가능한_개수__목록() {
		assertThat(Coin.getPossibleQuantity(Coin.COIN_500, 0).size()).isEqualTo(1);
		assertThat(Coin.getPossibleQuantity(Coin.COIN_500, 499).size()).isEqualTo(1);
		assertThat(Coin.getPossibleQuantity(Coin.COIN_500, 500).size()).isEqualTo(2);
		assertThat(Coin.getPossibleQuantity(Coin.COIN_10, 0).size()).isEqualTo(1);
		assertThat(Coin.getPossibleQuantity(Coin.COIN_10, 19).size()).isEqualTo(2);
		assertThat(Coin.getPossibleQuantity(Coin.COIN_10, 20).size()).isEqualTo(3);
	}

	@Test
	void 잔여금_반환() {
		assertThat(Coin.calculateResidue(Coin.COIN_500, 10000, 2)).isEqualTo(9000);
		assertThat(Coin.calculateResidue(Coin.COIN_100, 7400, 20)).isEqualTo(5400);
		assertThat(Coin.calculateResidue(Coin.COIN_50, 300, 4)).isEqualTo(100);
		assertThat(Coin.calculateResidue(Coin.COIN_10, 14, 1)).isEqualTo(4);
	}

	@Test
	void 최대_가능_동전개수() {
		assertThat(Coin.getMaxQuantity(Coin.COIN_500, 2400)).isEqualTo(4);
		assertThat(Coin.getMaxQuantity(Coin.COIN_100, 220)).isEqualTo(2);
		assertThat(Coin.getMaxQuantity(Coin.COIN_50, 54)).isEqualTo(1);
		assertThat(Coin.getMaxQuantity(Coin.COIN_10, 53)).isEqualTo(5);
	}
}
