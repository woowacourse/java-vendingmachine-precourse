package vendingmachine;

public class Application {
    public static void main(String[] args) {
//        VendingMachine vendingMachine = new VendingMachine();
//        vendingMachine.run();
        Controller controller = new Controller();
        controller.run();
    }
}
