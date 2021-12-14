package vendingmachine.service;

import vendingmachine.domain.Money;
import vendingmachine.domain.Name;
import vendingmachine.domain.Price;
import vendingmachine.domain.ProductSet;
import vendingmachine.repository.DepositRepository;
import vendingmachine.repository.ProductRepository;

public class PurchaseService {

	private final ProductRepository productRepository;
	private final DepositRepository depositRepository;

	public PurchaseService(ProductRepository productRepository, DepositRepository depositRepository) {
		this.productRepository = productRepository;
		this.depositRepository = depositRepository;
	}

	public boolean isAvailable(Money money) {
		ProductSet productSet = productRepository.get();
		return productSet.isAvailable(money);
	}

	public Price purchase(String input) {
		return productRepository.purchase(new Name(input));
	}

}
