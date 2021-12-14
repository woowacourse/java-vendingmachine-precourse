package vendingmachine.util.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ProductsInfoValidatorTest {
    @Test
    void 구분자가_세미클론_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ProductsInfoValidator
                        .verifySeparator("[콜라,1500,20],[사이다,1000,10]",() -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void Regex_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ProductsInfoValidator
                        .verifyRegex("[콜라,1000,-3];[사이다,0100,10];[환타,2000,10]",
                                () -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 중복된_상품명_검증() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ProductsInfoValidator
                        .verifyDuplicateProductName("[콜라,1500,10];[콜라,1500,20]",
                                () -> new IllegalArgumentException("[ERROR]")))
                .withMessageStartingWith("[ERROR]");
    }
}
