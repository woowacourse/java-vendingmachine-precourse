package vendingmachine.controller;

import static vendingmachine.utils.SystemMessage.*;
import static vendingmachine.utils.validator.MoneyValidator.*;
import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;


import java.util.HashMap;
import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.SystemMessage;

public class VendingMachineController {
	private final VendingMachine vendingMachine;
	private final Products products = new Products();

	public VendingMachineController() {
		this.vendingMachine = new VendingMachine();
	}

	public void run() {
		vendingMachine.createChanges(inputTotalAmountOfVendingMachine());
		printChangesVendingMachine(vendingMachine);

		List<String> productInfoList = inputInformationOfProducts();
		vendingMachine.createProductList(productInfoList);

		String tempInputMoney = inputMoneyToPutInVendingMachine();
		vendingMachine.createInputMoney(Integer.parseInt(tempInputMoney));

		buyProducts();
		returnRemainChanges();
	}

	public void buyProducts() {
		while (isValidToBuyProduct(vendingMachine)) {
			printCurrentInputMoney(vendingMachine);
			String productName = inputProductNameToBuy(vendingMachine);
			vendingMachine.sellProduct(productName);
		}
	}

	public void returnRemainChanges() {
		printCurrentInputMoney(vendingMachine);
		// printRemainChanges(vendingMachine);

		int currentMoney = vendingMachine.getInputMoney().getCurrentMoney();
		List<Coin> remainCoinList = vendingMachine.getChanges().getRemainChanges();
		HashMap<Coin, Integer> coinMap =  vendingMachine.getChanges().getCoinMap();

		int coinCount = 0;
		for (Coin coin : remainCoinList) {
			if ((coin.getAmount() <= currentMoney) && (coinMap.get(coin) != 0)){
				coinCount++;
				currentMoney -= coin.getAmount();
				coinMap.put(coin, coinMap.get(coin) - 1);
			}
			System.out.println(coin.getAmount() + MONEY_UNIT_WON.getText() + DASH_DELIMITER.getText() + coinCount + AMOUNT_UNIT.getText());
		}

	}

}
