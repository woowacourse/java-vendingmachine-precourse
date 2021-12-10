package vendingmachine;

public class VendingMachineService {
    private final VendingMachine vendingMachine = new VendingMachine();
    private final CoinExchangeMachine coinExchangeMachine = new CoinExchangeMachine();

    public Coins createCurrentBalance(int currentBalance) {
        return vendingMachine.depositCurrentBalance(coinExchangeMachine.changeIntoCoins(currentBalance));
    }
}
