package vendingmachine.Controller;

import vendingmachine.Controller.Run.Activate;
import vendingmachine.Controller.Run.Change;
import vendingmachine.Controller.Run.Init;
import vendingmachine.View.OutputView;

public class MachineController {
	public static int userMoney;
	public static Init init;

	public static void operate() {
		init = new Init();

		setUserMoney();
		OutputView.printEmpty();

		Activate activate = new Activate(userMoney);
		userMoney = activate.getUserMoney();

		new Change(init.machineCoins, userMoney);
	}

	public static void setUserMoney() {
		userMoney = InputController.setUserMoney();
	}
}
