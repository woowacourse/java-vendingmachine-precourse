package vendingmachine.service;

import vendingmachine.domain.Change;

public class OrderService {
    private MessageService messageService = new MessageService();
    private InputService inputService = new InputService();
    private ProductService productService = new ProductService();
    private ProductValidationService productValidationService = new ProductValidationService();
    private Change change = Change.getInstance();

    public void takeOrder() {
        messageService.printInputProductName();
        String productName = inputService.inputProductName();
        int price = productService.calculateProduct(productName);
        change.calculateAmount(price);
    }

    public boolean checkEnoughAmount() {
        int remain = change.getAmount();
        messageService.printChangeAmount(remain);
        if (productValidationService.isPossiblePrice(remain) && productValidationService.isExistProduct()) {
            return true;
        }
        return false;
    }
}
