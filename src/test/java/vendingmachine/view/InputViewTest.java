package vendingmachine.view;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.Product;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void 자연수_검증_테스트_입력값이_자연수인_경우() {
        // given
        String inputString = "1";
        // when, then
        InputView.validateNatural(inputString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "0.1"})
    void 자연수_검증_테스트_입력값이_자연수가_아닌_경우(String inputString) {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> InputView.validateNatural(inputString));
    }

    @Test
    void 십원의_배수_검증_테스트_입력값이_십원의_배수인_경우() {
        // given
        String inputString = "10";
        // when, then
        InputView.validateTensMultiple(inputString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "15"})
    void 십원의_배수_검증_테스트_입력값이_십원의_배수가_아닌_경우(String inputString) {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> InputView.validateTensMultiple(inputString));
    }

    @Test
    void 백원_이상_검증_테스트_입력값이_백원_이상인_경우() {
        // given
        String inputString = "200";
        // when, then
        InputView.validateBiggerThanHundred(inputString);
    }

    @Test
    void 백원_이상_검증_테스트_입력값이_백원_미만인_경우() {
        // given
        String inputString = "1";
        // when, then
        assertThrows(IllegalArgumentException.class, () -> InputView.validateBiggerThanHundred(inputString));
    }

    @Test
    void 초기상품목록_검증_테스트_입력값이_올바른_경우() {
        // given
        String inputString = "[콜라,1500,20];[사이다,1000,10]";
        // when, then
        InputView.validateProductInput(inputString);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "[콜라,a,20];[사이다,1000,10]", "[콜라,-1,20];[사이다,1000,10]"})
    void 초기상품목록_검증_테스트_입력값_형식이_올바르지_않은_경우(String inputString) {
        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> InputView.validateProductInput(inputString));
    }

    @Test
    void 초기상품목록_파싱_테스트() {
        // given
        String inputString = "[콜라,1500,20];[사이다,1000,10]";
        // when
        Set<Product> generatedProducts= InputView.parseProductInput(inputString);
        // then
        assertThat(generatedProducts.size()).isEqualTo(2);
    }

}