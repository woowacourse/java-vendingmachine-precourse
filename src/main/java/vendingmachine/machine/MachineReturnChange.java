package vendingmachine.machine;

public class MachineReturnChange {
    Coin[] coins = Coin.values();
    Machine machine;

    MachineReturnChange(Machine machine) {
        this.machine = machine;
    }

    public int reduceUserMoney(Coin coin, int userMoney) {
        int number = coin.getNumber();

        while (true) {
            if (coin.getCoinAmount() * number < userMoney) {
                coin.minusCoinNumber(number);
                return userMoney - coin.getCoinAmount() * number;
            }
            number--;
        }
    }

    public void makeChanges(int userMoney) {
        for (Coin coin : coins) {
            userMoney -= reduceUserMoney(coin, userMoney);
        }
    }
}
