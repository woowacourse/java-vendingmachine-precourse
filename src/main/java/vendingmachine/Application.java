package vendingmachine;

public class Application {
    public static void startApplication(Controller controller) {

    }

    public static void main(String[] args) {
        View view = new View();
        VendingMachine vendingMachine = new VendingMachine();
        Controller controller = new Controller(vendingMachine, view);

        startApplication(controller);
    }
}
