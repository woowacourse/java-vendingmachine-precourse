package vendingmachine;

import vendingmachine.controller.Machine;

public class Application {
	public static void main(String[] args) {
		Machine machine = new Machine();
		machine.run();
	}
}
