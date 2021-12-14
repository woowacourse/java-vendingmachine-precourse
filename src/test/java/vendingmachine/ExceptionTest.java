
package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import vendingmachine.utils.Exception;

class ExceptionTest extends NsTest {

    @Test
    void 자판기_보유_금액_예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("-1");
                    assertThat(output()).contains(Exception.NUMBER_EXCEPTION_MESSAGE);
                }
        );
    }

    @Test
    void 입력_상품_형식_예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("450", "콜라,1500,20];[콜라,1000,10]");
                    assertThat(output()).contains(Exception.PRODUCT_INPUT_FORM_EXCEPTION_MESSAGE);
                }
        );
    }

    @Test
    void 입력_상품_중복_예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("450", "[콜라,1500,20];[콜라,1000,10]");
                    assertThat(output()).contains(Exception.PRODUCT_NAME_DUPLICATE_EXCEPTION_MESSAGE);
                }
        );
    }

    @Test
    void 입력_상품_수량_예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("450", "[콜라,1500,20];[사이다,1000,0]");
                    assertThat(output()).contains(Exception.PRODUCT_QUANTITY_ZERO_EXCEPTION_MESSAGE);
                }
        );
    }

    @Test
    void 투입_금액_예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("450", "[콜라,1500,20];[사이다,1000,10]", "11");
                    assertThat(output()).contains(Exception.NUMBER_DIVIDE_TEM_EXCEPTION_MESSAGE);
                }
        );
    }

    @Test
    void 없는_상품_구매_예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("450", "[콜라,1500,20];[사이다,1000,10]", "3000", "환타");
                    assertThat(output()).contains(Exception.PRODUCT_NO_NAME_EXCEPTION_MESSAGE);
                }
        );
    }

    @Test
    void 품절_상품_구매_예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("450", "[콜라,1500,1];[사이다,1000,10]", "5000", "콜라", "콜라");
                    assertThat(output()).contains(Exception.PRODUCT_SOLD_OUT_MESSAGE);
                }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
