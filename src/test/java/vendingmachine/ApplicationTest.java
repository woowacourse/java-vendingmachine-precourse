package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
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

    @Nested
    class inputMachineCoin_메소드_예외_테스트 {
        @Test
        void 범위_밖의_수가_들어오면_예외() {
            assertSimpleTest(
                    () -> {
                        runException("-1");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    }
            );
        }

        @Test
        void 숫자가_아닌_값이_들어오면_예외() {
            assertSimpleTest(
                    () -> {
                        runException("한글");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    }
            );
        }
    }

    @Nested
    class inputProduct_메소드_예외_테스트 {
        @Test
        void 주어진_형식의_개수가_맞지_않으면_예외() {
            assertSimpleTest(
                    () -> {
                        runException("450", "[콜라,1500,20,0];[사이다,1000,10]");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    }
            );
        }

        @Test
        void 금액이_숫자가_아니면_예외() {
            assertSimpleTest(
                    () -> {
                        runException("450", "[콜라,금액,20];[사이다,1000,10]");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    }
            );
        }

        @Test
        void 개수가_숫자가_아니면_예외() {
            assertSimpleTest(
                    () -> {
                        runException("450", "[콜라,1500,개수,0];[사이다,1000,10]");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    }
            );
        }
    }

    @Nested
    class inputCash_메소드_예외_테스트 {
        @Test
        void 숫자가_아닌_값이_들어오면_예외() {
            assertSimpleTest(
                    () -> {
                        runException("450", "[콜라,1500,개수,0];[사이다,1000,10]", "글자");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    }
            );
        }

        @Test
        void 숫자가_0과_100000000_사이의_수가_아니면_예외() {
            assertSimpleTest(
                    () -> {
                        runException("450", "[콜라,1500,개수,0];[사이다,1000,10]", "-1");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    }
            );
        }
    }


    @Nested
    class inputPurchase_메소드_예외_테스트 {
        @Test
        void 구매하려는_금액이_남은_금액보다_큰_금액이면_예외() {
            assertSimpleTest(
                    () -> {
                        runException("450", "[콜라,1500,개수,0];[사이다,1000,10]", "1200", "콜라");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    }
            );
        }

        @Test
        void 구매하려는_물건이_존재하지_않으면_예외() {
            assertSimpleTest(
                    () -> {
                        runException("450", "[콜라,1500,개수,0];[사이다,1000,10]", "3000", "김치");
                        assertThat(output()).contains(ERROR_MESSAGE);
                    }
            );
        }
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
