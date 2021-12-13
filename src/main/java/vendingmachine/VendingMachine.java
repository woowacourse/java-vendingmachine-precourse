package vendingmachine;

public class VendingMachine {
    Computer computer = new Computer();
    User user = new User();

    public void Machine() {
        computer.PrintMachineCoin();
        int coinSum = user.InputMachineCoin();
        System.out.println(coinSum);
    }
}
