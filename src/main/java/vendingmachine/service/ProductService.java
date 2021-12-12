package vendingmachine.service;

import vendingmachine.domain.Product;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static vendingmachine.domain.Product.createProductList;
import static vendingmachine.utils.VerificationUtil.validateProductInput;

public class ProductService {

    public List<Product> createProductListWithInput() {
        String inputProductInfo = readLine();

        validateProductInput(inputProductInfo);

        List<Product> productList = createProductList(inputProductInfo);

        return productList;
    }
}
