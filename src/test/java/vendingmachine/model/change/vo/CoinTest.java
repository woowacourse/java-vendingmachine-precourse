package vendingmachine.model.change.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {
    @Test
    @DisplayName("금액을 반환한다.")
    void getAmount() {
        int actual = Coin.COIN_500.getAmount();
        int expected = 500;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("다른 금액을 받아, 동전 몇 개로 바꿀 수 있는지 반환한다.")
    void getNumberOfPossibleGeneration() {
        int givenAmount = 3100;
        int actual = Coin.COIN_500.getNumberOfPossibleGeneration(givenAmount);
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }
}
