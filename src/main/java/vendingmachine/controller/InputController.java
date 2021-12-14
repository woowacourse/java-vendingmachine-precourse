package vendingmachine.controller;

import vendingmachine.domain.Change;
import vendingmachine.service.MessageService;
import vendingmachine.service.CoinService;
import vendingmachine.service.InputService;
import vendingmachine.service.ProductService;

public class InputController {
    private final MessageService messageService = new MessageService();
    private final InputService inputService = new InputService();
    private final CoinService coinService = new CoinService();
    private final ProductService productService = new ProductService();
    private Change change = Change.getInstance();

    public void init() {
        messageService.printInputHolding();
        int holding = inputService.inputCorrectHolding();
        coinService.makeCoins(holding);

        messageService.printInputProducts();
        String[] productsList = inputService.inputCorrectProducts();
        productService.addProducts(productsList);

        messageService.printInputAmount();
        int amount = inputService.inputCorrectAmount();
        change = new Change(amount);
    }
}
