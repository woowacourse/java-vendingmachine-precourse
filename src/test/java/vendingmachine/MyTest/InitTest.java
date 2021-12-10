package vendingmachine.MyTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.Application;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InitTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 자판기_보유금액_입력_받기_예외_a() {
		assertSimpleTest(() -> {
			runException("a");
			assertThat(output()).contains(
				"자판기가 보유하고 있는 금액을 입력해 주세요.",
				ERROR_MESSAGE
			);
		});
	}

	@Test
	void 자판기_보유금액_입력_받기_예외_0() {
		assertSimpleTest(() -> {
			runException("0");
			assertThat(output()).contains(
				"자판기가 보유하고 있는 금액을 입력해 주세요.",
				ERROR_MESSAGE
			);
		});
	}

	@Test
	void 자판기_보유금액_입력_받기_예외_012() {
		assertSimpleTest(() -> {
			runException("012");
			assertThat(output()).contains(
				"자판기가 보유하고 있는 금액을 입력해 주세요.",
				ERROR_MESSAGE
			);
		});
	}

	@Test
	void 자판기_보유금액_입력_받기_예외_90() {
		assertSimpleTest(() -> {
			runException("90");
			assertThat(output()).contains(
				"자판기가 보유하고 있는 금액을 입력해 주세요.",
				ERROR_MESSAGE
			);
		});
	}

	@Test
	void 자판기_보유금액_입력_받기_예외_101() {
		assertSimpleTest(() -> {
			runException("101");
			assertThat(output()).contains(
				"자판기가 보유하고 있는 금액을 입력해 주세요.",
				ERROR_MESSAGE
			);
		});
	}

	@Test
	void 자판기_보유동전_출력() {
		assertRandomNumberInListTest(
			() -> {
				runException("450");
				assertThat(output()).contains(
					"자판기가 보유하고 있는 금액을 입력해 주세요.",
					"자판기가 보유한 동전",
					"500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개"
				);
			},
			100, 100, 100, 100, 50
		);
	}

	@Test
	void 투입금액_받기_예외0() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,900,10]", "0");
				assertThat(output()).contains(
					ERROR_MESSAGE
				);
			}
		);
	}

	@Test
	void 투입금액_받기_예외01() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,900,10]", "01");
				assertThat(output()).contains(
					ERROR_MESSAGE
				);
			}
		);
	}

	@Test
	void 투입금액_받기_예외90() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,900,10]", "90");
				assertThat(output()).contains(
					ERROR_MESSAGE
				);
			}
		);
	}

	@Test
	void 투입금액_받기_예외101() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,900,10]", "101");
				assertThat(output()).contains(
					ERROR_MESSAGE
				);
			}
		);
	}

	@Test
	void 투입금액_받기_100() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,900,10]", "100");
				assertThat(output()).doesNotContain(
					ERROR_MESSAGE
				).contains("투입 금액: 100원");
			}
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
