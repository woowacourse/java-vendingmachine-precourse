package vendingmachine.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeTest {
    @Test
    @DisplayName("잔돈의 최저 단위로 나눠지지 않을 때 예외처리")
    public void changeValidateTest() throws Exception{
        org.assertj.core.api.Assertions.assertThatThrownBy(()-> new Change(55))
                .isInstanceOf(IllegalArgumentException.class);
    }

}