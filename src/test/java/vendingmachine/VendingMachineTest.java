package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.coins.Coins;
import vendingmachine.domain.products.Products;
import vendingmachine.util.ProductsConvert;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineTest {

    @DisplayName("정상적으로 상품 구매하면 상품 수량 감소 및 소지금이 감소한다.")
    @Test
    void purchaseProductSuccess() {
        Money money = Money.from(5000);
        Products products = ProductsConvert.convert("[콜라,2000,20];[사이다,1000,10];[솔의눈,10000,10]");
        Coins coins = new Coins();
        VendingMachine vendingMachine = VendingMachine.of(Money.from(676), coins, products);
        vendingMachine.purchaseProduct("콜라", money);

        Products compareProducts = ProductsConvert.convert("[콜라,2000,19];[사이다,1000,10];[솔의눈,10000,10]");

        assertThat(money.getMoney()).isEqualTo(3000);
        assertThat(products).usingRecursiveComparison().isEqualTo(compareProducts);
    }

    @DisplayName("구매가능한 상품이 있으면 true 를 반환한다.")
    @Test
    void isSellProductTrue() {
        Products products = ProductsConvert.convert("[콜라,2000,20];[사이다,1000,10];[솔의눈,10000,10]");
        Coins coins = new Coins();
        VendingMachine vendingMachine = VendingMachine.of(Money.from(676), coins, products);

        assertThat(vendingMachine.isSellProduct(Money.from(5000))).isEqualTo(true);
    }

    @DisplayName("구매가능한 상품 수량이 없으면 false 를 반환한다.")
    @Test
    void isSellProductFalseByQuantity() {
        Products products = ProductsConvert.convert("[콜라,2000,0];[사이다,1000,0];[솔의눈,10000,0]");
        Coins coins = new Coins();
        VendingMachine vendingMachine = VendingMachine.of(Money.from(676), coins, products);

        assertThat(vendingMachine.isSellProduct(Money.from(5000))).isEqualTo(false);
    }

    @DisplayName("구매가능한 상품 가격이 없으면 false 를 반환한다.")
    @Test
    void isSellProductFalseByMoney() {
        Products products = ProductsConvert.convert("[콜라,2000,10];[사이다,1000,100];[솔의눈,10000,20]");
        Coins coins = new Coins();
        VendingMachine vendingMachine = VendingMachine.of(Money.from(676), coins, products);

        assertThat(vendingMachine.isSellProduct(Money.from(500))).isEqualTo(false);
    }
}
