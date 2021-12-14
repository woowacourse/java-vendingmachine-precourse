package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.ChangesExceptionTest;
import vendingmachine.domain.ProductExceptionTest;
import vendingmachine.domain.SuccessfulTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import static vendingmachine.domain.SuccessfulTest.*;
import static vendingmachine.domain.ChangesExceptionTest.*;
import static vendingmachine.domain.ProductExceptionTest.*;

import java.util.ArrayList;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        ArrayList<SuccessfulTest> data = getSuccessfulTestData();
        for (SuccessfulTest testCase : data) {
            if (testCase == null) {
                continue;
            }

            assertRandomNumberInListTest(
                () -> {
                    run(testCase.input);
                    assertThat(output()).contains(
                        testCase.output
                    );
                },
                testCase.coin, testCase.coins
            );
        }
    }

    @Test
    void 랜덤동전_예외_테스트() {
        ArrayList<ChangesExceptionTest> data = getChangesExceptionTestData();
        for (ChangesExceptionTest testCase : data) {
            if (testCase == null) {
                continue;
            }

            assertSimpleTest(
                () -> {
                    runException(testCase.moneyOfChanges);
                    assertThat(output()).contains(ERROR_MESSAGE, testCase.errorMessage);
                }
            );
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
