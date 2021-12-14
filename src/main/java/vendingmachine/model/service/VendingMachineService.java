package vendingmachine.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.model.domain.Product;
import vendingmachine.model.domain.VendingMachine;
import vendingmachine.util.Constant;
import vendingmachine.validator.Validator;

public class VendingMachineService {
	ProductService productService = new ProductService();

	public void generateProduct(VendingMachine vendingMachine, String products) throws IllegalArgumentException {
		List<Product> productList = Arrays.stream(products.split(Constant.PRODUCT_SEPARATOR))
			.map(productInfo -> productService.createProduct(productInfo))
			.collect(Collectors.toList());

		List<String> distinctProductList = getDistinctProductList(productList);

		Validator.validateProductList(distinctProductList, productList);

		vendingMachine.initProductList(productList);
	}

	public void purchase(VendingMachine vendingMachine, String productName) {
		List<Product> productList = vendingMachine.getProductList();

		Product product = productList.stream()
			.filter(it -> it.getName().equals(productName))
			.findFirst()
			.map(Product::purchaseProduct)
			.orElseThrow(() -> new IllegalArgumentException(Validator.ERROR_NOT_EXISTED_PRODUCT));

		removeProduct(productList);
		vendingMachine.calculateInputMoneyAfterPurchase(product.getPrice());
	}

	private void removeProduct(List<Product> productList) {
		List<Product> productListToDelete = productList
			.stream()
			.filter(it -> it.getAmount() == 0)
			.collect(Collectors.toList());

		productListToDelete.forEach(productList::remove);
	}

	private List<String> getDistinctProductList(List<Product> productList) {
		return productList
			.stream()
			.map(Product::getName)
			.distinct()
			.collect(Collectors.toList());
	}


}
