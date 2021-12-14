package vendingmachine;

import vendingmachine.controller.Controller;
import vendingmachine.domain.Money;
import vendingmachine.view.InputView;

public class Application {
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.runMachine();
	}
}
