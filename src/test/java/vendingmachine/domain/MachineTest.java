package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MachineTest{

	private Machine machine;

	@BeforeEach
	void beforeEach(){
		machine = Machine.MACHINE;
		machine.insertCoinToMachine(100);
	}

	@Test
	void 머신_투입금액_가져오기_테스트(){
		assertEquals(machine.getAmount(), 100);
	}

	@Test
	void 머신_투입급액_변경_테스트(){
		machine.changeAmount(10);
		assertEquals(machine.getAmount(), 90);
	}

}