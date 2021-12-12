package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;
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

    @Test
    void 반환불가_잔돈_테스트() {
        assertRandomNumberInListTest(
                () -> {
                    run("1000", "[콜라,300,2]", "1000", "콜라", "콜라");
                    assertThat(output()).contains(
                            "자판기가 보유한 동전", "500원 - 2개", "100원 - 0개", "50원 - 0개", "10원 - 0개",
                            "투입 금액: 1000원", "투입 금액: 700원", "투입 금액: 400원",
                            "잔돈"
                    );
                },
                500, 500
        );
    }

    @Test
    void 재고_없고_줄수있는_잔돈보다_투입금액이_클떄_잔돈_테스트() {
        assertRandomNumberInListTest(
                () -> {
                    run("1000", "[콜라,1000,1]", "1900", "콜라", "콜라");
                    assertThat(output()).contains(
                            "자판기가 보유한 동전", "500원 - 2개", "100원 - 0개", "50원 - 0개", "10원 - 0개",
                            "투입 금액: 1900원", "투입 금액: 900원",
                            "잔돈", "500원 - 1개"
                    );
                },
                500, 500
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
