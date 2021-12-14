package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.constant.ErrorMessage;
import vendingmachine.validator.InputValidator;

class CoinTest {

	@AfterEach
	void tearDown() {
		Coin.clear();
	}

	@Test
	void 자판기_보유_금액_최소_동전() {
		int inputMachineMoney = 780;
		Coin.add(inputMachineMoney);
		assertThat(Coin.getTotal()).isEqualTo(inputMachineMoney);
	}

	@Test
	void 자판기_보유_금액_랜덤() {
		int inputMachineMoney = 780;
		Coin.generateRandomCount(inputMachineMoney);
		assertThat(Coin.getTotal()).isEqualTo(inputMachineMoney);
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "-1", "a", "4a2", "123"})
	void 보유금액_입력_예외(String input) {
		assertThatThrownBy(() -> InputValidator.validateMachineMoney(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorMessage.ERROR_PREFIX);
	}
}