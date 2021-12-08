package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserMoneyTest {
	@Test
	@DisplayName("유저 투입 금액 검증")
	void validUserMoneyTest() {
		int userMoney1 = 11;
		int userMoney2 = 0;
		int userMoney3 = 1000;
		assertThat(UserMoney.valid(userMoney1)).isFalse();
		assertThat(UserMoney.valid(userMoney2)).isFalse();
		assertThat(UserMoney.valid(userMoney3)).isTrue();
	}
}
