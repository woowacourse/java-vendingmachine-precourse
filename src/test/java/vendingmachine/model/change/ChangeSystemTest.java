package vendingmachine.model.change;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static vendingmachine.model.change.vo.Coin.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.model.change.coingenerator.CoinGenerator;
import vendingmachine.model.change.vo.Coin;

class ChangeSystemTest {
    private final Map<Coin, Integer> coins = new LinkedHashMap<>();
    private final CoinGenerator coinGenerator = () -> coins;
    private final int remainingInputMoney = 5360;
    private final ChangeSystem changeSystem = new ChangeSystem(coinGenerator);

    @Test
    @DisplayName("자판기가 보유하고 있는 동전들을 반환한다.")
    void getOwningCoins() {
        coins.put(COIN_500, 8);
        coins.put(COIN_100, 12);
        coins.put(COIN_50, 3);
        coins.put(COIN_10, 2);
        Map<Integer, Integer> actualChanges = changeSystem.getOwningCoins();
        assertThat(actualChanges)
                .containsExactly(entry(500, 8), entry(100, 12), entry(50, 3), entry(10, 2));
    }

    @Test
    @DisplayName("(모두 거슬러 줄 수 있는 경우) 남은 투입 금액을 받아 거슬러 줄 수 있는 만큼, 최소의 동전 개수로 거스름돈을 반환한다.")
    void returnChangesWithEnoughCoins() {
        coins.put(COIN_500, 8);
        coins.put(COIN_100, 12);
        coins.put(COIN_50, 3);
        coins.put(COIN_10, 2);
        Map<Integer, Integer> actualChanges = changeSystem.returnChanges(remainingInputMoney);
        assertThat(actualChanges)
                .containsExactly(entry(500, 8), entry(100, 12), entry(50, 3), entry(10, 1));
    }

    @Test
    @DisplayName("(모두 거슬러 줄 수 없는 경우) 남은 투입 금액을 받아 거슬러 줄 수 있는 만큼, 최소의 동전 개수로 거스름돈을 반환한다.")
    void returnChangesWithNotEnoughCoins() {
        coins.put(COIN_500, 8);
        coins.put(COIN_100, 2);
        coins.put(COIN_50, 3);
        coins.put(COIN_10, 2);
        Map<Integer, Integer> actualChanges = changeSystem.returnChanges(remainingInputMoney);
        assertThat(actualChanges)
                .containsExactly(entry(500, 8), entry(100, 2), entry(50, 3), entry(10, 2));
    }
}
