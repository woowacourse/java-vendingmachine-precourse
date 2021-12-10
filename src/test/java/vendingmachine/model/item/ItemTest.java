package vendingmachine.model.item;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static vendingmachine.exception.ExceptionMessage.ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import vendingmachine.dto.InputItemDTO;

class ItemTest {
    @ParameterizedTest
    @DisplayName("이름과 가격을 기준으로 동등성을 반환한다.")
    @MethodSource("provideAnotherItemAndExpected")
    void equals(final InputItemDTO anotherInputItemDTO, final boolean expected) {
        InputItemDTO inputItemDTO = new InputItemDTO(Arrays.asList("물", "1000", "2"));
        Item item = new Item(inputItemDTO);
        Item another = new Item(anotherInputItemDTO);
        boolean actual = item.equals(another);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("이름과 가격을 기준으로 해시코드를 반환한다.")
    @MethodSource("provideAnotherItemAndExpected")
    void hashCode(final InputItemDTO anotherInputItemDTO, final boolean expected) {
        InputItemDTO inputItemDTO = new InputItemDTO(Arrays.asList("물", "1000", "2"));
        Item item = new Item(inputItemDTO);
        Item another = new Item(anotherInputItemDTO);
        int itemHashCode = item.hashCode();
        int anotherItemHashCode = another.hashCode();
        assertThat(itemHashCode == anotherItemHashCode).isEqualTo(expected);
    }

    private static Stream<Arguments> provideAnotherItemAndExpected() {
        return Stream.of(
                Arguments.of(new InputItemDTO(Arrays.asList("물", "1000", "2")), true),
                Arguments.of(new InputItemDTO(Arrays.asList("물", "2000", "2")), false),
                Arguments.of(new InputItemDTO(Arrays.asList("콜라", "1000", "2")), false),
                Arguments.of(new InputItemDTO(Arrays.asList("콜라", "2000", "2")), false)
        );
    }

    @Test
    @DisplayName("상품 속성들 중 누락이 있으면 예외를 발생시킨다.")
    void evokeExceptionByNotEnoughItemInfo() {
        InputItemDTO NotEnoughInputItemDTO = new InputItemDTO(Arrays.asList("물", "2000"));
        assertThatIllegalArgumentException().isThrownBy(() -> new Item(NotEnoughInputItemDTO))
                .withMessage(ITEM_INFO_NOT_ENOUGH_EXCEPTION_MESSAGE);
    }
}
