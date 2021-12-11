package vendingmachine.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.repository.DepositRepository;
import vendingmachine.repository.ProductRepository;

class MachineServiceTest {

	MachineService machineService;
	DepositRepository depositRepository;
	ProductRepository productRepository;

	List<String> productList;

	@BeforeEach
	void setUp() {
		depositRepository = new DepositRepository();
		productRepository = new ProductRepository();
		machineService = new MachineService(depositRepository, productRepository);
		productList = Arrays.asList("[콜라,300,20]", "[사이다,1500,300]");
	}

	@Test
	void setDepositsRandomized() {
		// given
		int deposit = 550;
		// when
		machineService.setDepositsRandomized(deposit);
		// then
		assertThat(depositRepository.getDepositTotal()).isEqualTo(deposit);
	}

	@Test
	void setProducts() {
		// given
		// when
		machineService.setProducts(productList);
		// then
		assertThat(productRepository.findByName("콜라")).hasValueSatisfying(p -> {
			assertThat(p.getName()).isEqualTo("콜라");
			assertThat(p.getPrice()).isEqualTo(300);
			assertThat(p.getQuantity()).isEqualTo(20);
		});
	}
}