package vendingmachine.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;
import vendingmachine.domain.ProductCandidate;
import vendingmachine.domain.ProductSet;
import vendingmachine.repository.ProductRepository;
import vendingmachine.validation.DistinctValidation;
import vendingmachine.validation.Validator;

public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public String persist(List<ProductCandidate> productCandidates) {
		List<Product> productList = toProductList(productCandidates);
		return productRepository.save(toProductSet(productList));
	}

	private ProductSet toProductSet(List<Product> productList) {
		List<Product> validated = Validator.validate(Product.NAME, productList, new DistinctValidation());
		return new ProductSet(new LinkedHashSet<>(validated));
	}

	private List<Product> toProductList(List<ProductCandidate> productCandidates) {
		return productCandidates.stream().map(ProductCandidate::toProduct).collect(Collectors.toList());
	}
}
