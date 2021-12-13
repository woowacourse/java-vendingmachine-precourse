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

	public PurchaseService(ProductRepository productRepository,
		DepositRepository depositRepository) {
		this.productRepository = productRepository;
		this.depositRepository = depositRepository;
	}

	public String retrieveMoneyStatus() {
		return retrieveMoney().toString();
	}

	public Money retrieveMoney() {
		return depositRepository.get();
	}

	public boolean isAvailable() {
		Money money = depositRepository.get();
		ProductSet productSet = productRepository.get();
		return productSet.isAvailable(money);
	}

	public void purchase(String input) {
		Price price = productRepository.purchase(new Name(input));
		depositRepository.decrease(price);
	}

}
