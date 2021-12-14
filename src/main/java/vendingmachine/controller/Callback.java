package vendingmachine.controller;

import vendingmachine.service.MachineService;
import vendingmachine.view.input.InputView;

public interface Callback {

	void run(InputView inputView, MachineService machineService);

}
