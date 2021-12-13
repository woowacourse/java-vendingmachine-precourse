package vendingmachine.machine;

public class MachineReturnChange {
    Coin[] coins = Coin.values();
    Machine machine;
    int changes = 0;    // 반환할 잔돈 금액

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
}
