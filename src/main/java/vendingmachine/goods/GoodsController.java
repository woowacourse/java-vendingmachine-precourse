package vendingmachine.goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsController {
    List<Goods> goodsList = new ArrayList<>();

    GoodsController(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

}
