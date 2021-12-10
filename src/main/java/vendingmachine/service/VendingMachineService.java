package vendingmachine.service;

import static vendingmachine.utils.Constant.*;

import vendingmachine.domain.Machine;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductFactory;
import vendingmachine.domain.product.Products;
import vendingmachine.exception.ProductIsNotExistedException;

public class VendingMachineService {

	private final Products products;
	private final Machine machine;
	private final ProductFactory productFactory;

	public VendingMachineService(Products products, Machine machine, ProductFactory productFactory) {
		this.products = products;
		this.machine = machine;
		this.productFactory = productFactory;
	}

	public void buyProduct(String name) {
		Product item = products.getProductList()
			.stream()
			.filter(p -> p.getName().equalsIgnoreCase(name))
			.findFirst()
			.orElseThrow(ProductIsNotExistedException::new);

		item.sellProduct();
		machine.changeAmount(item.getPrice());
	}

	public void initMachine(int amount) {
		machine.insertCoin(amount);
	}

	public void initProducts(String[] productArray) {
		for (int i = 0; i < productArray.length; i++) {
			String[] productData = productArray[i].substring(1, productArray[i].length() - 1).split(COMMA);
			products.insertProduct(
				productFactory.createProduct(
					productData[0],
					Integer.parseInt(productData[1]),
					Integer.parseInt(productData[2])));
		}
	}

	public int sendMachineAmount(){
		return machine.getAmount();
	}

	public boolean checkMachineIsWorking() {
		if (machine.isAmountLessThanProductMinPrice(products.getMinPriceOfProducts()) || !products.isProductExisted()) {
			return true;
		}
		return false;
	}
}
