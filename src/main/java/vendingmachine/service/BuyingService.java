package vendingmachine.service;

import java.util.function.Consumer;
import java.util.function.Supplier;
import vendingmachine.domain.Goods;
import vendingmachine.domain.GoodsInformation;
import vendingmachine.domain.VendingMachine;

public class BuyingService {
    public void buyGoods(VendingMachine vendingMachine, Goods goods, Supplier<String> inputSupplier,
                         Runnable balanceMessagePrinter, Runnable inputMessagePrinter,
                         Consumer<String> errorMessagePrinter) {
        while (true) {
            try {
                balanceMessagePrinter.run();
                inputMessagePrinter.run();
                String input = inputSupplier.get();
                GoodsInformation information = goods.checkBuyingGoods(input);
                vendingMachine.buyGoods(information.getPrice());
                information.decreaseStockByOne();
            } catch (IllegalArgumentException e) {
                errorMessagePrinter.accept(e.getMessage());
            }
        }
    }
}
