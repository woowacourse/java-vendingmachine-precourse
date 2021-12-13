package vendingmachine.controller;

import vendingmachine.service.ProductService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ProductController {
    OutputView outputView = new OutputView();
    ProductService productService = new ProductService();

    public void generate(){
        outputView.printMachineProduct();
        productService.generate();
    }

}
