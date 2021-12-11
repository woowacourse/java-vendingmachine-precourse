package vendingmachine;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static vendingmachine.config.ConstantConfig.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {

	@Test
	void 기능_테스트() {
		assertRandomNumberInListTest(
			() -> {
				run("450", "[콜라,1500,20];[사이다,1000,10]", "3000", "콜라", "사이다");
				assertThat(output()).contains(
					"자판기가 보유한 동전", "500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개",
					"투입 금액: 3000원", "투입 금액: 1500원"
				);
			},
			100, 100, 100, 100, 50
		);
	}

	@Test
	void 기능_테스트2_잔돈부족() {
		assertRandomNumberInListTest(
			() -> {
				run("300", "[치킨,9500,1]", "10000", "치킨");
				assertThat(output()).contains(
					"자판기가 보유한 동전", "500원 - 0개", "100원 - 3개", "50원 - 0개", "10원 - 0개",
					"투입 금액: 10000원", "투입 금액: 500원", "잔돈\n100원 - 3개"
				);
			},
			100, 100, 100
		);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(
			() -> {
				runException("-1");
				assertThat(output()).contains(AMOUNT_NUMBER_FORMAT_EXCEPTION_MESSAGE);
			}
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
