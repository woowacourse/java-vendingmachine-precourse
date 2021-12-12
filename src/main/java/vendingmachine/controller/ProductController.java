package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductService;
import vendingmachine.domain.product.Products;
import vendingmachine.view.InputView;

public class ProductController {
	private Products products;
	private ProductService productService;

	public ProductController() {
		this.productService = new ProductService();
	}

	public void setProducts() {
		try {
			products = new Products();
			List<Product> processedProducts = productService.makeProducts(InputView.getProducts());
			processedProducts.forEach(products::add);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			setProducts();
		}
	}
}
