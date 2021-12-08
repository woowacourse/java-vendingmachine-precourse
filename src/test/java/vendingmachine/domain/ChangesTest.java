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

class ChangesTest extends DomainTest {

    private static final String FALSE_STRING = "금액";
    private static final String FALSE_PRICE_NOT_DIVIDE_BY_TEN = "111";
    private static final String TRUE_PRICE = "200";

    @DisplayName("실패_금액을 String으로 입력한다")
    @Test
    void insertStringToPrice_false() {
        assertThrows(IllegalArgumentException.class,
                () -> vendingMachine.createChanges(FALSE_STRING));
    }

    @DisplayName("실패_금액을 10단위로 입력하지 않는다")
    @Test
    void insertPriceNotDivideByTen_false() {
        assertThrows(IllegalArgumentException.class,
                () -> vendingMachine.createChanges(FALSE_PRICE_NOT_DIVIDE_BY_TEN));
    }

    @DisplayName("성공_금액 정상 입력")
    @Test
    void insertPrice_true() {
        assertDoesNotThrow(() -> vendingMachine.createChanges(TRUE_PRICE));
    }

    @DisplayName("성공_무작위 동전 변환")
    @Test
    void createRandomCoin() {
        vendingMachine.createChanges(TRUE_PRICE);
        Changes changes = vendingMachine.getChanges();
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
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
    void createRandomCoin_continue() {
        vendingMachine.createChanges(TRUE_PRICE);
        Changes changes = vendingMachine.getChanges();
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
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

    @DisplayName("성공_잔돈변환잔돈부족")
    @Test
    void getCoinChanges_notEnough_true() {
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInList(any()))
                    .thenReturn(Coin.COIN_100.getAmount(), Coin.COIN_500.getAmount(), Coin.COIN_50.getAmount(), Coin.COIN_50.getAmount());
            vendingMachine.createChanges(TRUE_PRICE);
        }

        Changes changes = vendingMachine.getChanges();
        Map<Coin, Integer> changesMap = changes.returnChanges(200);
        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(changesMap.get(Coin.COIN_50).equals(2));
            soft.assertThat(changesMap.get(Coin.COIN_100).equals(1));
        });
    }

    @DisplayName("성공_잔돈변환")
    @Test
    void getCoinChanges_true() {
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInList(any()))
                    .thenReturn(Coin.COIN_100.getAmount(), Coin.COIN_500.getAmount(), Coin.COIN_50.getAmount(), Coin.COIN_50.getAmount());
            vendingMachine.createChanges(TRUE_PRICE);
        }
        Changes changes = vendingMachine.getChanges();
        Map<Coin, Integer> changesMap = changes.returnChanges(100);
        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(changesMap.get(Coin.COIN_100).equals(1));
        });
    }

}