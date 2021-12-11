package vendingmachine.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.Product;

class ProductRepositoryTest {

	ProductRepository productRepository;
	List<Product> productList;

	@BeforeEach
	void setUp() {
		productRepository = new ProductRepository();
		productList = Arrays.asList(new Product("콜라", 300, 20), new Product("사이다", 1500, 300));
		productRepository.save(productList);
	}

	@Test
	void save() {
		// given
		// when
		// then
		assertThat(productRepository.findByName("콜라")).hasValueSatisfying(p -> {
			assertThat(p.getName()).isEqualTo(productList.get(0).getName());
			assertThat(p.getPrice()).isEqualTo(productList.get(0).getPrice());
			assertThat(p.getQuantity()).isEqualTo(productList.get(0).getQuantity());
		});
	}

	@Test
	void findByName() {
		// given
		// when
		// then
		assertThat(productRepository.findByName("사이다")).hasValueSatisfying(p -> {
			assertThat(p.getName()).isEqualTo(productList.get(1).getName());
			assertThat(p.getPrice()).isEqualTo(productList.get(1).getPrice());
			assertThat(p.getQuantity()).isEqualTo(productList.get(1).getQuantity());
		});
	}

	@Test
	void findAll() {
		// given
		// when
		// then
		assertThat(productRepository.findAll().size()).isEqualTo(productList.size());
	}

	@Test
	void decreaseQuantity() {
		// given
		// when
		IntStream.range(0, productList.get(0).getQuantity())
			.forEach(i -> productRepository.decreaseQuantity(productList.get(0).getName()));
		// then
		assertThat(productRepository.findAll()).hasSize(productList.size() - 1);
	}
}