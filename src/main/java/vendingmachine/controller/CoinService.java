package vendingmachine.controller;

import java.util.HashMap;
import vendingmachine.domain.Coin;
import vendingmachine.utils.CoinGenerator;

public class CoinService {

    private HashMap<Coin, Integer> coins;
    private int remainMoney;

    public void setCoinsByMoney(final Integer holdMoney, CoinGenerator generator) {
        coins = generator.countCoin(holdMoney);
    }

    public void change(){
        //TODO : 잔돈을 가능한 적은 코인으로 교환한다
    }
}
