package vendingmachine.Controller;

public class MainController {
    InitController initController = new InitController();

    public void start() {
        initController.initVendingMachine();
    }
}
