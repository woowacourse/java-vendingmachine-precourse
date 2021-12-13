package vendingmachine.service;

import static constant.CharacterConstant.*;
import static constant.NumberConstant.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import exception.OrderException;
import exception.ProductException;
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
		ProductException.isValidProduct(userInput);
		String[] productInfos = userInput.split(PRODUCT_DIVIDER);
		for (String productInfo : productInfos) {
			Product product = stringToProduct(unwrapProductInfo(productInfo));
			productRepository.addProduct(product);
		}
		ProductException.isDuplicated(productRepository.getProductList());
	}

	private String unwrapProductInfo(String product) {
		return product.substring(PRODUCT_WRAPPER_SIZE, product.length() - PRODUCT_WRAPPER_SIZE);
	}

	private Product stringToProduct(String product) {
		String[] productInfo = product.split(PRODUCT_DETAIL_DIVIDER);
		return new Product(
			productInfo[PRODUCT_NAME_INDEX],
			Integer.parseInt(productInfo[PRODUCT_PRICE_INDEX]),
			Integer.parseInt(productInfo[PRODUCT_QUANTITY_INDEX])
		);
	}

	public int getMinPrice() {
		List<Integer> productPriceList = productRepository.getProductList()
			.stream()
			.map(Product::getPrice)
			.collect(Collectors.toList());
		return Collections.min(productPriceList);
	}

	public int getStock() {
		int productStocks = productRepository.getProductList()
			.stream()
			.mapToInt(Product::getQuantity)
			.sum();
		return productStocks;
	}

	//주문에 따른 Product저장소 업데이트
	public void updateByOrder(String order, int money) {
		Product orderedProduct = productRepository.findByName(order);
		OrderException.isProductLeft(orderedProduct);
		OrderException.isEnoughToOrder(orderedProduct, money);
		orderedProduct.sold();
	}

	public int getPriceByOrder(String order) {
		Product orderedProduct = productRepository.findByName(order);
		return orderedProduct.getPrice();
	}
}
