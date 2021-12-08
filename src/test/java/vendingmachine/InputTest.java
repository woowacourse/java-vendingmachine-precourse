package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputTest extends NsTest {
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
	void 보유금액을_보유동전개수로_변환_450() {
		assertSimpleTest(() -> {
			runException("450");
			assertThat(output()).contains(
				"자판기가 보유하고 있는 금액을 입력해 주세요.",
				ERROR_MESSAGE
			);
		});
	}

	@Test
	void 자판기_보유금액_입력_받기() {
		assertSimpleTest(
			() -> {
				run("450");
				assertThat(output()).contains(
					"자판기가 보유하고 있는 금액을 입력해 주세요.",
					"자판기가 보유한 동전",
					"500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개"
				);
			}
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}