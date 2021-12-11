package vendingmachine.domain;

import org.junit.jupiter.api.Test;

class MachineTest {
	private final Machine machine = new Machine();

	@Test
	void 잔돈_생성_테스트() {
		machine.setCoins(450);
		System.out.println(machine.getSortedCoinCount());
	}
}