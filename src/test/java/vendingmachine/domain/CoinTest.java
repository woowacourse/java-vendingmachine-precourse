package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.constant.ErrorMessage;
import vendingmachine.validator.InputValidator;

class CoinTest {

	@Test
	void 입력한_코인의_금액_검증() {
		int inputMachineMoney = 780;
		Coin.add(inputMachineMoney);
		List<Coin> coins = Coin.get();
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