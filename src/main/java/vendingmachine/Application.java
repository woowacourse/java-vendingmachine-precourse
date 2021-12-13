package vendingmachine;

import java.util.Map;
import java.util.Scanner;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Count;
import vendingmachine.domain.Money;
import vendingmachine.domain.Products;

public class Application {
	private static VendingMachineController vendingMachineController;
	private static Products products;

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		vendingMachineController = new VendingMachineController(scanner);
		final Money holdingMoney = new Money(vendingMachineController.scanHoldingMoney());
		Map<Coin, Count> coins = Coins.moneyToCoins(holdingMoney.getMoney());
		vendingMachineController.printHoldingCoins(coins);
		String[] productNameAndPriceAndCnt = vendingMachineController.scanProductNameAndPriceAndCnt();
		products = Products.save(productNameAndPriceAndCnt);
		Money inputMoney = new Money(vendingMachineController.scanInputMoney());
		inputMoney = buyProduct(inputMoney);
		Map<Integer, Integer> changes = Coins.returnChange(inputMoney);
		vendingMachineController.printChange(changes);
	}

	public static Money buyProduct(Money inputMoney) {
		while (inputMoney.isRemain()) {
			vendingMachineController.printInputMoney(inputMoney.getMoney());
			if (products.isHigherThanMinProductPrice(inputMoney) || products.isSoldOut()) {
				break;
			}
			String buyProductName = vendingMachineController.scanBuyProductName();
			if (!products.validateInputMoneyHigherThanProductPrice(buyProductName, inputMoney)) {
				products = products.buy(buyProductName, inputMoney);
				inputMoney = inputMoney.reduce(products.getProductPrice(buyProductName, products));
			}
		}
		if (inputMoney.isEqualsZero()) {
			vendingMachineController.printInputMoney(inputMoney.getMoney());
		}
		return inputMoney;
	}
}
