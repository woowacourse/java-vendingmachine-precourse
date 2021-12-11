package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.config.ConstantConfig.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.Machine;
import vendingmachine.domain.product.ProductFactory;
import vendingmachine.domain.product.ProductRepository;
import vendingmachine.domain.product.Products;

class MachineServiceTest {

	private Machine machine;
	private Products products;
	private ProductFactory productFactory;
	private ProductRepository productRepository;
	private MachineService machineService;

	@BeforeEach
	void beforeEach() {
		machine = new Machine();
		products = new Products();
		productFactory = new ProductFactory();
		productRepository = new ProductRepository(products, productFactory);
		machineService = new MachineService(machine, productRepository);
	}

	@Test
	void 고객_투입금액_저장하고가져오기() {
		int customerAmount = 10000;
		machineService.saveCustomerAmount(customerAmount);

		assertEquals(machine.getAmount(), customerAmount);
	}

	@Test
	void 고객_머신_이용가능여부_조사하기_이용가능() {
		productRepository.save("치킨", 10000, 10);
		machine.save(15000);
		assertEquals(machineService.checkIsMachineAvailable(), true);
	}

	@Test
	void 고객_머신_이용가능여부_조사하기_재고없음() {
		productRepository.save("치킨", 100, 0);
		assertEquals(machineService.checkIsMachineAvailable(), false);
	}

	@Test
	void 고객_머신_이용가능여부_조사하기_금액부족() {
		productRepository.save("치킨", 10000, 10);
		machine.save(5000);
		assertEquals(machineService.checkIsMachineAvailable(), false);
	}

}