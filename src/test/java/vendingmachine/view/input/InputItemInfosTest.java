package vendingmachine.view.input;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputItemInfosTest {
    private final InputItemInfos inputItemInfos = new InputItemInfos();

    @ParameterizedTest
    @DisplayName("사용자 입력에서, 상품을 나누는 구분자(;)가 잘못된 위치에 있으면 예외를 발생시킨다.")
    @ValueSource(strings = {";[물,3000,2];[콜라,2000,3]", "[물,3000,2];[콜라,2000,3];", "[물,3000,2];;[콜라,2000,3]"})
    void evokeExceptionByWrongItemDelimiterPosition(String wrongInput) {
        String expectedExceptionMessage = "상품을 구분하는 구분자(;) 앞 뒤에 상품 정보가 없습니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> inputItemInfos.generateInputItemDTOs(wrongInput))
                .withMessage(expectedExceptionMessage);
    }

    @ParameterizedTest
    @DisplayName("사용자 입력에서, 상품 속성들을 담는 괄호 [ ]가 둘 중 하나라도 없으면 예외를 발생시킨다.")
    @ValueSource(strings = {"[콜라,3000,2", "콜라,2000,2]", "콜라,2000,2"})
    void evokeExceptionByWrongBracket(String wrongInput) {
        String expectedExceptionMessage = "상품 정보가 잘못되었습니다. Format : [상품명,가격,수량]";
        assertThatIllegalArgumentException().isThrownBy(() -> inputItemInfos.generateInputItemDTOs(wrongInput))
                .withMessage(expectedExceptionMessage);
    }

    @ParameterizedTest
    @DisplayName("사용자 입력에서 , 상품 속성을 나누는 구분자(,)가 잘못된 위치에 있으면 예외를 발생시킨다.")
    @ValueSource(strings = {"[,콜라,2000,2]", "[콜라,2000,2,]", "[콜라,,2000,2]"})
    void evokeExceptionByWrongPropertyDelimiter(String wrongInput) {
        String expectedExceptionMessage = "상품 정보가 잘못되었습니다. Format : [상품명,가격,수량]";
        assertThatIllegalArgumentException().isThrownBy(() -> inputItemInfos.generateInputItemDTOs(wrongInput))
                .withMessage(expectedExceptionMessage);
    }

}