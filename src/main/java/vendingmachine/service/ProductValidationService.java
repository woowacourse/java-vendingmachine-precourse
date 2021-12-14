package vendingmachine.service;

import static vendingmachine.domain.Message.*;

import vendingmachine.domain.Product;

public class ProductValidationService {
    private final MessageService messageService = new MessageService();
    private ProductService productService = new ProductService();

    public boolean isSingleProductName(String input) throws IllegalArgumentException {
        int count = 0;
        for (Product p : productService.getProductsList()) {
            if (p.isSameName(input)) {
                count += 1;
            }
        }
        if (count == 1) {
            return true;
        }
        throw new IllegalArgumentException(ERROR_NOT_SINGLE_PRODUCT);
    }

    public boolean isValidateProductName(String input) {
        try {
            isSingleProductName(input);
        } catch (IllegalArgumentException e) {
            messageService.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean isPossiblePrice(int remain) {
        if(remain < productService.getMaxPrice()) {

            return false;
        }
        return true;
    }

    public boolean isExistProduct() {
        for (Product p : productService.getProductsList()) {
            if (p.isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
