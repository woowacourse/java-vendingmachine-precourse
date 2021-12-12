package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("상품 정보를 검증한다.")
class ProductTest {

    void validateThrows(String info) {
        assertThrows(
            IllegalArgumentException.class,
            () -> Product.getValidProduct(info)
        );
    }

    ProductSeller generateSellerFromInfos(String infos) {
        return new ProductSeller(Arrays.asList(infos.split(";")));
    }

    @Test
    void validateBrackets() {
        validateThrows("콜락,100,3]");
        validateThrows("[콜락,100,3");
    }

    @Test
    void validatePrice() {
        validateThrows("[사이다,1633,3");
    }

    @Test
    void validateMinPrice() {
        validateThrows("[콜라,98,3]");
    }

    @Test
    void validateStock() {
        validateThrows("[콜라,100,0]");
    }

    @Test
    void validateName() {
        validateThrows("[콜 라,200,5]");
    }

    @Test
    void validateBelowPrice() {
        ProductSeller seller = new ProductSeller(Collections.singletonList("[콜라,1500,100]"));
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