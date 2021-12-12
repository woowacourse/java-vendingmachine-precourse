package vendingmachine.machine;

import vendingmachine.goods.Goods;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    public List<Goods> goods = new ArrayList<>();
    Coin[] coins = Coin.values();

    public int holdingAmount;

    public Machine(int holdingAmount, List<Goods> goods) {
        this.goods = goods;
        this.holdingAmount = holdingAmount;
    }

}
