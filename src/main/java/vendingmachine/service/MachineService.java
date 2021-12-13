package vendingmachine.service;

import static vendingmachine.constant.ExceptionMessage.*;
import static vendingmachine.validator.MoneyValidator.*;

import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.repository.DepositRepository;

public class MachineService {

	private final DepositService depositService;
	private final ProductService productService;
	private int money;

	public MachineService() {
		this(new DepositService(), new ProductService());
	}

	public MachineService(DepositService depositService, ProductService productService) {
		this.depositService = depositService;
		this.productService = productService;
		this.money = 0;
	}

	public void setDepositsRandomized(String input) {
		validateInteger(input);
		int deposit = Integer.parseInt(input);
		depositService.setDepositsRandomized(deposit);
	}

	public String getDeposits() {
		return depositService.getDeposits();
	}

	public void setProducts(String input) {
		productService.setProducts(input);
	}

	public void addMoney(String inputMoney) {
		validateInteger(inputMoney);
		this.money += Integer.parseInt(inputMoney);
	}

	private void decreaseMoney(int amount) {
		if (amount > money)
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY.getMessage());
		this.money -= amount;
	}

	public final int getMoney() {
		return money;
	}

	public List<Product> getAffordableList() {
		return productService.getAffordableList(money);
	}

	public void purchaseProduct(String productName) {
		decreaseMoney(productService.getPrice(productName));
		productService.decreaseProduct(productName);
	}

	public String spitChanges() {
		DepositRepository changes = depositService.spit(money);
		decreaseMoney(changes.getDepositTotal());
		return changes.toStringSkipZero();
	}
}
