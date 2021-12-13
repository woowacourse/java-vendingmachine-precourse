package vendingmachine.machine;

public class MachineReturnChange {
    Coin[] coins = Coin.values();
    Machine machine;

    MachineReturnChange(Machine machine) {
        this.machine = machine;
    }
}
