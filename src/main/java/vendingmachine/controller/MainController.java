package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.InputService;
import vendingmachine.service.VendingService;
import vendingmachine.view.OutputView;

public class MainController {
	private final InputService inputService= new InputService();
	private final VendingService vendingService= new VendingService();
	private int money;
	
	public void start() {
		setVendingMachine();
		vendingService.printCoins();
		registerProducts();
		insertMoney();
		buyProduct();
		result();
	}
	
	public void setVendingMachine() {
		int amount= inputService.readAmount();
		vendingService.makeVendingMachine(amount);
	}
	
	public void registerProducts(){
		List<Product> input= inputService.readProducts();
		vendingService.addProduct(input);
		OutputView.print_line();
	}
	
	public void insertMoney() {
		money= inputService.readMoney();
		OutputView.print_line();
	}
	
	public void buyProduct() {
		while(money>=vendingService.getMachine().getMinimumPrice()) {
			try{
				String name = inputService.readProductName(money, vendingService.getMachine());
				money = vendingService.buyProduct(money, name);
				OutputView.print_line();
			}catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void result() {
		OutputView.print_money(money);
		OutputView.print_change();
		vendingService.getChange(money);
	}

}
