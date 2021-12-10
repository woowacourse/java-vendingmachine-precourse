package vendingmachine.controller;

import static vendingmachine.constants.ProgramConstants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.model.VendingMachineModel;
import vendingmachine.resource.CoinStorage;
import vendingmachine.view.VendingMachineInputView;
import vendingmachine.view.VendingMachineOutputView;

public class VendingMachineController {
	private final static VendingMachineController vendingMachineController = new VendingMachineController();
	private final VendingMachineInputView vendingMachineInputView;
	private final VendingMachineOutputView vendingMachineOutputView;
	private final VendingMachineModel vendingMachineModel;

	private VendingMachineController() {
		vendingMachineInputView = VendingMachineInputView.getVendingMachineInputView();
		vendingMachineOutputView = VendingMachineOutputView.getVendingMachineOutputView();
		vendingMachineModel = VendingMachineModel.getVendingMachineModel();
	}

	public static VendingMachineController getVendingMachineController(){
		return vendingMachineController;
	}

	public void run(){
		vendingMachineOutputView.printAmountInputMessage();
		int amount = vendingMachineInputView.getInitialAmount();
		vendingMachineModel.generateCoins(amount);
	}
}
