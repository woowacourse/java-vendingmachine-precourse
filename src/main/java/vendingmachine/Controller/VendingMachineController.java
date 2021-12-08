package vendingmachine.Controller;

public class VendingMachineController {
	private int machineMoney;
	public VendingMachineController() {
		set();
	}

	public void set() {
		machineMoney = InputController.setMoney();
	}
}
