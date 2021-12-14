package vendingmachine.domain.product;

import vendingmachine.validator.AmountValidator;
import vendingmachine.validator.ProductValidator;

import static vendingmachine.constant.SystemMessage.*;
import static vendingmachine.constant.SystemMessage.COUNT;

public class ProductService {

    public static Products makeProducts(String productForm) {
        Products products = new Products();
        for (String productInformation : productForm.split(PRODUCT_DELIMITER)) {
            ProductValidator.checkProduct(productInformation);
            String[] product = productInformation.replaceAll(UNNECESSARY_SPECIAL_CHARACTER_REGEX, BLANK).split(NAME_PRICE_COUNT_DELIMITER);
            AmountValidator.checkProductPrice(product[PRICE]);
            products.add(new Product(product[NAME], Integer.parseInt(product[PRICE]), Integer.parseInt(product[COUNT])));
        }
        return products;
    }
}
