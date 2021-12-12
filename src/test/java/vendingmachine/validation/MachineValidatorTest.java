package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.Machine;

class MachineValidatorTest {
	private static final String MERCHANDISE = "[콜라,1000,3];[사이다,2000,3]";
	private final Machine machine = new Machine();
	private final MachineValidator validator = new MachineValidator(machine);

	MachineValidatorTest() {
		machine.setMerchandise(MERCHANDISE);
	}

	@Test
	void 상품_구입_실패_테스트() {
		validator.isValidSelectedItem("환타");
	}

	@Test
	void 상품_구입_성공_테스트() {
		validator.isValidSelectedItem("사이다");
	}

}