package vendingmachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachine vendingMachine = new VendingMachine();

        while(vendingMachine.canBuyAnything()){
            vendingMachine.buy(InputReceiver.getProductName(vendingMachine));
        }

        VendingMachinePrinter.printChanges(vendingMachine.calculateChanges());
    }

}
