package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemNameTest {
    @Nested
    class getName {
        @DisplayName("이름을 잘 반환하는지 확인한다.")
        @Test
        void testGetName() {
            assertEquals(new ItemName("테스트").getName(), "테스트");
        }
    }
}