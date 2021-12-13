package vendingmachine.config;

import vendingmachine.domain.ChangeSafe;
import vendingmachine.domain.Money;
import vendingmachine.domain.ProductSet;
import vendingmachine.repository.ChangeSafeRepository;
import vendingmachine.repository.DepositRepository;
import vendingmachine.repository.ProductRepository;

public class RepositoryConfig {
	public static ChangeSafeRepository getChangeSafeRepository() {
		return new ChangeSafeRepository();
	}

	public static ChangeSafeRepository getChangeSafeRepository(ChangeSafe changeSafe) {
		return new ChangeSafeRepository(changeSafe);
	}

	public static ProductRepository getProductRepository() {
		return new ProductRepository();
	}

	public static ProductRepository getProductRepository(ProductSet productSet) {
		return new ProductRepository(productSet);
	}

	public static DepositRepository getDepositRepository() {
		return new DepositRepository();
	}

	public static DepositRepository getDepositRepository(Money money) {
		return new DepositRepository(money);
	}
}
