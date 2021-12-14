package vendingmachine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;

import vendingmachine.config.RepositoryConfig;
import vendingmachine.domain.ChangeSafe;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;
import vendingmachine.domain.Name;
import vendingmachine.domain.Price;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductSet;
import vendingmachine.domain.Quantity;
import vendingmachine.repository.DepositRepository;

/**
 * rollback을 사용하는 경우, Config로부터 얻어낸
 * 객체는 반드시 멤버변수로 초기화되어야한다.
 * 그렇지 않으면 0 으로 초기화된다.
 */
public interface Rollback {

	@BeforeEach
	default void rollback() {
		Map<Coin, Quantity> coinMap = Coin.createEmpty();
		coinMap.put(Coin.COIN_100, new Quantity(4));
		coinMap.put(Coin.COIN_50, new Quantity(1));
		RepositoryConfig.getChangeSafeRepository(new ChangeSafe(coinMap));

		Set<Product> productSet = new HashSet<>();
		productSet.add(new Product(new Name("콜라"), new Price(1500), new Quantity(20)));
		productSet.add(new Product(new Name("사이다"), new Price(1000), new Quantity(10)));
		RepositoryConfig.getProductRepository(new ProductSet(productSet));

		RepositoryConfig.getDepositRepository(new Money(3000));
	}
}
