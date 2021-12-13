package vendingmachine.controller;

import vendingmachine.service.ProductService;
import vendingmachine.view.InputViews;

import static vendingmachine.view.InputViews.inputProductList;

public class ProductController {
    private static ProductService productService;

    public static void initProductList() {
        productService = new ProductService();
        productService.getProductList();
    }
}
