package vendingmachine.view;

import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RegexTest {
    private static final Pattern MENU_REGEX = Pattern.compile("\\[[가-힣]+,\\d+,\\d+\\]");

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"[콜라,1500,20]","[사이다,1000,10]"})
    @DisplayName("[글자,숫자,숫자] 형식의 입력은 예외가 발생하지 않는다.")
    void 메뉴_형식_성공_테스트(String menu) {
        Assertions.assertThat(MENU_REGEX.matcher(menu).matches())
                .isTrue();
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"[콜라,a,20]","[콜라,1500,b]","[사이다,1000,10,]", "[콜라,20]", "{콜라,1500,20}"})
    @DisplayName("[글자,숫자,숫자] 형식 이외의 입력은 예외가 발생한다.")
    void 메뉴_형식_실패_테스트(String menu) {
        Assertions.assertThat(MENU_REGEX.matcher(menu).matches())
                .isFalse();
    }
}