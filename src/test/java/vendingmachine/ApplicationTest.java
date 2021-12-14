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
    void 예외_테스트() {
        assertSimpleTest(
            () -> {
                runException("-1");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void test_try_buying_soldout() {
        assertRandomNumberInListTest(
            () -> {
                run("1050", "[콜라,1500,1];[사이다,1300,0]", "2800", "사이다", "콜라");
                assertThat(output()).contains(
                    "\"사이다\"은(는) 현재 구매 불가능한 상태입니다."
                );
            },
            100, 100, 100, 100, 500, 100, 50
        );
    }

    @Test
    void test_wrong_product_name() {
        assertRandomNumberInListTest(
            () -> {
                run("450", "[콜라,1500,20];[사이다,1000,10]", "3000", "콜,러", "킬]라", "콜라", "사이다");
                assertThat(output()).contains(
                    "[ERROR] 상품명에는 ','나 ';'는 불가합니다.",
                    "[ERROR] \"킬]라\"라는 이름의 상품이 존재하지 않습니다."
                );
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void test_wrong_price() {
        assertRandomNumberInListTest(
            () -> {
                run("450", "[콜라,1500,1];[사이다,1300,10]", "-100", "3000", "콜라", "사이다");
                assertThat(output()).contains(
                    "[ERROR] 양의 정수를 입력해주세요.", "잔돈", "100원 - 2개"
                );
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void test_zero_change() {
        assertRandomNumberInListTest(
            () -> {
                run("450", "[콜라,1500,1];[사이다,1300,1]", "2800", "콜라", "사이다");
                assertThat(output()).contains(
                    "투입 금액: 0원"
                );
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void test_zero_stock() {
        assertRandomNumberInListTest(
            () -> {
                run("1050", "[콜라,1500,0];[사이다,1300,0]", "2800", "콜라");
                assertThat(output()).contains(
                    "투입 금액: 2800원"
                );
            },
            100, 100, 100, 100, 500, 100, 50
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
