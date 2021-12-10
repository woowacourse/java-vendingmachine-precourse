package vendingmachine.domain.machine;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {
    private final int balance = 1000;
    private final String ALL_PRODUCT_INFO = "[콜라,1500,20];[사이다,1000,10]";
    private final List<String> productNameList = Arrays.asList("콜라", "사이다");

    @Test
    void 자판기_초기잔액_설정() {
        VendingMachine machine = VendingMachine.of(balance);
        assertThat(machine.isEqualBalance(balance)).isTrue();
    }

    @Test
    void 상품_정보_입력을_구분하여_상품_추가() {
        VendingMachine machine = VendingMachine.of(balance);
        machine.splitInfoAndFillProduct(ALL_PRODUCT_INFO);
        assertThat(machine.hasProduct(productNameList)).isTrue();
    }
}
