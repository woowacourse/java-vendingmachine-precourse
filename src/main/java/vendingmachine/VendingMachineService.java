package vendingmachine;

public class VendingMachineService {
    private final VendingMachine vendingMachine = new VendingMachine();
    private final CoinExchangeMachine coinExchangeMachine = new CoinExchangeMachine();

    public void createCurrentBalance(int currentBalance) {
        vendingMachine.depositCurrentBalance(coinExchangeMachine.changeIntoCoins(currentBalance));
    }
}
