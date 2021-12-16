package vendingmachine;

import vendingmachine.controller.ChangeController;
import vendingmachine.domain.Change;

public class Controller {
    private ChangeController changeController;

    public Controller(){
        changeController = new ChangeController();
    }
    public void run(){
        changeController.insertChange();
        changeController.changeToCoin();
    }
}
