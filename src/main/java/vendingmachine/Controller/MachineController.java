package vendingmachine.Controller;

import vendingmachine.Controller.Run.Activate;
import vendingmachine.Controller.Run.Change;
import vendingmachine.Controller.Run.Init;

public class MachineController {

	public MachineController() {
		Init.init();
		new Activate();
		new Change();
	}
}
