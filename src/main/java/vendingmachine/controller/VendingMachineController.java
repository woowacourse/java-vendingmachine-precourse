package vendingmachine.controller;

import java.util.ArrayList;
import java.util.HashMap;

import vendingmachine.model.Coin;
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

		giveChange(restMoney, customer);
	}

	public void inputMoneyForChange() {
		vendingMachineView.inputMoneyForChange();

		int change = moneyReceiver.receive();

		coinService.fillCoin(change);

		vendingMachineView.makeEmptyLine();
	}

	public void showCoinInVendingMachine() {
		vendingMachineView.showCoinsInVendingMachine();

		vendingMachineView.makeEmptyLine();
	}

	public void inputProductInfo() {
		vendingMachineView.inputProductInfo();

		ArrayList<String[]> splitInfoArrList = productInfoReceiver.receive();

		productService.addProducts(splitInfoArrList);

		vendingMachineView.makeEmptyLine();
	}

	public Customer inputMoneyForBuy() {
		vendingMachineView.inputMoneyForBuy();

		int moneyForBuy = moneyReceiver.receive();

		vendingMachineView.makeEmptyLine();

		return new Customer(moneyForBuy);
	}

	public int buyProduct(Customer customer) {
		while (customer.getMoney() >= productService.getMinPrice() && !productService.checkAllStocksEmpty()) {
			vendingMachineView.buyProduct(customer);

			String productName = nameForBuyReceiver.receive();

			if (!customerService.buyProduct(customer, productName)) {
				vendingMachineView.makeEmptyLine();
				break;
			}
			vendingMachineView.makeEmptyLine();
		}

		return customer.getMoney();
	}

	public void giveChange(int restMoney, Customer customer) {
		HashMap<Coin, Integer> coinForChange = coinService.calculateCoinForChange(restMoney, customer);

		vendingMachineView.giveChange(restMoney, coinForChange);
	}
}
