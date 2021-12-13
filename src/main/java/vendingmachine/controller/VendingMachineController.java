package vendingmachine.controller;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.money.Money;
import vendingmachine.domain.product.Products;
import vendingmachine.dto.ProductDto;
import vendingmachine.service.VendingMachineService;

public class VendingMachineController {
	private final VendingMachineService vendingMachineService = new VendingMachineService();

	public Coins addRetentionCoins(String retentionAmount) {
		Money retentionMoney = Money.of(retentionAmount);
		return vendingMachineService.saveRetentionCoins(retentionMoney);
	}

	public void addProducts(String productList) {
		ProductDto productDto = new ProductDto(productList);
		Products products = productDto.toProducts();
		vendingMachineService.saveProducts(products);
	}

	public void addInsertMoney(String amount) {
		Money insertMoney = Money.of(amount);
		vendingMachineService.saveInsertMoney(insertMoney);
	}

	public Money getInsertMoney() {
		return vendingMachineService.getInsertMoney();
	}

	public boolean isPurchasable() {
		return vendingMachineService.isPurchasable();
	}

	public void purchaseProduct(String productName) {
		vendingMachineService.purchaseProduct(productName);
	}

	public Coins createReturnChange() {
		return vendingMachineService.createReturnChange();
	}
}
