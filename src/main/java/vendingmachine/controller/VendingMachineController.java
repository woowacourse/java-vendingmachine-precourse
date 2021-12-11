package vendingmachine.controller;

import java.util.ArrayList;
import java.util.HashMap;

import vendingmachine.model.service.CoinService;
import vendingmachine.model.Customer;
import vendingmachine.model.service.CustomerService;
import vendingmachine.model.service.ProductService;
import vendingmachine.model.receiver.MoneyReceiver;
import vendingmachine.model.receiver.NameForBuyReceiver;
import vendingmachine.model.receiver.ProductInfoReceiver;
import vendingmachine.view.VendingMachineView;

public class VendingMachineController {

	VendingMachineView vendingMachineView = new VendingMachineView();
	MoneyReceiver moneyReceiver = new MoneyReceiver();
	ProductInfoReceiver productInfoReceiver = new ProductInfoReceiver();
	NameForBuyReceiver nameForBuyReceiver = new NameForBuyReceiver();
	CoinService coinService = new CoinService();
	ProductService productService = new ProductService();
	CustomerService customerService = new CustomerService();

	public void run() {
		inputMoneyForChange();

		showCoinInVendingMachine();

		inputProductInfo();

		Customer customer = inputMoneyForBuy();

		int restMoney = buyProduct(customer);

		giveChange(restMoney);
	}

	private void inputMoneyForChange() {
		vendingMachineView.inputMoneyForChange();

		int change = moneyReceiver.receive();
		coinService.fillCoin(change);

		vendingMachineView.makeEmptyLine();
	}

	private void showCoinInVendingMachine() {
		vendingMachineView.showCoinsInVendingMachine();
		vendingMachineView.makeEmptyLine();
	}

	private void inputProductInfo() {
		vendingMachineView.inputProductInfo();

		ArrayList<String[]> splitInfoArrList = productInfoReceiver.receive();
		productService.addProducts(splitInfoArrList);

		vendingMachineView.makeEmptyLine();
	}

	private Customer inputMoneyForBuy() {
		vendingMachineView.inputMoneyForBuy();

		int moneyForBuy = moneyReceiver.receive();
		vendingMachineView.makeEmptyLine();

		return new Customer(moneyForBuy);
	}

	private int buyProduct(Customer customer) {
		while (customer.getMoney() >= productService.getMinPrice()) {
			vendingMachineView.buyProduct(customer);

			String name = nameForBuyReceiver.receive();
			if (!customerService.buyProduct(customer, name)) {
				vendingMachineView.makeEmptyLine();
				break;
			}
			vendingMachineView.makeEmptyLine();
		}

		return customer.getMoney();
	}

	private void giveChange(int restMoney) {
		HashMap<String, Integer> coinForChange = coinService.calculateCoinForChange(restMoney);

		vendingMachineView.giveChange(restMoney, coinForChange);
	}
}
