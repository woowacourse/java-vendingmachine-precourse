package vendingmachine.MyTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.Application;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ChangesCoinGroupTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 잔돈_상품금액이_투입금액보다_많은_경우() {
		assertSimpleTest(() -> {
			runException("450", "[콜라,900,10]", "800", "콜라");
			assertThat(output()).contains(
				ERROR_MESSAGE
			);
		});
		return;
	}

	@Test
	void 잔돈_남은금액_암것도못삼() {
		assertSimpleTest(() -> {
			runException("450", "[콜라,900,10];[사이다,2000,10]", "1000", "콜라");
			assertThat(output()).contains(
				"잔돈"
			);
		});
	}

	@Test
	void 잔돈_개수확인2() {
		assertRandomNumberInListTest(() -> {
				runException("300", "[콜라,900,1];[사이다,2000,1]", "3200", "콜라", "사이다");
				assertThat(output()).contains(
					"잔돈",
					"100원 - 3개"
				);
			}, 100, 100, 100
		);
	}

	@Test
	void 잔돈_개수확인() {
		assertRandomNumberInListTest(() -> {
				runException("560", "[콜라,200,1];[사이다,200,1]", "460", "콜라", "사이다");
				assertThat(output()).contains(
					"잔돈",
					"50원 - 1개",
					"10원 - 1개"
				);
			}, 500, 50, 10
		);
	}

	@Test
	void 잔돈_재고없음() {
		assertRandomNumberInListTest(() -> {
				runException("450", "[콜라,900,1];[사이다,2000,1]", "10000", "콜라", "사이다");
				assertThat(output()).contains(
					"잔돈"
				);
			}, 100, 100, 100, 100, 50
		);
	}

	@Test
	void 잔돈_소진() {
		assertSimpleTest(() -> {
			runException("450", "[콜라,900,1]", "8000", "콜라");
			assertThat(output()).contains(
				"잔돈"
			);
		});
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}