package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int number = 0;
    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public int getAmount(){
        return this.amount;
    }
    public int getNumber(){
        return this.number;
    }
    public void increaseNumber(){
        this.number++;
    }
    public void decreaseNumber(int number){
        this.number-=number;
    }
}
