package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static vendingmachine.exception.ErrorCode.INVALID_PRODUCT_REQUEST;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.dto.ProductDTO;

class StockTest {

    @Test
    @DisplayName("현재 재고 정보를 통해 보유하고 있는 상품의 최저 가격을 얻을 수 있다.")
    public void 최저가격_얻기() {
        //given
        Stock stock = getInventory(10, 10, 10);

        //when
        int minGoodsPrice = stock.getMinGoodsPrice();

        //then
        assertThat(minGoodsPrice).isEqualTo(900);
    }

    @Test
    @DisplayName("재고가 한 개라도 없는 경우에는 true를 반환한다.")
    public void 재고_여부_확인() {
        //given
        Stock stock = getInventory(0, 0, 0);

        //when
        boolean runOutOfStock = stock.isRunOutOfStock();

        //then
        assertThat(runOutOfStock).isTrue();
    }

    @Test
    @DisplayName("재고가 있는 제품인 경우, 재고를 1 줄인다")
    public void 재고_1_감소() {
        //given
        Stock stock = getInventory(1, 2, 3);

        //when
        int purchased = stock.decreaseStock("콜라");

        //then
        assertThat(purchased).isEqualTo(1000);
    }

    @Test
    @DisplayName("재고가 없는 제품을 구매하고자하는 경우, 예외를 발생한다.")
    public void 재고_없는_경우_예외발생() {
        //given
        Stock stock = getInventory(0, 1, 2);

        //when&&then
        assertThatThrownBy(() -> stock.decreaseStock("콜라"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PRODUCT_REQUEST.getMessage());
    }

    @Test
    @DisplayName("api 테스트")
    public void test() {
//        int i = Randoms.pickNumberInList(List.of(500, 100, 50, 10));
//        System.out.println(i);
    }


    private Stock getInventory(int colaAmount, int pepsiAmount, int tamsAmount) {
        List<ProductDTO> infos = Arrays.asList(
                new ProductDTO("콜라", 1000, colaAmount),
                new ProductDTO("펩시", 900, pepsiAmount),
                new ProductDTO("탐스제로", 1200, tamsAmount)
        );
        return Stock.create(infos);
    }
}