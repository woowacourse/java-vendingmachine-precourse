package vendingmachine.MyTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.Application;
import vendingmachine.Utils.Constants;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BeverageTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 상품_입력_받기_특수문자() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,1500,20];-[사이다,1000,10]");
				assertThat(output()).contains(
					Constants.ERROR_BEVERAGE_STRING
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_대괄호노() {
		assertSimpleTest(
			() -> {
				runException("450", "콜라,1500,20];[사이다,1000,10]");
				assertThat(output()).contains(
					Constants.ERROR_BEVERAGE_STRING
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_세미콜론_이외() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,1500,20]a[사이다,1000,10]");
				assertThat(output()).contains(
					Constants.ERROR_BEVERAGE_STRING
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_문자쉼표숫자이외() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라;,1500,20];[사이다,1000,10]");
				assertThat(output()).contains(
					Constants.ERROR_BEVERAGE_STRING
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_쉼표2개노() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,150020];[사이다,1000,10]");
				assertThat(output()).contains(
					Constants.ERROR_BEVERAGE_STRING
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_정상작동() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,1500,20];[사이다,1000,10];[환타,1000,10]");
				assertThat(output()).doesNotContain(
					ERROR_MESSAGE
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_이름중복() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,1500,20];[사이다,1000,10];[콜라,1000,10]");
				assertThat(output()).contains(
					Constants.ERROR_BEVERAGE_DUPLICATED
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_빈이름() {
		assertSimpleTest(
			() -> {
				runException("450", "[,1500,20];[사이다,1000,10];[환타,1000,10]");
				assertThat(output()).contains(
					Constants.ERROR_NAME_STRING
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_이름에밑줄존재() {
		assertSimpleTest(
			() -> {
				runException("450", "[_,1500,20];[사이다,1000,10];[환타,1000,10]");
				assertThat(output()).contains(
					Constants.ERROR_NAME_STRING
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_금액에러() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,1501,20]");
				assertThat(output()).contains(
					Constants.ERROR_MONEY_UNIT
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_금액에러2() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,90,20]");
				assertThat(output()).contains(
					Constants.ERROR_MONEY_RANGE
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_수량에러() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,900,0]");
				assertThat(output()).contains(
					Constants.ERROR_NUMBER_PATTERN
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_수량에러2() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,900,01]");
				assertThat(output()).contains(
					Constants.ERROR_NUMBER_PATTERN
				);
			}
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
