package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.ChangesExceptionTest;
import vendingmachine.domain.MoneyExceptionTest;
import vendingmachine.domain.ProductExceptionTest;
import vendingmachine.domain.PurchaseExceptionTest;
import vendingmachine.domain.SuccessfulTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import static vendingmachine.domain.SuccessfulTest.*;
import static vendingmachine.domain.ChangesExceptionTest.*;
import static vendingmachine.domain.ProductExceptionTest.*;
import static vendingmachine.domain.MoneyExceptionTest.*;
import static vendingmachine.domain.PurchaseExceptionTest.*;

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
                () -> { run(testCase.input);
                        assertThat(output()).contains(testCase.output); },
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
                () -> { runException(testCase.moneyOfChanges);
                        assertThat(output()).contains(ERROR_MESSAGE, testCase.errorMessage); }
            );
        }
    }

    @Test
    void 상품_등록_예외_테스트() {
        ArrayList<ProductExceptionTest> data = getProductExceptionTest();
        for (ProductExceptionTest testCase : data) {
            if (testCase == null) {
                continue;
            }
            assertSimpleTest(
                () -> { runException(testCase.moneyOfChanges, testCase.products);
                        assertThat(output()).contains(ERROR_MESSAGE, testCase.errorMessage); }
            );
        }
    }

    @Test
    void 투입_금액_예외_테스트() {
        ArrayList<MoneyExceptionTest> data = getMoneyExceptionTest();
        for (MoneyExceptionTest testCase : data) {
            if (testCase == null) {
                continue;
            }
            assertSimpleTest(
                () -> { runException(testCase.moneyOfChanges, testCase.products, testCase.money);
                        assertThat(output()).contains(ERROR_MESSAGE, testCase.errorMessage); }
            );
        }
    }

    @Test
    void 구매할_상품_예외_테스트() {
        ArrayList<PurchaseExceptionTest> data = getPurchaseExceptionTest();
        for (PurchaseExceptionTest testCase : data) {
            if (testCase == null) {
                continue;
            }
            assertSimpleTest(
                () -> { runException(testCase.moneyOfChanges, testCase.products, testCase.money,testCase.selectedProduct);
                        assertThat(output()).contains(testCase.errorMessage); }
            );
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
