package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import vendingmachine.model.ProductTable;
import vendingmachine.validator.ProductValidator;

public class ProductTest {
    final ProductValidator productValidator = new ProductValidator();
    final String oneLeft = "one";
    final String soldOut = "sold";
    final String notAdded = "no";
    final String cheapest = "cheap";

    ProductTable prepareProductTable() {
        ProductTable pt = new ProductTable();
        pt.addProduct(oneLeft, 1000, 1);
        pt.addProduct(cheapest, ProductValidator.PRICE_MINIMUM, 1);
        pt.addProduct(soldOut, 1000, 0);
        return pt;
    }

    @Test
    void test_wrong_price() {
        ProductTable pt = prepareProductTable();

        assertThrows(IllegalArgumentException.class, () -> {
            pt.addProduct(notAdded, 101, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            pt.addProduct(notAdded + "0", 30, 0);
        });
    }

    @Test
    void test_add_deprecated_name() {
        assertThrows(IllegalArgumentException.class, () -> {
            ProductTable pt = prepareProductTable();
            pt.addProduct(oneLeft, 990, 1);
        });
    }

    @Test
    void test_buy() {
        ProductTable pt = prepareProductTable();
        pt.sellProduct(cheapest);

        assertThrows(IllegalArgumentException.class, () -> {
            pt.sellProduct(soldOut);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            pt.sellProduct(notAdded);
        });
    }

    @Test
    void test_cheapest() {
        ProductTable pt = prepareProductTable();
        assertThat(pt.getCheapestPrice()).isEqualTo(ProductValidator.PRICE_MINIMUM);
    }

    @Test
    void test_isAvailable() {
        ProductTable pt = prepareProductTable();
        pt.sellProduct(oneLeft);
        assertThat(pt.isThereAvailableProduct()).isTrue();

        pt.sellProduct(cheapest);
        assertThat(pt.isThereAvailableProduct()).isFalse();
    }

    @Test
    void test_splitting_product_info_string_not_valid() {
        String[] exceptionCases = new String[] {
            "[name,10, ];[,10,0];[name,10, ];[,,]",     //이름,가격,수량 중 빠진게 있는 경우
            "coke,1500,20;[cider,1000,10]",             //상품하나의 정보가 "["와 "]"로 감싸여져 있지 않은 경우
            "coke,1500,20];[cider,1000,10]",            //상품하나의 정보가 "["와 "]"로 감싸여져 있지 않은 경우
            "[coke,1500,20;[cider,1000,10]",            //상품하나의 정보가 "["와 "]"로 감싸여져 있지 않은 경우
            "[cok,e,15;00,20];[cid;er,1,0,00,10]",      //이름에 "," 이나 ";"가 있는 경우
            "[coke,1500,10],[cider,100,[0]12]",         //가격,수량 중에 "["나 "]"가 포함된 경우
            "[coke,15[0]0,10],[cider,100,[]"            //가격,수량 중에 "["나 "]"가 포함된 경우
        };

        for (String testInput : exceptionCases) {
            assertThrows(IllegalArgumentException.class, () -> {
                productValidator.checkStringOfProductTable(testInput);
            });
        }
    }

    @Test
    void test_splitting_product_info_string__valid() {
        String[] validCases = new String[] {
            "[co[ke,1500,20] ;[ci]der,1000,10]",        //이름에 [나 ]가 있는 경우
            "  [coke ,1500,20];[c oke,1600,2] ",        //"["의 앞이나 "]"의 뒤에 공백이 있어도 허용
            "[콜라,1500,20];[사이다,1000,10]"            //정상적인 경우
        };

        for (String testInput : validCases) {
            System.out.println(productValidator.checkStringOfProductTable(testInput));
        }
    }
}
