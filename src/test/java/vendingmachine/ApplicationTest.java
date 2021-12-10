package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("금액과 재고가 부족한 상황에서의 기능테스트")
    @Test
    void 구매불가능_상품존재_기능_테스트() {
        assertRandomNumberInListTest(
                () -> {
                    run("570", "[콜라,1500,1];[사이다,1000,2];[apple,460,1]", "3000", "apple", "사이다", "사이다");
                    assertThat(output()).contains(
                            "자판기가 보유한 동전", "500원 - 0개", "100원 - 5개", "50원 - 0개", "10원 - 7개",
                            "투입 금액: 3000원", "투입 금액: 2540원", "투입 금액: 1540원", "투입 금액: 540원",
                            "잔돈", "100원 - 5개", "10원 - 4개"
                    );
                },
                100, 100, 100, 100, 100, 10, 10, 10, 10, 10, 10, 10
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
