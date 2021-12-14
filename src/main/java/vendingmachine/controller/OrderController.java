package vendingmachine.controller;

import vendingmachine.service.CoinService;
import vendingmachine.service.MessageService;
import vendingmachine.service.OrderService;

import java.util.LinkedHashMap;

public class OrderController {
    private final OrderService orderService = new OrderService();
    private final MessageService messageService = new MessageService();
    private final CoinService coinService = new CoinService();

    public void start() {
        while (true) {
            if (!orderService.checkEnoughAmount()) {
                break;
            }
            orderService.takeOrder();
        }
        finish();
    }

    private void finish() {
        messageService.printLastAmount();
        LinkedHashMap<Integer, Integer> changeCoinsMap = coinService.getLastChanges();
        messageService.printLastChanges(changeCoinsMap);
    }
}
