package vendingmachine.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.repository.DepositRepository;

class MachineServiceTest {

	MachineService machineService;
	DepositRepository depositRepository;

	@BeforeEach
	void setUp() {
		depositRepository = new DepositRepository();
		machineService = new MachineService(depositRepository);
	}

	@Test
	void setDepositsRandomized() {
		// given
		int deposit = 550;
		// when
		machineService.setDepositsRandomized(deposit);
		// then
		assertThat(depositRepository.getDepositTotal()).isEqualTo(deposit);
	}
}