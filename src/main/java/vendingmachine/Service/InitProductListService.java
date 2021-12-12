package vendingmachine.Service;

import vendingmachine.Constant.DomainConstant;
import vendingmachine.Domain.Product;
import vendingmachine.Domain.VendingMachine;
import vendingmachine.Validation.ProductValidation;

public class InitProductListService {
    ProductValidation validation = new ProductValidation();

    public void setProducts(String input) {
        VendingMachine.clearList();
        for (String p : input.split(";")) {
            VendingMachine.addProduct(parseProductInfo(p));
        }
    }

    public Product parseProductInfo(String productInfo) {
        productInfo = productInfo.replaceAll(" ", "");
        validation.isValidProductFormat(productInfo);

        String[] parsedInfo = productInfo.substring(1, productInfo.length() - 1).split(DomainConstant.SEPARATE_PRODUCTS_INFO);
        validation.isValidProductInfo(parsedInfo);

        return new Product(parsedInfo[0], Integer.parseInt(parsedInfo[1]), Integer.parseInt(parsedInfo[2]));
    }

}
