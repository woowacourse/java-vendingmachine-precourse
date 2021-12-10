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

    public int setCoinCount(int amount){
        if(this.amount>10){
            return setCoinCountRandom(amount);
        }
        return setCoin10Count(amount);
    }

    private int setCoinCountRandom(int amount){
        List<Integer> numberList=new ArrayList<>();
        int maxNumber=amount/this.amount;
        for(int i=0;i<maxNumber;++i){
            numberList.add(i);
        }

        int number=pickNumberInList(numberList);
        setCoinCountAs(number);

        return getLeftAmount(amount);
    }

    private int setCoin10Count(int amount){
        this.number=amount/10;
    }

    private int getLeftAmount(int amount){
        int leftAmount=amount-this.amount*this.number;
        return leftAmount;
    }

    private void setCoinCountAs(int number) {
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

    public void printCoinInfo(){
        System.out.println(this.amount+"원 - "+this.number+"개");
    }

    public int getAmount(){
        return this.amount;
    }

    public int getNumber(){
        return this.number;
    }
}
