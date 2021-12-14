package vendingmachine.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.Coin;
import vendingmachine.domain.Deposit;
import vendingmachine.repository.DepositRepository;

class DepositServiceTest {

	private DepositService depositService;
	private DepositRepository depositRepository;

	@BeforeEach
	void setUp() {
		this.depositRepository = new DepositRepository();
		this.depositService = new DepositService(depositRepository);
	}

	@Test
	void setDepositsRandomized() {
		// given
		int deposit = 550;
		// when
		depositService.setDepositsRandomized(String.valueOf(deposit));
		// then
		assertThat(depositRepository.getDepositTotal()).isEqualTo(deposit);
	}

	@Test
	void spit() {
		// given
		Deposit depositFiveThousands = new Deposit(Coin.COIN_500, 10);
		depositRepository.save(depositFiveThousands);
		int moneyToSpit = 4900;
		int changesExpected = 4500;
		int depositTotalAfterSpitExpected = 500;
		// when
		DepositRepository changes = depositService.spit(moneyToSpit);
		// then
		assertThat(changes.getDepositTotal()).isEqualTo(changesExpected);
		assertThat(depositRepository.getDepositTotal()).isEqualTo(depositTotalAfterSpitExpected);
	}
}