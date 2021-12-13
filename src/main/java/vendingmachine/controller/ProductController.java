package vendingmachine.controller;

import java.util.ArrayList;

import vendingmachine.repository.Product;
import vendingmachine.repository.Products;
import vendingmachine.service.ProductService;
import vendingmachine.view.OutputView;

public class ProductController {
    OutputView outputView = new OutputView();
    ProductService productService = new ProductService();

    public Products generate(){
        outputView.printMachineProduct();
        return productService.generate();
    }

}
