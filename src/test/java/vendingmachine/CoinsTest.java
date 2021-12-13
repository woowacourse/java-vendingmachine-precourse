package vendingmachine;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinsTest {
    @Test
    void 거스름돈은_동전의_최소_갯수를_반환한다() {
        Coins coins = new Coins(0, 5, 2, 0);
        Map<Coin, Integer> changes = coins.giveChange(450);

        Map<Coin, Integer> expected = new HashMap<Coin, Integer>() {{
            put(Coin.COIN_100, 4);
            put(Coin.COIN_50, 1);
        }};

        assertThat(changes).containsExactlyEntriesOf(expected);
    }
}
