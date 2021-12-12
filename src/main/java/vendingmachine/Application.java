package vendingmachine;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Count;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		VendingMachineController vendingMachineController = new VendingMachineController(scanner);
		String holdingMoney = vendingMachineController.scanHoldingMoney();
		Map<Coin, Count> coins = Coins.moneyToCoins(holdingMoney);
		vendingMachineController.printHoldingCoins(coins);
		String[] productNameAndPriceAndCnt = vendingMachineController.scanProductNameAndPriceAndCnt();
		Products products = Products.save(productNameAndPriceAndCnt);
		Money inputMoney = new Money(Integer.parseInt(vendingMachineController.scanInputMoney()));
		while (inputMoney.isRemain()) {
			vendingMachineController.printInputMoney(inputMoney.getMoney());
			if (products.isHigherThanMinProductPrice(inputMoney) || products.isSoldOut()) {
				break;
			};
			String buyProductName = vendingMachineController.scanBuyProductName();
			products = products.buy(buyProductName);
			inputMoney = inputMoney.reduce(products.getProductPrice(buyProductName, products));

		}
		Map<Integer, Integer> changes = Coins.returnChange(inputMoney);
		vendingMachineController.printChange(changes);
	}
}
