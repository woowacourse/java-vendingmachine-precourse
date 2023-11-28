package vendingmachine.domain.menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.money.Cash;

class MenuTest {

    @Nested
    @DisplayName("객체 생성 테스트")
    class 객체_생성_테스트 {

        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = {"[콜라,1500,20]", "[사이다,1000,10]"})
        @DisplayName("[SUCCESS] 올바른 입력에서 객체 생성을 성공한다.")
        void success(String input) {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Menu.from(input));
        }

        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = {"[콜라,1500,0]", "[사이다,1000,-1]", "[콜라,1500,a]"})
        @DisplayName("[EXCEPTION] 잘못된 수량 입력시 예외가 발생한다.")
        void invalid_amount(String input) {
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> Menu.from(input));
        }

        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = {"[콜라,-150,0]", "[사이다,0,-1]", "[콜라,30,a]", "[콜라,145,a]"})
        @DisplayName("[EXCEPTION] 잘못된 금액 입력시 예외가 발생한다.")
        void invalid_price(String input) {
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> Menu.from(input));
        }

        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = {"[,1000,15]", "{콜라,1500,20}"})
        @DisplayName("[EXCEPTION] 잘못된 형식 입력시 예외가 발생한다.")
        void invalid_format(String input) {
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> Menu.from(input));
        }
    }

    @Nested
    @DisplayName("구매 가능 테스트")
    class 구매_가능_테스트 {
        private Menu menu;

        @BeforeEach
        void initMenu() {
            menu = Menu.from("[콜라,1500,1]");
        }

        @Test
        @DisplayName("구매_성공_테스트")
        void success() {
            Cash cash = new Cash(10_000);
            Assertions.assertThat(menu.canPurchase(cash))
                    .isTrue();
            Assertions.assertThatNoException()
                    .isThrownBy(() -> menu.purchase(cash));
        }

        @Test
        @DisplayName("품절 상품은 구매할 수 없습니다.")
        void soldOut() {
            Cash cash = new Cash(20_000);
            menu.purchase(cash);

            Assertions.assertThat(menu.canPurchase(cash))
                    .isFalse();
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> menu.purchase(cash));
        }

        @Test
        @DisplayName("잔액보다 비싼 상품은 구매할 수 없습니다.")
        void 잔액_부족_테스트() {
            Cash cash = new Cash(1_000);
            Assertions.assertThat(menu.canPurchase(cash))
                    .isFalse();
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> menu.purchase(cash));
        }
    }

}