package vendingmachine.model.item;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import vendingmachine.dto.InputItemDTO;
import vendingmachine.model.vo.Money;

class ItemTest {
    private final InputItemDTO inputItemDTO = new InputItemDTO(Arrays.asList("물", "1000", "2"));
    private final Item item = new Item(inputItemDTO);

    @ParameterizedTest
    @DisplayName("이름과 가격을 기준으로 동등성을 반환한다.")
    @MethodSource("provideAnotherItemAndExpected")
    void equals(final InputItemDTO anotherInputItemDTO, final boolean expected) {
        Item another = new Item(anotherInputItemDTO);
        boolean actual = item.equals(another);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("이름과 가격을 기준으로 해시코드를 반환한다.")
    @MethodSource("provideAnotherItemAndExpected")
    void hashCode(final InputItemDTO anotherInputItemDTO, final boolean expected) {
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

    @ParameterizedTest
    @DisplayName("사용자 구매 희망 상품 이름을 받아 자신의 이름과 같은지 반환한다.")
    @CsvSource({"물, true", "콜라, false"})
    void hasName(final String userWantedItemName, final boolean expected) {
        boolean actual = item.hasName(userWantedItemName);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("수량이 0인(품절된) 상품을 구매하려고 하면 예외를 발생시킨다.")
    void evokeExceptionByTryingToBuySoldOutItem() {
        Money remainingInputMoney = new Money("3000");
        item.sell(remainingInputMoney);
        item.sell(remainingInputMoney);
        String expectedExceptionMessage = "구입하려는 상품은 품절입니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> item.sell(remainingInputMoney))
                .withMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("남은 투입 금액보다 구매하려는 상품 가격이 비싸면 예외를 발생시킨다.")
    void evokeExceptionByMoreExpensivePrice() {
        Money remainingInputMoney = new Money("900");
        String expectedExceptionMessage = "남은 투입 금액으로 해당 상품을 구매할 수 없습니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> item.sell(remainingInputMoney))
                .withMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("상품 속성들 중 누락이 있으면 예외를 발생시킨다.")
    void evokeExceptionByNotEnoughItemInfo() {
        InputItemDTO NotEnoughInputItemDTO = new InputItemDTO(Arrays.asList("물", "2000"));
        String expectedExceptionMessage = "상품 정보에 누락이 있습니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> new Item(NotEnoughInputItemDTO))
                .withMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("남은 투입 금액을 받아 상품을 판매할 수 있는지 반환한다(상품 가격을 지불할 수 있어도 수량이 0이면 판매할 수 없다.)")
    void cannotSellBecauseOfZeroQuantity() {
        InputItemDTO inputItemDTO = new InputItemDTO(Arrays.asList("물", "800", "1"));
        Item item = new Item(inputItemDTO);
        Money remainingInputMoney = new Money("1800");
        item.sell(remainingInputMoney);
        boolean actual = item.cannotSell(remainingInputMoney);
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("남은 투입 금액을 받아 상품을 판매할 수 있는지 반환한다(상품 가격을 지불할 수 없으면 판매할 수 없다.)")
    void cannotSellBecauseOfNotEnoughRemainingInputMoney() {
        InputItemDTO inputItemDTO = new InputItemDTO(Arrays.asList("물", "800", "1"));
        Item item = new Item(inputItemDTO);
        Money remainingInputMoney = new Money("600");
        boolean actual = item.cannotSell(remainingInputMoney);
        assertThat(actual).isTrue();
    }
}
