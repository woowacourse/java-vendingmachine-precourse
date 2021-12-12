package vendingmachine.model.item;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.dto.InputItemDTO;
import vendingmachine.model.vo.Money;

class ItemsTest {
    @Test
    @DisplayName("상품에 중복이 있으면 예외를 발생시킨다.")
    void evokeExceptionByOverlappedItems() {
        InputItemDTO first = new InputItemDTO(Arrays.asList("물", "1000", "2"));
        InputItemDTO second = new InputItemDTO(Arrays.asList("물", "1000", "3"));
        List<InputItemDTO> overlappedInputItemInfos = Arrays.asList(first, second);
        String expectedExceptionMessage = "상품에 중복이 있습니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> new Items(overlappedInputItemInfos))
                .withMessage(expectedExceptionMessage);
    }

    @Test
    @DisplayName("사용자가 구매하려는 상품의 이름이 상품들 중에 없다면, 예외를 발생시킨다.")
    void evokeExceptionByNoFoundItem() {
        InputItemDTO first = new InputItemDTO(Arrays.asList("물", "1000", "2"));
        InputItemDTO second = new InputItemDTO(Arrays.asList("콜라", "1500", "3"));
        List<InputItemDTO> itemInfos = Arrays.asList(first, second);
        Items items = new Items(itemInfos);
        String nameNotForSale = "사이다";
        Money remainingInputMoney = new Money("3000");
        String expectedMessage = "구매하시려는 상품이 상품 목록에 없습니다.";
        assertThatIllegalArgumentException().isThrownBy(() -> items.sell(nameNotForSale, remainingInputMoney))
                .withMessage(expectedMessage);
    }

    @Test
    @DisplayName("남은 투입 금액을 받아, 사용자가 구매할 수 있는 제품이 하나도 없는지 반환한다.")
    void cannotSell() {
        InputItemDTO first = new InputItemDTO(Arrays.asList("물", "1000", "1"));
        InputItemDTO second = new InputItemDTO(Arrays.asList("콜라", "1500", "2"));
        List<InputItemDTO> itemInfos = Arrays.asList(first, second);
        Items items = new Items(itemInfos);
        Money remainingInputMoney = new Money("2000");
        boolean actual = items.canSellSomethingWith(remainingInputMoney);
        assertThat(actual).isTrue();
        items.sell("물", remainingInputMoney);
        actual = items.canSellSomethingWith(remainingInputMoney);
        assertThat(actual).isFalse();
    }
}
