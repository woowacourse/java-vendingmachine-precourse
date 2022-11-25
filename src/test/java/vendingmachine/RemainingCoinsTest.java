package vendingmachine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.MessageUtils.MONEY_INPUT_ERROR;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RemainingCoinsTest {
    @BeforeEach
    void setUp() {

    }

    @DisplayName("잘못된 금액 입력시, 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"jjj", " ", ".", "0x1"})
    void 금액입력_예외테스트(String input){
        assertThatThrownBy(() -> new Money(input) )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_INPUT_ERROR.msg());
    }
}