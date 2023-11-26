package domain.wrapper;

import domain.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import provider.TestProvider;
import util.exception.NoResourceException;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.message.ExceptionMessage.BLANK_MESSAGE;
import static util.message.ExceptionMessage.NO_RESOURCE_MESSAGE;

public class SelectedProductNameTest {

    private Products testProducts;

    @BeforeEach
    void init() {
        String testProductInfos = "[콜라,1500,20];[사이다,1000,10]";
        testProducts = TestProvider.createTestProducts(testProductInfos);
    }

    @ParameterizedTest
    @DisplayName("정상적으로 입력했을 경우 예외를 처리하지 않는다.")
    @ValueSource(strings = {"콜라", "사이다"})
    void givenNormalName_thenSuccess(final String name) {
        assertThat(SelectedProductName.create(name, testProducts))
                .isInstanceOf(SelectedProductName.class);

        assertThatCode(() -> SelectedProductName.create(name, testProducts))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("구매할 상품명이 공백일 경우 예외를 처리한다.")
    @EmptySource
    void givenBlankName_thenFail(final String name) {
        assertThatThrownBy(() -> SelectedProductName.create(name, testProducts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue(), "구매할 상품명"));
    }

    @ParameterizedTest
    @DisplayName("구매할 상품명이 자판기에 없는 경우 예외가 발생한다.")
    @ValueSource(strings = {"자두", "케익"})
    void givenBlankPaymentAmount_thenFail(final String productName) {
        assertThatThrownBy(() -> SelectedProductName.create(productName, testProducts))
                .isInstanceOf(NoResourceException.class)
                .hasMessageContaining(String.format(NO_RESOURCE_MESSAGE.getValue(), "해당 상품"));
    }
}
