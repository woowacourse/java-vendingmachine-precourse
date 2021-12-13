package vendingmachine.validation;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.Machine;

class MachineValidatorTest {
	private final List<String> item = new ArrayList<>();
	private final Machine machine = new Machine();
	private final MachineValidator validator = new MachineValidator(machine);

	MachineValidatorTest() {
		item.add("[콜라,1000,3]");
		item.add("[사이다,2000,3]");
		machine.setMerchandise(item);
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