package vendingmachine.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeTest {
    @Test
    void 거스름돈은_동전의_최소_갯수를_반환한다() {
        HoldingCoins holdingCoins = new HoldingCoins(0, 5, 2, 0);
        Change change = new Change(450, holdingCoins);

        Map<Coin, Integer> expected = new HashMap<Coin, Integer>() {{
            put(Coin.COIN_100, 4);
            put(Coin.COIN_50, 1);
        }};

        assertThat(change.get()).containsExactlyEntriesOf(expected);
    }
}
