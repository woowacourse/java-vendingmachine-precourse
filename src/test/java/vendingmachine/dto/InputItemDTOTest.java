package vendingmachine.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputItemDTOTest {
    private final InputItemDTO inputItemDTO = new InputItemDTO(Arrays.asList("물", " 1000", " 3"));

    @Test
    @DisplayName("상품 속성들의 개수를 반환한다.")
    void getNumberOfProperties() {
        int actual = inputItemDTO.getNumberOfProperties();
        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("상품 이름을 반환한다.")
    void getName() {
        String actual = inputItemDTO.getName();
        String expected = "물";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    @DisplayName("상품 이름을 반환한다.")
    void getPrice() {
        String actual = inputItemDTO.getPrice();
        String expected = "1000";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("상품 이름을 반환한다.")
    void getQuantity() {
        String actual = inputItemDTO.getQuantity();
        String expected = "3";
        assertThat(actual).isEqualTo(expected);
    }
}
