package vendingmachine.Model;

public class User {
    private int inputMoney;

    public User(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public boolean isBuyable(int price){
        if(inputMoney>=price){
            return true;
        }
        return false;
    }
}
