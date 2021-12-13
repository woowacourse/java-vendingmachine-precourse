package vendingmachine.model.drink;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.Application;

class DrinksTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 상품명_공백_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[,1500,20];[사이다,1000,10]");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 상품명_중복_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[사이다,1500,20];[사이다,1000,10]");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 가격_문자_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,오백원,20];[사이다,1000,10]");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 가격_100원_미만_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,90,20];[사이다,1000,10]");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 가격_10원_단위_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,103,20];[사이다,1000,10]");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 수량_단위_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,200,-1];[사이다,1000,10]");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 수량_문자_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,200,삼];[사이다,1000,10]");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[] {});
    }
}
