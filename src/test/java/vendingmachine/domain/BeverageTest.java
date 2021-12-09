package vendingmachine.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BeverageTest extends DomainTest {

    @DisplayName("실패_;로 구분하지 않음")
    @Test
    void delimiterNotSemiColon_false() {
        assertThrows(IllegalArgumentException.class, () ->
                vendingMachine.createBeverages("[콜라,1500,20],[사이다,1000,20]"));
    }


    @DisplayName("실패_[로 시작하지 않음")
    @Test
    void notStartWithSquareBracket_false() {
        assertThrows(IllegalArgumentException.class, () ->
                vendingMachine.createBeverages("{콜라,1500,20]"));
    }

    @DisplayName("실패_]로 끝나지 않음")
    @Test
    void notEndWithSquareBracket_false() {
        assertThrows(IllegalArgumentException.class, () ->
                vendingMachine.createBeverages("[콜라,1500,20}"));
    }

    @DisplayName("실패_가격이 숫자가 아님")
    @Test
    void priceNotNumber_false() {
        assertThrows(IllegalArgumentException.class, () ->
                vendingMachine.createBeverages("[콜라,a,20]"));
    }

    @DisplayName("실패_가격이 100원 이하")
    @Test
    void priceUnder100_false() {
        assertThrows(IllegalArgumentException.class, () ->
                vendingMachine.createBeverages("[콜라,99,20]"));
    }

    @DisplayName("실패_가격이 10으로 안나눠짐")
    @Test
    void priceNotDivideBy10_false() {
        assertThrows(IllegalArgumentException.class, () ->
                vendingMachine.createBeverages("[콜라,101,20]"));
    }

    @DisplayName("실패_수량이 숫자가 아님")
    @Test
    void amountNotNumber_false() {
        assertThrows(IllegalArgumentException.class, () ->
                vendingMachine.createBeverages("[콜라,1000,a}"));
    }

    @DisplayName("실패_수량이 0 초과가 아님")
    @Test
    void amountUnder0_false() {
        assertThrows(IllegalArgumentException.class, () ->
                vendingMachine.createBeverages("[콜라,1000,0]"));
    }

    @DisplayName("성공_음료 생성")
    @Test
    void createBeverage_true() {
        vendingMachine.createBeverages("[콜라,2000,10]");
        Beverages beverages = vendingMachine.getBeverages();
        Beverage beverage = beverages.getBeverageList().get(0);

        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(beverage.getProductName()).isEqualTo("콜라");
            soft.assertThat(beverage.getAmount()).isEqualTo(10);
            soft.assertThat(beverage.getPrice()).isEqualTo(2000);
        });
    }

    @DisplayName("성공_음료 개수 감소")
    @Test
    void sellBeverage_true() {
        vendingMachine.createBeverages("[콜라,2000,10]");
        Beverages beverages = vendingMachine.getBeverages();
        Beverage beverage = beverages.getBeverageList().get(0);

        beverage.reduceAmount();
        assertThat(beverage.getAmount()).isEqualTo(9);
    }

    @DisplayName("성공_음료수 찾기")
    @Test
    void findBeverage_true() {
        vendingMachine.createBeverages("[콜라,2000,10]");
        Beverages beverages = vendingMachine.getBeverages();
        Beverage beverage = beverages.getBeverageByName("콜라");

        assertThat(beverage.getProductName()).isEqualTo("콜라");
    }

    @DisplayName("실패_음료수 찾기")
    @Test
    void findBeverage_false() {
        vendingMachine.createBeverages("[콜라,2000,10]");
        Beverages beverages = vendingMachine.getBeverages();
        assertThrows(IllegalArgumentException.class, () -> beverages.getBeverageByName("사이다"));
    }

    @DisplayName("성공_음료수 목록에서 제거")
    @Test
    void removeBeverage_true() {
        vendingMachine.createBeverages("[콜라,2000,10]");
        Beverages beverages = vendingMachine.getBeverages();
        beverages.removeBeverage(beverages.getBeverageByName("콜라"));

        assertThat(beverages.getBeverageList().size()).isEqualTo(0);
    }

}