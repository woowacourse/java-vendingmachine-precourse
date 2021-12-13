package vendingmachine.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.Coin;
import vendingmachine.constant.Symbol;
import vendingmachine.domain.Deposit;
import vendingmachine.domain.Product;
import vendingmachine.repository.DepositRepository;
import vendingmachine.repository.ProductRepository;

class MachineServiceTest {

	private MachineService machineService;
	private DepositRepository depositRepository;
	private ProductRepository productRepository;

	private List<String> productList;

	@BeforeEach
	void setUp() {
		this.depositRepository = new DepositRepository();
		this.productRepository = new ProductRepository();
		ProductService productService = new ProductService(productRepository);
		DepositService depositService = new DepositService(depositRepository);

		this.machineService = new MachineService(depositService, productService);

		this.productList = Arrays.asList("[콜라,300,20]", "[사이다,1500,300]");
		productService.setProducts(productList.get(0) + Symbol.PRODUCT_DELIMITER.getSymbol() + productList.get(1));

		List<Deposit> depositList = Arrays.asList(new Deposit(Coin.COIN_10, 10), new Deposit(Coin.COIN_50, 10),
			new Deposit(Coin.COIN_100, 10), new Deposit(Coin.COIN_500, 10));
		this.depositRepository.save(depositList);
	}

	@Test
	void setProducts() {
		// given
		// when
		// then
		assertThat(productRepository.findByName("콜라")).hasValueSatisfying(p -> {
			assertThat(p.getName()).isEqualTo("콜라");
			assertThat(p.getPrice()).isEqualTo(300);
			assertThat(p.getQuantity()).isEqualTo(20);
		});
	}

	@Test
	void purchaseProduct() {
		// given
		Product target = productRepository.findByName("콜라").orElseThrow(IllegalArgumentException::new);
		machineService.addMoney(String.valueOf(target.getPrice() * target.getQuantity()));
		// when
		IntStream.range(0, target.getQuantity()).forEach(i -> machineService.purchaseProduct(target.getName()));
		// then
		assertThat(productRepository.findAll()).hasSize(productList.size() - 1);
	}

	@Test
	void spitChanges() {
		// given
		machineService.addMoney("10000");
		String previousDeposits = depositRepository.toStringSkipZero();
		String expectedAfterSpit = new DepositRepository().toStringSkipZero();
		// when
		String changes = machineService.spitChanges();
		// then
		assertThat(changes).contains(previousDeposits);
		assertThat(depositRepository.toStringSkipZero()).isEqualTo(expectedAfterSpit);
	}
}