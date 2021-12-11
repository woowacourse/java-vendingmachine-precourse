package vendingmachine.domain.machine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vendingmachine.Coin;
import vendingmachine.domain.consumer.Consumer;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {
    private final int CONSUMER_BALANCE = 3000;
    private final int MACHINE_BALANCE = 1000;
    private final int CONSUMER_BALANCE_FROM_WOOWA = 500;
    private final int MACHINE_BALANCE_FROM_WOOWA = 450;
    private final String ALL_PRODUCT_INFO = "[콜라,1500,20];[사이다,1000,10]";
    private final List<String> productNameList = Arrays.asList("콜라", "사이다");
    private final String COINS = "100,50";

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
    void 최소_개수_동전_반환() {
        consumer = Consumer.from(CONSUMER_BALANCE_FROM_WOOWA);
        vendingMachine = VendingMachine.of(MACHINE_BALANCE_FROM_WOOWA);

        fillCoinsAsSelf();

        vendingMachine.makeChange(consumer.getHowMuchBalance(MACHINE_BALANCE_FROM_WOOWA));

        assertThat(Coin.COIN_100.isChangeCount(4)).isTrue();
        assertThat(Coin.COIN_50.isChangeCount(1)).isTrue();
        assertThat(Coin.COIN_500.isChangeCount(0)).isTrue();
        assertThat(Coin.COIN_10.isChangeCount(0)).isTrue();
    }

    private void fillCoinsAsSelf() {
        vendingMachine.fillCoinsAsBalanceAmount((machineBalance) -> {
            if (100 <= machineBalance)
                return 100;
            return 50;
        });
    }
}
