package vendingmachine.model.user;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.Application;

class UserMoneyTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 투입_금액_10원_단위_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,1500,20];[사이다,1000,10]", "1009");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 투입_금액_최솟값_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,1500,20];[사이다,1000,10]", "900");
                assertThat(output()).contains(ERROR_MESSAGE);
            },
            100, 100, 100, 100, 50
        );
    }

    @Test
    void 투입_금액_문자_예외_테스트() {
        assertRandomNumberInListTest(
            () -> {
                runException("450", "[콜라,1500,20];[사이다,1000,10]", "오백원");
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
