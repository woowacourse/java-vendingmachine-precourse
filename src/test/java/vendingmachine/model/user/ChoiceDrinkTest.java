package vendingmachine.model.user;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.Application;

class ChoiceDrinkTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 없는_상품_선택_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,1500,20];[사이다,1000,10]", "3000", "삼다수");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 품절_상품_선택_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,1500,2];[사이다,1000,1]", "3000", "사이다", "사이다");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 잔액_보다_비싼_상품_선택_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,2500,2];[사이다,1000,2]", "3000", "사이다", "콜라");
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
