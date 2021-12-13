package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.ProductCandidate;
import vendingmachine.service.ProductService;
import vendingmachine.service.SplitService;

public class ProductController {

	private final SplitService splitService;
	private final ProductService productService;

	public ProductController(SplitService splitService, ProductService productService) {
		this.splitService = splitService;
		this.productService = productService;
	}

	public void generateProducts(String input) {
		List<ProductCandidate> productCandidates = splitService.splitProducts(input);
		productService.persist(productCandidates);
	}
}
