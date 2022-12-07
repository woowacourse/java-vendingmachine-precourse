package vendingmachine.model;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductsTest {
    private Products products = Products.from(Arrays.asList("[콜라,1000,20]", "[사이다,2000,10]", "[환타,1000,15]"));

    @Test
    void 최저가_찾기() {
        Assertions.assertEquals(1000, products.findMinimumPrice());
    }

}
