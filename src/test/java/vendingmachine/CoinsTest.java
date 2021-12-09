package vendingmachine;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoinsTest {
    @DisplayName("입력값 만큼 동전생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1111:660", "1000:500", "0001:10", "0101:110"}, delimiter = ':')
    void makeCoins(String value, int expected) {
        Coins coins = Coins.of(value);
        assertThat(coins.sum()).isEqualTo(expected);
    }
}
