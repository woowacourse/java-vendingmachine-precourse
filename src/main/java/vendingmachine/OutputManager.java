package vendingmachine;

public class OutputManager {
    public void printVendingMachineStatus(VendingMachine vendingMachine) {
        System.out.println("자판기가 보유한 동전");
        for (Coin coin: Coin.values()) {
            int coinCount = vendingMachine.getCoinCount(coin);
            System.out.println(coin + " - " + coinCount + "개");
        }
        System.out.println();
    }
}
