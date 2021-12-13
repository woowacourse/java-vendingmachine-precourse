package vendingmachine.model;

import static vendingmachine.constant.Constants.*;

import java.util.LinkedList;
import java.util.List;

import vendingmachine.validation.ProductValidation;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;

public class ProductList {

	List<Product> productList;

	public ProductList() {
		setProductList();
	}

	private void setProductList() {
		productList = new LinkedList<>();
		String input = InputView.setProductList();
		try {
			setProduct(input.split(PRODUCTS_DELIMETER));
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.illegalArgumentException(illegalArgumentException.getMessage());
			setProductList();
		}
	}

	private void setProduct(String[] products) {
		for (String product :
			products) {
			String[] productStrings = product.split(PRODUCT_DELIMETER);
			ProductValidation.productParsingNumber(productStrings.length);
			productList.add(new Product(productStrings[PRODUCT_NAME_IDX], productStrings[PRODUCT_PRICE_IDX],
				productStrings[PRODUCT_STOCK_IDX]));
		}
	}

	public boolean isRemainProduct() {
		for (Product product :
			productList) {
			if (!product.isRemain())
				return false;
		}
		return true;
	}

	public int getRemainMinPrice() {
		int price = INF.intValue();
		for (Product product :
			productList) {
			if (product.isRemain() && price > product.getPrice()) {
				price = product.getPrice();
			}
		}
		return price;
	}

	public Product findByName(String name) {
		for (Product product:
			 productList) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}
}
