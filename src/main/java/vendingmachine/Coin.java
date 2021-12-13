package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private int count;

    Coin(final int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public void addCount(){
        this.count++;
    }

    public void minusCount(int times) { 
        while(times > 0){
            times--;
            this.count--;
        }
    }

    public static List<Integer> getCoinList(){
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    public int getAmount(){
        return this.amount;
    }

    public int getCount(){
        return this.count;
    }
    
    public int calculateChangesCoin(User user){
        if(this.amount < user.getUserOwnMoney() && this.count > 0 && user.getUserOwnMoney() >= 10){
            int maximumCoinForChanges = user.getUserOwnMoney() / this.amount;
            if(maximumCoinForChanges > this.count){ // 잔돈이 코인보다 크다면 자판기에 있는 코인을 전부 주고, 반대로 코인이 더 많다면 필요한 잔돈 만큼만 준다.
                maximumCoinForChanges = this.count;
            }
            this.minusCount(maximumCoinForChanges);
            user.minusUserOwnMoney(maximumCoinForChanges * this.amount);
            return maximumCoinForChanges;
        }
        return 0;   // 현재 코인에서는 돌려줄 수 있는 잔돈이 없음으로 0을 리턴
    }
}
