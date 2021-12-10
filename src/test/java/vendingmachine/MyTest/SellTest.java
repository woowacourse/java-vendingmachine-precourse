package vendingmachine.MyTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.Application;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class SellTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 구매상품명_받기_예외_안에없음() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,900,10]", "1000", "환타");
				assertThat(output()).contains(
					ERROR_MESSAGE
				);
			}
		);
	}

	@Test
	void 구매상품명_받기_예외_특수문자() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,900,10]", "1000", ",");
				assertThat(output()).contains(
					ERROR_MESSAGE
				);
			}
		);
	}

	@Test
	void 구매상품명_받기() {
		assertSimpleTest(() -> {
			runException("450", "[콜라,900,10]", "1000", "콜라");
			assertThat(output()).doesNotContain(
				ERROR_MESSAGE
			);
		});
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}