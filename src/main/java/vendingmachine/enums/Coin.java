package vendingmachine.enums;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }
    public static int getRandomCoin(){
        List<Integer> coins = new ArrayList<>();
        coins.add(COIN_10.amount);
        coins.add(COIN_50.amount);
        coins.add(COIN_100.amount);
        coins.add(COIN_500.amount);
        return Randoms.pickNumberInList(coins);
    }
    public static int getIndex(int coin){
        if(COIN_10.amount == coin)return 3;
        if(COIN_50.amount == coin)return 2;
        if(COIN_100.amount == coin)return 1;
        return 0;
    }

    // 추가 기능 구현
    public static boolean isDivideMinCoin(String input) {
        if (Integer.parseInt(input) % COIN_10.amount == 0) return true;
        return false;
    }
}
