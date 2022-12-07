package vendingmachine;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import vendingmachine.util.ExceptionMessage;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

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
    void 기능_테스트_2() {
        assertRandomNumberInListTest(
                () -> {
                    run("450", "[콜라,1500,2];[사이다,1000,1]", "3000", "콜라", "사이다");
                    assertThat(output()).contains(
                            "자판기가 보유한 동전", "500원 - 0개", "100원 - 2개", "50원 - 4개", "10원 - 5개",
                            "투입 금액: 3000원", "투입 금액: 1500원", "투입 금액: 500원",
                            "500원 - 0개", "100원 - 2개", "50원 - 4개", "10원 - 5개"
                    );
                },
                100, 100, 50, 50, 50, 50, 10, 10, 10, 10, 10
        );
    }

    @Test
    void 기능_테스트_3() {
        assertRandomNumberInListTest(
                () -> {
                    run("10000", "[콜라,1500,1];[사이다,1000,1]", "8750", "콜라", "사이다");
                    assertThat(output()).contains(
                            "자판기가 보유한 동전", "500원 - 12개", "100원 - 27개", "50원 - 21개", "10원 - 25개",
                            "투입 금액: 8750원", "투입 금액: 7250원", "투입 금액: 6250원",
                            "500원 - 12개", "100원 - 2개", "50원 - 1개", "10원 - 0개"
                    );
                },
                500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100,
                50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10
        );
    }

    @Test
    void 재입력_테스트() {
        assertRandomNumberInListTest(
                () -> {
                    run("kkk", "2222222222222222222222222222222", "21", "450",
                            "[콜라,1500,2];[사이다,1000,1]", "30000",
                            "콜라", "아아아", "사 이 다 ", "사이다", "콜라");
                    assertThat(output()).contains(
                            ExceptionMessage.INVALID_NOT_NUMERIC.getMessage(),
                            ExceptionMessage.INVALID_OUT_OF_INT_RANGE.getMessage(),
                            ExceptionMessage.INVALID_UNIT.getMessage(),
                            "자판기가 보유한 동전", "500원 - 0개", "100원 - 3개", "50원 - 2개", "10원 - 5개",
                            "투입 금액: 30000원", "투입 금액: 28500원",
                            ExceptionMessage.INVALID_NO_SUCH_PRODUCT.getMessage(),
                            "투입 금액: 27500원",
                            "투입 금액: 27500원",
                            "투입 금액: 26000원",
                            "500원 - 0개", "100원 - 3개", "50원 - 2개", "10원 - 5개"
                    );
                },
                100, 100, 100, 50, 50, 10, 10, 10, 10, 10
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("-1");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
