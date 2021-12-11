package vendingmachine.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.Coin;
import vendingmachine.domain.Deposit;

class DepositRepositoryTest {

	DepositRepository depositRepository;
	List<Deposit> depositList;

	@BeforeEach
	void setUp() {
		depositRepository = new DepositRepository();
		depositList = Arrays.asList(new Deposit(Coin.COIN_10, 10), new Deposit(Coin.COIN_50, 10),
			new Deposit(Coin.COIN_100, 10), new Deposit(Coin.COIN_500, 10));
		depositRepository.save(depositList);
	}

	@Test
	void save() {
		// given
		// when
		// then
		assertThat(depositRepository.findByCoin(depositList.get(0).getCoin())).hasValueSatisfying(d -> {
			assertThat(d.getCoin()).isEqualTo(depositList.get(0).getCoin());
			assertThat(d.getCount()).isEqualTo(depositList.get(0).getCount());
		});
	}

	@Test
	void findByCoin() {
		// given
		// when
		// then
		assertThat(depositRepository.findByCoin(depositList.get(0).getCoin())).hasValueSatisfying(d -> {
			assertThat(d.getCoin()).isEqualTo(depositList.get(0).getCoin());
			assertThat(d.getCount()).isEqualTo(depositList.get(0).getCount());
		});
	}

	@Test
	void getDepositTotal() {
		// given
		int totalExpected = 6600;
		// when
		// then
		assertThat(depositRepository.getDepositTotal()).isEqualTo(totalExpected);
	}
}