package domain;

import domain.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import provider.TestProvider;
import util.exception.DuplicateException;
import util.exception.GlobalException;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.message.ExceptionMessage.BLANK_MESSAGE;
import static util.message.ExceptionMessage.DUPLICATE_MESSAGE;

public class ProductsTest {
    private Products testProducts;

    @BeforeEach
    void init() {
        String testProductInfos = "[콜라,1500,20];[사이다,1000,10]";
        testProducts = TestProvider.createTestProducts(testProductInfos);
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20];[사이다,1000,10]"})
    @DisplayName("정상적인 상품정보를 입력하면, 예외가 발생하지 않는다.")
    void givenNormalProductInfos_thenSuccess(final String testProductInfos) {
        // when & then
        assertThatCode(() -> new Products(testProductInfos))
                .doesNotThrowAnyException();

        assertThat(new Products(testProductInfos))
                .isEqualTo(testProducts);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("상품정보에 null 값이 들어오면 split 시 예외가 발생한다.")
    void givenNullProductInfos_thenFail(final String testProductInfos) {
        assertThatThrownBy(() -> new Products(testProductInfos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue(), "상품정보"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20];[콜라,1500,20]"})
    @DisplayName("상품정보에 중복값이 들어오면 예외가 발생한다.")
    void givenDuplicateProducts_thenFail(final String testProductInfos) {
        assertThatThrownBy(() -> new Products(testProductInfos))
                .isInstanceOf(GlobalException.class)
                .isExactlyInstanceOf(DuplicateException.class)
                .hasMessageContaining(String.format(DUPLICATE_MESSAGE.getValue(), "상품정보"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20];[콜라,1500,10]"})
    @DisplayName("상품명에 중복값이 들어오면 예외가 발생한다.")
    void givenDuplicateProductName_thenFail(final String testProductInfos) {
        assertThatThrownBy(() -> new Products(testProductInfos))
                .isInstanceOf(GlobalException.class)
                .isExactlyInstanceOf(DuplicateException.class)
                .hasMessageContaining(String.format(DUPLICATE_MESSAGE.getValue(), "상품명"));
    }
}
