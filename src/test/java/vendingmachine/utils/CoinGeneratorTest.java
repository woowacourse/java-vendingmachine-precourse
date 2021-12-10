package vendingmachine.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Price;

class CoinGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 40, 100, 500, 1000, 1300, 3000, 5000, 6160, 9210, 69920})
    @DisplayName("만들어진 코인들의 합이 원래 넣었던 값과 같은지 검사하는 테스트")
    void 코인_금액만큼_만들어지는가_정상(int inputMoney) {
        HashMap<Coin, Integer> coinIntegerHashMap = CoinGenerator.makeCoins(new Price(inputMoney));
        int sum = coinIntegerHashMap.keySet()
            .stream()
            .mapToInt(coin -> coin.getAmount() * coinIntegerHashMap.get(coin))
            .sum();
        Assertions.assertThat(sum).isEqualTo(inputMoney);
    }

}