package vendingmachine.menu;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.exception.VendingMachineException;

class MenuTest {

    @Nested
    @DisplayName("객체 생성 테스트")
    class 객체_생성_테스트{

        @ParameterizedTest(name = "{0}원의 메뉴는 정상적으로 생성된다")
        @DisplayName("[SUCCESS] 정상적으로 메뉴가 생성된다.")
        @ValueSource(ints = {100, 110, 1500, 4300})
        void 성공_테스트(int price){
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Menu.of("콜라", price));
        }

        @ParameterizedTest(name = "{0}원의 메뉴를 입력하면 예외가 발생한다")
        @DisplayName("[EXCEPTION] 메뉴 생성시 예외가 발생한다..")
        @ValueSource(ints = {1, 90, 115, 0, -1140})
        void 실패_테스트(int price){
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> Menu.of("콜라", price))
                    .withMessage(VendingMachineException.INVALID_MONEY_VALUE.getMesssage());
        }
    }
}