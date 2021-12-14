package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Goods;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

public class VendingMachineController {
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();

	private VendingMachine vendingMachine;

	public void run() {
		settingMachine();
		startBuying();
	}

	private void settingMachine() {
		Coins coins = inputView.inputMoneyOfVendingMachine();
		outputView.printVeningMachineCoin(coins);
		List<Goods> inputGoods = inputView.inputProduct();
		int inputMoneyToVendingMachine = inputView.inputMoneyToVendingMachine();
		vendingMachine = new VendingMachine(coins, inputGoods, inputMoneyToVendingMachine);
	}

	private void startBuying() {
		outputView.printMoneyInputToVendingMachine(vendingMachine.getInputMoney());
		while (isSelectToBuy(vendingMachine)) {
			selectToBuy();
		}
		outputView.printLeftoverCoinCount(vendingMachine.getLeftoverCash());
	}

	private void selectToBuy() {
		try {
			vendingMachine.buyProduct(inputView.inputToSelectProduct());
			outputView.printMoneyInputToVendingMachine(vendingMachine.getInputMoney());
		} catch (IllegalArgumentException e) {
			outputView.printMessage(e.getMessage());
			selectToBuy();
		}
	}

	private boolean isSelectToBuy(VendingMachine vendingMachine) {
		if (vendingMachine.getMinPriceOfProducts() > vendingMachine.getInputMoney()) {
			return false;
		}
		if (vendingMachine.getProductsCount() == 0) {
			return false;
		}
		return true;
	}
}
