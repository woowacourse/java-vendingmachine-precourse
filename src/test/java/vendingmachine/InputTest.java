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

	@Test
	void 잔돈_상품금액이_투입금액보다_많은_경우() {
		assertSimpleTest(() -> {
			runException("450", "[콜라,900,10]", "800", "콜라");
			assertThat(output()).contains(
				"잔돈"
			);
		});
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
	void 잔돈_재고없음() {
		assertSimpleTest(() -> {
			runException("450", "[콜라,900,1];[사이다,2000,1]", "10000", "콜라", "사이다");
			assertThat(output()).contains(
				"잔돈"
			);
		});
	}

	@Test
	void 잔돈_개수확인() {
		assertRandomNumberInListTest(() -> {
			runException("990", "[콜라,100,1];[사이다,200,1]", "360", "콜라", "사이다");
			assertThat(output()).contains(
				"잔돈",
				"50원 - 1개", "10원 - 1개"
			);
		}, 500, 100, 100, 100, 100, 50, 10, 10, 10, 10
		);
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

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}