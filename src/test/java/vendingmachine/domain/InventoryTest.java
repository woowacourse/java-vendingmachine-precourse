package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InventoryTest {

    Inventory inventory = new Inventory();

    @Test
    @DisplayName("Product의 이름이 중복되면 예외 발생")
    void haveDuplicatedProduct() {
        Assertions.assertThatThrownBy(() -> {
            inventory.add(new Product("사이다", 20, 4000));
            inventory.add(new Product("사이다", 10, 2000));
        }).isInstanceOf(IllegalArgumentException.class);
    }

}