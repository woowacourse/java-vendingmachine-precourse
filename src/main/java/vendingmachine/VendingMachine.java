package vendingmachine;

public class VendingMachine {
    Computer computer = new Computer();
    User user = new User();

    public void Machine() {
        computer.PrintMachineCoin();
        user.InputMachineCoin();
        int sumCoin = user.getCoin();
        MachineCoin machineCoin = new MachineCoin();
        machineCoin.CreateRandomCoin(sumCoin);
    }
}
