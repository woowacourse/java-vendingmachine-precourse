package vendingmachine.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.Coin;
import vendingmachine.constant.Hint;
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

	@Test
	void saveDeposit() {
		// given
		Deposit deposit = new Deposit(Coin.COIN_10, 1);
		// when
		depositRepository.save(deposit);
		// then
		assertThat(depositRepository.findByCoin(deposit.getCoin())).hasValueSatisfying(d -> {
			assertThat(d.getCoin()).isEqualTo(deposit.getCoin());
			assertThat(d.getCount()).isEqualTo(deposit.getCount());
		});
	}

	@Test
	void testToString() {
		// given
		// when
		// then
		assertThat(depositRepository.toString()).satisfies(s -> {
			assertThat(s).contains(String.format(Hint.DEPOSIT_EACH.getHint(), depositList.get(0).getCoin().getAmount(),
				depositList.get(0).getCount()));
			assertThat(s).contains(String.format(Hint.DEPOSIT_EACH.getHint(), depositList.get(1).getCoin().getAmount(),
				depositList.get(1).getCount()));
			assertThat(s).contains(String.format(Hint.DEPOSIT_EACH.getHint(), depositList.get(2).getCoin().getAmount(),
				depositList.get(2).getCount()));
			assertThat(s).contains(String.format(Hint.DEPOSIT_EACH.getHint(), depositList.get(3).getCoin().getAmount(),
				depositList.get(3).getCount()));
		});
	}
}