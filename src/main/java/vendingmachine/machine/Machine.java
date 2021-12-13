package vendingmachine.machine;

import vendingmachine.goods.Goods;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    public List<Goods> goods;
    public int holdingAmount;

    public Machine(int holdingAmount) {
        this.holdingAmount = holdingAmount;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public int getHoldingAmount() {
        return this.holdingAmount;
    }
}
