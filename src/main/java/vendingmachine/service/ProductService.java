package vendingmachine.service;

import static vendingmachine.constant.ExceptionMessage.*;
import static vendingmachine.constant.Symbol.*;
import static vendingmachine.validator.ProductListValidator.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Product;
import vendingmachine.repository.ProductRepository;
import vendingmachine.validator.ProductListValidator;

public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(){
		this(new ProductRepository());
	}

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void setProducts(String input) {
		ProductListValidator.validateBracketAndSemiColon(input);
		List<String> inputList = Arrays.asList(input.split(PRODUCT_DELIMITER.getSymbol(), -1));
		List<Product> productList = inputList.stream().map(ProductService::generateProduct).collect(Collectors.toList());
		productRepository.save(productList);
	}

	private static String trimBrackets(String s) {
		return s.substring(1, s.length() - 1);
	}

	private static Product generateProduct(String s) {
		validateComma(s);
		validateNameLengthAndInteger(s);
		s = trimBrackets(s);

		List<String> infoList = Arrays.asList(s.split(PRODUCT_INFO_DELIMITER.getSymbol(), -1));
		validatePrice(Integer.parseInt(infoList.get(1)));
		validateQuantity(Integer.parseInt(infoList.get(2)));
		return new Product(infoList);
	}

	public List<Product> getAffordableList(int money) {
		return productRepository.findAll()
			.stream()
			.filter(product -> product.getPrice() <= money)
			.collect(Collectors.toList());
	}

	private Product findProduct(String productName){
		if (!productRepository.findByName(productName).isPresent())
			throw new IllegalArgumentException(NO_SUCH_PRODUCT.getMessage());
		return productRepository.findByName(productName).get();
	}

	public int getPrice(String productName) {
		return findProduct(productName).getPrice();
	}

	public void decreaseProduct(String productName) {
		productRepository.decreaseQuantity(productName);
	}
}
