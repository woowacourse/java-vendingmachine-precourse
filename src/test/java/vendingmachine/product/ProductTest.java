package vendingmachine.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.InputAmount;
import vendingmachine.service.ProductService;
import vendingmachine.utils.ProductParser;

@DisplayName("상품의 동작을 테스트한다")
class ProductTest {

    ProductService generateSellerFromInfos(String infos) {
        return new ProductService(ProductParser.parse(infos));
    }

    @Test
    void validateBelowPrice() {
        ProductService service = generateSellerFromInfos("[콜라,1500,100]");
        InputAmount inputAmount = new InputAmount(1000);
        assertThrows(
            IllegalArgumentException.class,
            () -> service.orderProduct("콜라", inputAmount)
        );
    }

    @Test
    void validateNonExistingProduct() {
        ProductService service = generateSellerFromInfos("[사이다,2000,1];[콜라,1000,2]");
        assertThrows(
            IllegalArgumentException.class,
            () -> service.orderProduct("환타", new InputAmount(5000))
        );
    }

    @Test
    void sellProductTest() {
        ProductService service = generateSellerFromInfos("[사이다,2000,1];[콜라,1000,2]");
        InputAmount inputAmount = new InputAmount(10000);
        service.orderProduct("사이다", inputAmount);
        assertThat(inputAmount.getAmount()).isEqualTo(8000);
    }

    @Test
    void emptyStockTest() {
        ProductService service = generateSellerFromInfos("[사이다,2000,1];[콜라,1000,2]");
        InputAmount inputAmount = new InputAmount(10000);
        service.orderProduct("사이다", inputAmount);
        assertThrows(
            IllegalArgumentException.class,
            () -> service.orderProduct("사이다", inputAmount)
        );
    }
}