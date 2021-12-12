package vendingmachine;

public class Controller {
    Machine machine = new Machine();
    public void start() {
        machine.balance();
        machine.coinsInMachine();
        machine.coinHashMap();
        machine.showMachineCoins();
        machine.goods();
        machine.amountInput();
        machine.purchase();
    }
}
