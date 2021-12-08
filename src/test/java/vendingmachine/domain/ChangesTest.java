package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangesTest {

    private static final String FALSE_STRING = "금액";
    private static final String FALSE_PRICE_NOT_DIVIDE_BY_TEN = "111";
    private static final String TRUE_PRICE = "200";

    @DisplayName("실패_금액을 String으로 입력한다")
    @Test
    void insertStringToPrice_false(){
        assertThrows(IllegalArgumentException.class,
                () -> new Changes(FALSE_STRING));
    }

    @DisplayName("실패_금액을 10단위로 입력하지 않는다")
    @Test
    void insertPriceNotDivideByTen_false(){
        assertThrows(IllegalArgumentException.class,
                () -> new Changes(FALSE_PRICE_NOT_DIVIDE_BY_TEN));
    }

    @DisplayName("성공_금액 정상 입력")
    @Test
    void insertPrice_true(){
        assertDoesNotThrow(() -> new Changes(TRUE_PRICE));
    }

}