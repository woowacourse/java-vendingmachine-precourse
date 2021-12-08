package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

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

    public void setCoinCountRandom(int amount){
        List<Integer> numberList=new ArrayList<Integer>();
        int maxNumber=amount/this.amount;

        for(int i=0;i<maxNumber;++i){
            numberList.add(i);
        }

        int number=pickNumberInList(numberList);
        setCoinCountAs(number);
    }

    public void setCoinCountAs(int number) {
        this.number = number;
    }

    public void useCoin(int number){
        this.number-=number;
    }

    public int maxCoinCount(int amount) {
        int maxCount = amount / this.amount;
        if (maxCount > this.number) maxCount = this.number;
        return maxCount;
    }
}
