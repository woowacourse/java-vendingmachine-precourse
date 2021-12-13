package vendingmachine.dto.request;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ItemPurchaseRequestTest {

    @Test
    void 빈_문자열이_들어오면_예외_발생() {
        String empty = "";

        assertThatThrownBy(() -> new ItemPurchaseRequest(empty).toItemNameToPurchase()).isInstanceOf(IllegalArgumentException.class);
    }
}
