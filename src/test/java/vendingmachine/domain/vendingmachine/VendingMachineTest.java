package vendingmachine.domain.vendingmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.coin.RandomCoinGenerator;
import vendingmachine.domain.money.Money;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;

class VendingMachineTest {
	Products products = Products.from();

	public void initializeProducts() {
		products.add(Product.of("사이다", "1000", "2"));
		products.add(Product.of("환타", "1250", "10"));
		products.add(Product.of("밀키스", "1700", "10"));
		products.add(Product.of("콜라", "1500", "10"));
	}

	@Test
	public void useVendingMachine() {
		initializeProducts();
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.addRetentionCoinAll(new RandomCoinGenerator().generate(Money.of(490)));
		vendingMachine.addProductAll(products);
		vendingMachine.insert(Money.of(3000));
		Assertions.assertTrue(vendingMachine.isPurchasable());
		vendingMachine.purchase("사이다");
		vendingMachine.purchase("사이다");
		Assertions.assertFalse(vendingMachine.isPurchasable());
		Coins coins = vendingMachine.returnChange();
		System.out.println(coins);
	}
}
