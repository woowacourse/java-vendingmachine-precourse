package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
	@Test
	@DisplayName("10원 단위 나누어 떨어지는지 테스트")
	void validUnitMoneyTest() {
		int testMoney1 = 30;
		int testMoney2 = 411;
		assertThat(ValidationUtils.validUnitMoney(testMoney1)).isTrue();
		assertThat(ValidationUtils.validUnitMoney(testMoney2)).isFalse();
	}

	@Test
	@DisplayName("숫자가 아님 테스트")
	void validNumberFormatTest() {
		String testStr1 = "a1";
		String testStr2 = "500";
		assertThat(ValidationUtils.validNumberFormat(testStr1)).isFalse();
		assertThat(ValidationUtils.validNumberFormat(testStr2)).isTrue();
	}

	@Test
	@DisplayName("자연수가 아닌 경우")
	void isPositiveTest() {
		int testNum1 = -1;
		int testNum2 = 0;
		int testNum3 = 3;
		assertThat(ValidationUtils.isPositive(testNum1)).isFalse();
		assertThat(ValidationUtils.isPositive(testNum2)).isFalse();
		assertThat(ValidationUtils.isPositive(testNum3)).isTrue();
	}
}
