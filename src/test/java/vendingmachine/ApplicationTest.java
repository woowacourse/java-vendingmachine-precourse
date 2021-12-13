package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import vendingmachine.service.ProductService;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static vendingmachine.utils.VerificationUtil.validateHoldingAmount;
import static vendingmachine.utils.VerificationUtil.validateProductInput;

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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void pickNumberInListTest() throws Exception {
        //given
        List<Integer> numberList = Arrays.asList(1,2,3,4);

        //when
        int result = pickNumberInList(numberList);

        //then
        assertThat(result).isGreaterThan(0).isLessThanOrEqualTo(4);
    }

    @Test
    public void 잔돈_테스트() {
        assertRandomNumberInListTest(
                () -> {
                    run("3000", "[a,1000,1];[b,2000,1];[c,200,1]", "6000", "a", "b", "c");
                    assertThat(output()).contains(
                            "자판기가 보유한 동전", "500원 - 4개", "100원 - 7개", "50원 - 5개", "10원 - 5개",
                            "투입 금액: 5000원", "투입 금액: 3000원", "투입 금액: 2800원"
                    );
                },
                500, 500, 500, 500,
                100, 100, 100, 100, 100, 100, 100,
                50, 50, 50, 50, 50,
                10, 10, 10, 10, 10
        );
    }

    @Test
    public void 상품_100원이상_테스트() {
        //given
        ProductService productService = new ProductService();

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            productService.createProductList("[a,1550,1];[b,90,1]");
        });
    }

    @Test
    public void 최소_개수_동전_테스트() {
        assertRandomNumberInListTest(
                () -> {
                    run("3000", "[a,1000,1];[b,2000,1];[c,200,1]", "6000", "a", "b", "c");
                    assertThat(output()).contains(
                            "자판기가 보유한 동전", "500원 - 4개", "100원 - 7개", "50원 - 5개", "10원 - 5개",
                            "투입 금액: 5000원", "투입 금액: 3000원", "투입 금액: 2800원",
                            "500원 - 4개", "100원 - 7개", "50원 - 2개"
                    );
                },
                500, 500, 500, 500,
                100, 100, 100, 100, 100, 100, 100,
                50, 50, 50, 50, 50,
                10, 10, 10, 10, 10
        );
    }

    @Test
    public void 십단위_아닌_금액_테스트() throws Exception {
        //when
        String input = "123";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            validateHoldingAmount(input);
        });
    }

    @Test
    public void 상품_입력_테스트1() throws Exception {
        //when
        String input = "[a,a,1]";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            validateProductInput(input);
        });
    }

    @Test
    public void 상품_입력_테스트2() throws Exception {
        //when
        String input = "[a,1,a]";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            validateProductInput(input);
        });
    }
}
