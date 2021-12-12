package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PossessionCoinsTest {

    @DisplayName("투입 금액을 기반으로 반환 가능한 잔돈 만큼 계산하여 반환한다.")
    @Test
    void takeChange_InvestmentMoneyCalculate_ChangesReturn() {
        // given
        List<PossessionCoin> possessionCoinList = new ArrayList<>();
        possessionCoinList.add(new PossessionCoin(Coin.COIN_100, 4));
        possessionCoinList.add(new PossessionCoin(Coin.COIN_50, 1));

        PossessionCoins possessionCoins = new PossessionCoins(possessionCoinList);

        InvestmentMoney investmentMoney = new InvestmentMoney("500");

        // when
        List<Change> changes = possessionCoins.takeChange(investmentMoney);

        // then
        assertThat(changes.size()).isEqualTo(2);
        assertThat(changes.get(0).toString()).isEqualTo("100원 - 4개");
        assertThat(changes.get(1).toString()).isEqualTo("50원 - 1개");
    }
}