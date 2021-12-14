package vendingmachine.model.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import vendingmachine.model.domain.Coin;
import vendingmachine.model.domain.Product;
import vendingmachine.model.domain.VendingMachine;
import vendingmachine.validator.Validator;

public class VendingMachineService {
	ProductService productService = new ProductService();

	public void generateProduct(VendingMachine vendingMachine, String products) throws IllegalArgumentException {
		List<Product> productList = productService.createProduct(products);
		List<String> distinctProductList = getDistinctProductNameList(productList);
		Validator.validateProductList(distinctProductList, productList);
		vendingMachine.initProductList(productList);
	}

	public void purchase(VendingMachine vendingMachine, String productName) {
		List<Product> productList = vendingMachine.getProductList();
		Product product = productService.findProductByName(productName, productList);
		removeProduct(productList);
		vendingMachine.calculateInputMoneyAfterPurchase(product.getPrice());
	}

	public Map<Coin, Integer> calculateRemainCoin(int restMoney, Map<Coin, Integer> coinMap) {
		Map<Coin, Integer> returnCoinMap = new LinkedHashMap<>();

		for (Coin coin : coinMap.keySet()) {
			int count = getCount(restMoney, coinMap, coin);

			if (count == 0 || restMoney == 0) {
				continue;
			}
			returnCoinMap.put(coin, count);
			restMoney = coin.calculateRestMoney(restMoney, count);
		}
		return returnCoinMap;
	}

	private int getCount(int restMoney, Map<Coin, Integer> coinMap, Coin coin) {
		int count = coin.getPossibleNumberOfCoin(restMoney);
		if (count >= coinMap.get(coin)) {
			count = coinMap.get(coin);
		}
		return count;
	}

	private void removeProduct(List<Product> productList) {
		List<Product> productListToDelete = productList
			.stream()
			.filter(Product::getProductToDelete)
			.collect(Collectors.toList());

		productListToDelete.forEach(productList::remove);
	}

	private List<String> getDistinctProductNameList(List<Product> productList) {
		return productList
			.stream()
			.map(Product::getName)
			.distinct()
			.collect(Collectors.toList());
	}
}
