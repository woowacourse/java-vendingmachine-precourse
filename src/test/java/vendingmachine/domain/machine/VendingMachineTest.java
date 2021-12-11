package vendingmachine.domain.machine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.consumer.Consumer;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {
    private final int CONSUMER_BALANCE = 3000;
    private final int MACHINE_BALANCE = 1000;
    private final String ALL_PRODUCT_INFO = "[콜라,1500,20];[사이다,1000,10]";
    private final List<String> productNameList = Arrays.asList("콜라", "사이다");
    private final String COINS = "100,100,100,100,50";

    private Consumer consumer;
    private VendingMachine vendingMachine;

    @BeforeEach
    void init() {
        consumer = Consumer.from(CONSUMER_BALANCE);
        vendingMachine = VendingMachine.of(MACHINE_BALANCE);
    }

    @Test
    void 자판기_초기잔액_설정() {
        assertThat(vendingMachine.isEqualBalance(MACHINE_BALANCE)).isTrue();
    }

    @Test
    void 상품_정보_입력을_구분하여_상품_추가() {
        vendingMachine.splitInfoAndFillProduct(ALL_PRODUCT_INFO);
        assertThat(vendingMachine.hasProduct(productNameList)).isTrue();
    }

    @Test
    void 거스름돈_반환() {
        vendingMachine.splitInfoAndFillProduct("[콜라,1500,20],[사이다,1000,10]");
        fillCoinsAsSelf(COINS);

        assertThat(vendingMachine.returnChangeAmount(consumer)).isEqualTo(1000);
    }

    private void fillCoinsAsSelf(String selfInputCoins) {
        for(String coin : selfInputCoins.split(",")) {
            vendingMachine.fillCoinsBalanceAmount((i) -> Integer.parseInt(coin));
        }
    }
}
