package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class ShelfTest {
    private Shelf shelf;
    @BeforeEach
    public void beforeEach(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("콜라",1500,10));
        products.add(new Product("사이다",1000,10));
        shelf = new Shelf(products);
    }
    @Test
    @DisplayName("없는 물건 체크")
    public void noExistCheckTest() throws Exception{
        Assertions.assertThatThrownBy(()->shelf.productExist("환타"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}