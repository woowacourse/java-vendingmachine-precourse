package vendingmachine.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {

    @DisplayName("실패_[로 시작하지 않음")
    @Test
    void NotStartWithSquareBracket_false() {
        assertThrows(IllegalArgumentException.class, () ->
                new Beverage("{콜라,1500,20]"));
    }

    @DisplayName("실패_]로 끝나지 않음")
    @Test
    void NotEndWithSquareBracket_false() {
        assertThrows(IllegalArgumentException.class, () ->
                new Beverage("[콜라,1500,20}"));
    }

    @DisplayName("실패_가격이 숫자가 아님")
    @Test
    void PriceNotNumber_false() {
        assertThrows(IllegalArgumentException.class, () ->
                new Beverage("[콜라,a,20]"));
    }

    @DisplayName("실패_가격이 100원 이하")
    @Test
    void PriceUnder100_false() {
        assertThrows(IllegalArgumentException.class, () ->
                new Beverage("[콜라,99,20]"));
    }

    @DisplayName("실패_가격이 10으로 안나눠짐")
    @Test
    void PriceNotDivideBy10_false() {
        assertThrows(IllegalArgumentException.class, () ->
                new Beverage("[콜라,101,20]"));
    }

    @DisplayName("실패_수량이 숫자가 아님")
    @Test
    void CountNotNumber_false() {
        assertThrows(IllegalArgumentException.class, () ->
                new Beverage("[콜라,1000,a}"));
    }

    @DisplayName("실패_수량이 0 초과가 아님")
    @Test
    void CountUnder0_false() {
        assertThrows(IllegalArgumentException.class, () ->
                new Beverage("[콜라,1000,0]"));
    }

    @DisplayName("음료 생성 성공")
    @Test
    void CreateBeverage_true() {
        Beverage beverage = new Beverage("[콜라,1000,1]");
        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(beverage.getProductName()).isEqualTo("콜라");
            soft.assertThat(beverage.getCount()).isEqualTo(1);
            soft.assertThat(beverage.getPrice()).isEqualTo(1000);
        });
    }

    @DisplayName("음료 개수 감소 성공")
    @Test
    void SellBeverage_true() {
        Beverage beverage = new Beverage("[콜라,1000,1]");
        beverage.reduceCount(1);
        assertThat(beverage.getCount()).isEqualTo(0);
    }

    @DisplayName("음료 개수 감소 실패")
    @Test
    void SellBeverage_false() {
        Beverage beverage = new Beverage("[콜라,1000,1]");
        assertThrows(IllegalArgumentException.class, () -> beverage.reduceCount(2));
    }

}