package vendingmachine.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.InputAmount;
import vendingmachine.domain.ProductSeller;
import vendingmachine.utils.ProductParser;

@DisplayName("상품의 동작을 테스트한다")
class ProductTest {

    ProductSeller generateSellerFromInfos(String infos) {
        return new ProductSeller(ProductParser.parse(infos));
    }

    @Test
    void validateBelowPrice() {
        ProductSeller seller = generateSellerFromInfos("[콜라,1500,100]");
        InputAmount inputAmount = new InputAmount(1000);
        assertThrows(
            IllegalArgumentException.class,
            () -> seller.pickProduct("콜라", inputAmount)
        );
    }

    @Test
    void validateNonExistingProduct() {
        ProductSeller seller = generateSellerFromInfos("[사이다,2000,1];[콜라,1000,2]");
        assertThrows(
            IllegalArgumentException.class,
            () -> seller.pickProduct("환타", new InputAmount(5000))
        );
    }

    @Test
    void sellProductTest() {
        ProductSeller seller = generateSellerFromInfos("[사이다,2000,1];[콜라,1000,2]");
        InputAmount inputAmount = new InputAmount(10000);
        seller.pickProduct("사이다", inputAmount);
        assertThat(inputAmount.getAmount()).isEqualTo(8000);
    }

    @Test
    void emptyStockTest() {
        ProductSeller seller = generateSellerFromInfos("[사이다,2000,1];[콜라,1000,2]");
        InputAmount inputAmount = new InputAmount(10000);
        seller.pickProduct("사이다", inputAmount);
        assertThrows(
            IllegalArgumentException.class,
            () -> seller.pickProduct("사이다", inputAmount)
        );
    }
}