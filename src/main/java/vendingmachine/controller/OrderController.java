package vendingmachine.controller;

import static vendingmachine.view.constant.InputMessage.REQUEST_BUY_PRODUCT;

import vendingmachine.domain.Purchaser;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.OrderService;
import vendingmachine.util.InputUtil;
import vendingmachine.util.Parser;
import vendingmachine.view.output.OutputView;

public class OrderController {
    private static boolean isDone = false;
    private final VendingMachine vendingMachine;
    private final Purchaser purchaser;
    private final OrderService orderService;


    private  OrderController(VendingMachine vendingMachine, Purchaser purchaser){
        this.vendingMachine = vendingMachine;
        this.purchaser = purchaser;
        this.orderService = new OrderService(vendingMachine, purchaser);
    }

    public static void from(VendingMachine vendingMachine, Purchaser purchaser){
        new OrderController(vendingMachine,purchaser);
    }


    private int getOrder(){
        if (!isDone) {
            printoutPurchaserMoney();
            String menu = createPurchaseMenuFromInput();
            orderService.getOrderMenu(menu);
        }
        return orderService.getCurrentMoney();
    }

    private void  printoutPurchaserMoney(){
        int money = orderService.getCurrentMoney();
        OutputView.printPurchaserMoney(money);
        OutputView.println(REQUEST_BUY_PRODUCT);
    }

    private String createPurchaseMenuFromInput() {
        String menuName = InputUtil.readLine();
        return Parser.parseMenuInput(menuName);
    }
}
