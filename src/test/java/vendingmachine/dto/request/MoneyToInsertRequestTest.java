package vendingmachine.dto.request;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyToInsertRequestTest {

    @Test
    void 입력받은_값으로_투입금을_정수로_반환() {
        String input = "1000";
        int expectedResult = 1000;
        Assertions.assertThat(new MoneyToInsertRequest(input).toMoneyToInsert()).isEqualTo(expectedResult);
    }
}
