package vendingmachine.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineExceptionTest {
    VendingMachineException vendingMachineException = new VendingMachineException();

    @Test
    @DisplayName("금액에 숫자가 입력되지 않으면 예외가 발생한다")
    void validMoneyInputForm() {
        //given
        String money = "z1234";
        //then
        assertThrows(IllegalArgumentException.class, () -> vendingMachineException.validMoneyInputForm(money)); //when
    }

    @Test
    @DisplayName("자판기 금액은 10 미만이고 10원 단위가 아니면 예외가 발생한다")
    void validMoneyType() {
        //given
        String lowerMoney = "8";
        String notTenUnit = "12";

        //when
        IllegalArgumentException lowerMoneyException = assertThrows(IllegalArgumentException.class,
                () -> vendingMachineException.validMoneyType(lowerMoney));
        IllegalArgumentException notTenUnitException = assertThrows(IllegalArgumentException.class,
                () -> vendingMachineException.validMoneyType(notTenUnit));

        //then
        assertEquals("[ERROR] 자판기 금액은 10원부터 시작입니다.", lowerMoneyException.getMessage());
        assertEquals("[ERROR] 자판기 금액은 10원 단위로 입력해주세요.", notTenUnitException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20","[,1500,20]","[콜라,1500,20];[","[콜라,천오백원,20];"})
    @DisplayName("상품 등록 입력 형식이 주어진 양식에 어긋나면 예외가 발생한다")
    void validGoodsInputForm(String goods) {
        assertThrows(IllegalArgumentException.class, () -> vendingMachineException.validGoodsInputForm(goods)); //when
    }


    @Test
    @DisplayName("상품가격이 100 미만 10원 단위가 아니면 예외가 발생한다")
    void validGoodsMoneyType() {
        //given
        String lowerMoney = "90";
        String notTenUnit = "131";

        //when
        IllegalArgumentException lowerMoneyException = assertThrows(IllegalArgumentException.class,
                () -> vendingMachineException.validGoodsMoneyType(lowerMoney));
        IllegalArgumentException notTenUnitException = assertThrows(IllegalArgumentException.class,
                () -> vendingMachineException.validGoodsMoneyType(notTenUnit));

        //then
        assertEquals("[ERROR] 상품 가격은 100원부터 시작합니다.", lowerMoneyException.getMessage());
        assertEquals("[ERROR] 상품 가격은 10원 단위로 입력하세요.", notTenUnitException.getMessage());
    }
}