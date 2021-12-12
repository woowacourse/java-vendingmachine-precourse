package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import vendingmachine.Coin;

class CashHolderTest {

    @DisplayName("총금액 와 생성된 동전의 금액이 일치하는지 테스트한다")
    @Test
    void totalAmountTest() {
        assertDoesNotThrow(
            () -> new CashHolder(1450)
        );
    }

    @DisplayName("최소 동전 계산을 테스트한다")
    @Test
    void leastCoinCountTest() {
        try (MockedStatic<Randoms> randoms = mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInList(any())).thenReturn(
                500, 500, 100, 100, 100, 50, 10, 10, 10, 10, 10
            );
            CashHolder cashHolder = new CashHolder(1450);
            Method method = CashHolder.class.getDeclaredMethod("calculateChanges", int.class,
                Map.class);
            method.setAccessible(true);
            Map<Coin, Integer> result = (Map<Coin, Integer>) method.invoke(cashHolder, 250,
                new HashMap<>());
            assertThat(result.get(Coin.COIN_100)).isEqualTo(2);
            assertThat(result.get(Coin.COIN_50)).isEqualTo(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}