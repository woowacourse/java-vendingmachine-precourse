package vendingmachine.MyTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.Application;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


public class ProductTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 상품_입력_받기_특수문자() {
		assertSimpleTest(
			() -> {
				runException("450", "[콜라,1500,20];-[사이다,1000,10]");
				assertThat(output()).contains(
					ERROR_MESSAGE
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
					ERROR_MESSAGE
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
					ERROR_MESSAGE
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
					ERROR_MESSAGE
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
					ERROR_MESSAGE
				);
			}
		);
	}

	@Test
	void 상품_입력_받기_물건3개이상() {
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
					ERROR_MESSAGE
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
					ERROR_MESSAGE
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
					ERROR_MESSAGE
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
					ERROR_MESSAGE
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
					ERROR_MESSAGE
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
					ERROR_MESSAGE
				);
			}
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
