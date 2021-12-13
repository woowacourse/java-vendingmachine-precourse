package vendingmachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class VendingMachineTest {
	final String notNumber = "notNumber";
	final String isNumber = "123";
	final String isRightNumber = "100";

	@Nested
	@DisplayName("자판기 보유한 금액 생성 테스트")
	class testTotalCoin {
		@Test
		void ChangeMaketest1() {
			assertThrows(IllegalArgumentException.class, () -> new VendingMachine(notNumber));
		}

		@Test
		void ChangeMaketest2() {
			assertThrows(IllegalArgumentException.class, () -> new VendingMachine(isNumber));
		}

		@Test
		void ChangeMaketest3() {
			assertDoesNotThrow(() -> new VendingMachine(isRightNumber));
		}
	}

	@Nested
	@DisplayName("무작위 코인 생성 테스트")
	class testRandomCoin {
		@Test
		void MakeRandomCoin() {
			VendingMachine a = new VendingMachine(isRightNumber);
		}
	}
}
