package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int count = 0;

    Coin(final int amount) {
        this.amount = amount;
    }

    public void resetCount(){
        this.count=0;
    }

    public int getAmount() {
        return this.amount;
    }

    public void increaseCount() {
        this.count++;
    }

    public void printCoinInfo(){
        System.out.println(amount+"원 - "+count+"개");
    }

    public int returnCoin(int userAmount){
        int returnCount=Math.min(userAmount/amount,count);

        decreaseCount(returnCount);
        userAmount-=returnCount*amount;

        if(returnCount>0){
            System.out.println(amount+"원 - "+returnCount+"개");
        }

        return userAmount;
    }

    private void decreaseCount(int count){
        this.count-=count;
    }
}
