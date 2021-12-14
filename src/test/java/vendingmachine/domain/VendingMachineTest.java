package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.exception.RequestChangesException;

class VendingMachineTest {
	@Test
	void 잔돈_반환_명령() {
		// given
		String request = "잔돈";
		VendingMachine vendingMachine = new VendingMachine();

		// when
		Assertions.assertThatThrownBy(() -> vendingMachine.purchase(request))
			.isInstanceOf(RequestChangesException.class); // then
	}
}