package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import vendingmachine.domain.enums.Coin;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class ChangesTest {

    private static final String FALSE_STRING = "금액";
    private static final String FALSE_PRICE_NOT_DIVIDE_BY_TEN = "111";
    private static final String TRUE_PRICE = "200";

    @DisplayName("실패_금액을 String으로 입력한다")
    @Test
    void insertStringToPrice_false(){
        assertThrows(IllegalArgumentException.class,
                () -> new Changes(FALSE_STRING));
    }

    @DisplayName("실패_금액을 10단위로 입력하지 않는다")
    @Test
    void insertPriceNotDivideByTen_false(){
        assertThrows(IllegalArgumentException.class,
                () -> new Changes(FALSE_PRICE_NOT_DIVIDE_BY_TEN));
    }

    @DisplayName("성공_금액 정상 입력")
    @Test
    void insertPrice_true(){
        assertDoesNotThrow(() -> new Changes(TRUE_PRICE));
    }

    @DisplayName("성공_무작위 동전 변환")
    @Test
    void createRandomCoin(){
        Changes changes = new Changes(TRUE_PRICE);
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)){
            mock.when(() -> Randoms.pickNumberInList(any()))
                    .thenReturn(Coin.COIN_100.getAmount(), Coin.COIN_50.getAmount(), Coin.COIN_50.getAmount());
            changes.createRandomCoins();
        }

        Map<Coin, Integer> coinMap = changes.getCoinMap();
        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(coinMap.get(Coin.COIN_500).equals(0));
            soft.assertThat(coinMap.get(Coin.COIN_100).equals(1));
            soft.assertThat(coinMap.get(Coin.COIN_50).equals(2));
            soft.assertThat(coinMap.get(Coin.COIN_10).equals(0));
        });
    }

    @DisplayName("성공_무작위 동전시 초과 동전 변환")
    @Test
    void createRandomCoin_continue(){
        Changes changes = new Changes(TRUE_PRICE);
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)){
            mock.when(() -> Randoms.pickNumberInList(any()))
                    .thenReturn(Coin.COIN_100.getAmount(), Coin.COIN_500.getAmount(), Coin.COIN_100.getAmount());
            changes.createRandomCoins();
        }

        Map<Coin, Integer> coinMap = changes.getCoinMap();
        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(coinMap.get(Coin.COIN_500).equals(0));
            soft.assertThat(coinMap.get(Coin.COIN_100).equals(2));
            soft.assertThat(coinMap.get(Coin.COIN_50).equals(0));
            soft.assertThat(coinMap.get(Coin.COIN_10).equals(0));
        });
    }

}