package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Change;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductList;
import vendingmachine.view.ChangeOutputView;
import vendingmachine.view.ProductInputView;
import vendingmachine.view.ProductOutputView;

public class ProductController {
    private ProductInputView productInputView = new ProductInputView();
    private ProductOutputView productOutputView = new ProductOutputView();
    private ProductList productList = new ProductList();

    public void inputProduct() {
        productInputView.printInputProduct();
        String inputProduct = Console.readLine();
        changeStringToProductList(inputProduct);
        productOutputView.printProductList(productList);
    }

    public void changeStringToProductList(String inputProduct) {
        String[] productList = inputProduct.split(";");
        for (String productInfo : productList) {
            changeStringToProductInformation(productInfo);
        }
    }

    public void changeStringToProductInformation(String productInfo) {
        productInfo = removeBracketInProduct(productInfo);
        String[] productInformation = productInfo.split(",");
        String name = productInformation[0];
        int price = Integer.parseInt(productInformation[1]);
        int amount = Integer.parseInt(productInformation[2]);
        Product product = new Product(name, price, amount);
        productList.addProductList(name, product);
    }

    private String removeBracketInProduct(String productInfo) {
        return productInfo.substring(1, productInfo.length() - 1);
    }
}
