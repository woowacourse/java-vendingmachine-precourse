package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HoldingAmountTest {

    @DisplayName("총금액 와 생성된 동전의 금액이 일치하는지 테스트한다")
    @Test
    void totalAmountTest() {
        final int amount = 1450;
        HoldingAmount holdingAmount = new HoldingAmount(amount);
        assertThat(
            Arrays.stream(Coin.values())
                .mapToInt(c -> holdingAmount.getHoldingCoinCount(c) * c.getAmount())
                .sum()
        ).isEqualTo(amount);
    }

    @DisplayName("최소 동전 계산을 테스트한다")
    @Test
    void leastCoinCountTest() {
        Map<Coin, Integer> answer = Arrays.stream(Coin.values())
            .collect(Collectors.toMap(c -> c, c -> 0));
        answer.put(Coin.COIN_100, 2);
        answer.put(Coin.COIN_10, 5);
        assertRandomNumberInListTest(
            () -> {
                HoldingAmount holdingAmount = new HoldingAmount(1450);
                Changes changes = holdingAmount.returnChanges(new InputAmount(250));
                Arrays.stream(Coin.values())
                    .forEach(c -> assertThat(
                        changes.getCoinCount(c)
                    ).isEqualTo(answer.get(c)));
            },
            500, 500, 100, 100, 100, 100, 10, 10, 10, 10, 10
        );
    }
}