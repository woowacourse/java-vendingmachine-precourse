package vendingmachine;

import org.junit.jupiter.api.BeforeEach;

import vendingmachine.config.RepositoryConfig;
import vendingmachine.domain.ChangeSafe;
import vendingmachine.domain.ProductSet;

public interface Rollback {

	@BeforeEach
	default void rollback() {
		RepositoryConfig.getChangeSafeRepository(new ChangeSafe());
		RepositoryConfig.getProductRepository(new ProductSet());
	}
}
