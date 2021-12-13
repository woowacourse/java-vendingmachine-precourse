package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineManagement;

public class VendingMachineController {
	private VendingMachine vendingMachine;
	private VendingMachineManagement management;
	private Administrator administrator;
	private Consumer consumer;

	public VendingMachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
		this.management = new VendingMachineManagement(vendingMachine, this);
	}

	public void start() {
		createAdministrator();
		setCoins();
		showCoins();
		setProducts();

		createConsumer();
		setMoney();
	}

	private void createAdministrator() {
		administrator = new Administrator(vendingMachine);
	}

	private void setCoins() {
		management.noticeInsertMoneyOfChanges();

		String input = administrator.getMoneyOfChanges();
		management.insertMoneyOfChanges(Integer.parseInt(input));
	}

	private void showCoins() {
		management.noticeCountOfCoins();
	}

	private void setProducts() {
		management.noticeInsertProducts();

		String input = administrator.getProducts();
		management.insertProducts(input);
	}

	private void createConsumer() {
		consumer = new Consumer(vendingMachine);
	}

	private void setMoney() {
		management.noticeInsertMoney();

		String input = consumer.getMoney();
		management.insertMoney(input);
	}

	public String selectProduct() {
		return consumer.selectProduct();
	}
}
