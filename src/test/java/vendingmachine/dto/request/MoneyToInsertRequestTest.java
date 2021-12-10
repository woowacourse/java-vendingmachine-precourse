package vendingmachine.dto.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoneyToInsertRequestTest {

    @Test
    void 입력받은_값으로_투입금을_정수로_반환() {
        String input = "1000";
        int expectedResult = 1000;
        assertThat(new MoneyToInsertRequest(input).toMoneyToInsert()).isEqualTo(expectedResult);
    }

    @Test
    void 입력받은_값으로_정수로_변환할_수_없을_경우_예외_발생() {
        String input = "!";
        assertThatThrownBy(() -> new MoneyToInsertRequest(input).toMoneyToInsert()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_값이_음수일_경우_예외_발생() {
        String input = "-1";
        assertThatThrownBy(() -> new MoneyToInsertRequest(input).toMoneyToInsert()).isInstanceOf(IllegalArgumentException.class);
    }
}
