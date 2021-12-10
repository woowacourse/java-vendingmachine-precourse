package vendingmachine.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class VendingMachineTest {
    VendingMachine vendingMachine;

    @BeforeEach
    public void setUp() {
        vendingMachine = new VendingMachine();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "qwe", "1413"})
    public void 자판기_투입금액_예외테스트(String input) {
        assertThatThrownBy(() -> new MachineMoney(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자판기_상품등록_테스트() {
        vendingMachine.addMerchandise("[사이다,2000,10];[콜라,1500,20]");
        assertThat(vendingMachine.getAllMerchandiseInfo()).isEqualTo("사이다200010,콜라150020");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "[],[]", "[]", "[asd,d,10]", "[asd,20],[사이다,2000,20][콜라,2000,20]", "[사이다,2000,20];[사이다,2000,20]"})
    public void 자판기_상품등록_예외_테스트(String input) {
        assertThatThrownBy(() -> vendingMachine.addMerchandise(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "qwe"})
    public void 자판기_투입금액_예외_테스트(String input) {
        assertThatThrownBy(() -> vendingMachine.setInputMoney(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 물건_구매_테스트() {
        vendingMachine.addMerchandise("[사이다,2000,20]");
        vendingMachine.setInputMoney("2000");
        vendingMachine.purchase("사이다");
        assertThat(vendingMachine.getAllMerchandiseInfo()).isEqualTo("사이다200019");
    }
}