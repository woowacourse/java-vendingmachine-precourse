package vendingmachine.model.service;

import vendingmachine.model.Customer;
import vendingmachine.model.Product;

public class CustomerService {

	ProductService productService = new ProductService();

	public boolean buyProduct(Customer customer, String productName) {
		Product product = productService.getByName(productName);
		int price = product.getPrice();
		int stock = product.getStock();

		if (customer.getMoney() < price) {
			return false;
		}

		customer.setMoney(customer.getMoney() - price);
		product.setStock(stock - 1);
		return true;
	}
}
