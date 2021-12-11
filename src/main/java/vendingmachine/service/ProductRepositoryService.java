package vendingmachine.service;

import static constant.CharacterConstant.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import exception.OrderException;
import vendingmachine.model.Product;
import vendingmachine.repository.ProductRepository;

public class ProductRepositoryService {
	ProductRepository productRepository;

	public ProductRepositoryService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void saveProductRepository(String userInput) {
		List<String> productInfos = Arrays.asList(userInput.split(PRODUCT_DIVIDER));
		for (String productInfo : productInfos) {
			Product product = stringToProduct(unwrapProductInfo(productInfo));
			productRepository.addProduct(product);
		}
	}

	private String unwrapProductInfo(String product) {
		return product.substring(1, product.length() - 1);
	}

	private Product stringToProduct(String product) {
		String[] productInfo = product.split(PRODUCT_DETAIL_DIVIDER);
		String productName = productInfo[0];
		int productPrice = Integer.parseInt(productInfo[1]);
		int productQuantity = Integer.parseInt(productInfo[2]);
		return new Product(productName, productPrice, productQuantity);
	}

	public int getMinProductPrice() {
		List<Integer> productPriceList = productRepository.getProductList()
			.stream()
			.map(Product::getPrice)
			.collect(Collectors.toList());
		return Collections.min(productPriceList);
	}

	public int getProductStock() {
		int productStocks = productRepository.getProductList()
			.stream()
			.mapToInt(Product::getQuantity)
			.sum();
		return productStocks;
	}

	public void updateProductByOrder(String order, int money) {
		Product orderedProduct = productRepository.findByName(order);
		OrderException.isProductLeft(orderedProduct);
		OrderException.isEnoughToOrder(orderedProduct, money);
		orderedProduct.afterOrdered();
	}
}
