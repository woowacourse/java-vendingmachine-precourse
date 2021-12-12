package vendingmachine;

import vendingmachine.coin.Coins;
import vendingmachine.dto.ProductDto;
import vendingmachine.product.Products;

public class VendingMachineController {
	private final VendingMachineService vendingMachineService = new VendingMachineService();

	public Coins showRetentionCoin(String retentionAmount) {
		Money retentionMoney = Money.of(retentionAmount);
		return vendingMachineService.generateCoin(retentionMoney);
	}

	public void addProductList(String productList) {
		ProductDto productDto = new ProductDto(productList);
		Products products = productDto.convertProducts();
		vendingMachineService.addProducts(products);
	}

}
