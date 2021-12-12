package vendingmachine.model.change.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {
    private final Coin coinOf500 = Coin.of(500);

    @Test
    @DisplayName("금액을 반환한다.")
    void getAmount() {
        int actual = coinOf500.getAmount();
        int expected = 500;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("다른 금액을 받아, 동전 몇 개로 바꿀 수 있는지 반환한다.")
    void getNumberOfPossibleGeneration() {
        int givenAmount = 3100;
        int actual = coinOf500.getNumberOfPossibleGeneration(givenAmount);
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("500, 100, 50, 10 이외의 숫자로 동전을 생성하려하면 예외를 발생시킨다.")
    void evokeExceptionByWrongCoinAmount() {
        int wrongAmount = 600;
        assertThatIllegalArgumentException().isThrownBy(() -> Coin.of(wrongAmount))
                .withMessage("동전은 500, 100, 50, 10원 밖에 없습니다.");
    }
}
