package vendingmachine.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Goods;
import vendingmachine.domain.GoodsInformation;
import vendingmachine.domain.VendingMachine;

public class BuyingService {
    public LinkedHashMap<Coin, Integer> buyGoods(VendingMachine vendingMachine, Goods goods, Supplier<String> inputSupplier,
                                                 Runnable balanceMessagePrinter, Runnable inputMessagePrinter,
                                                 Consumer<String> errorMessagePrinter) {
        while (true) {
            try {
                balanceMessagePrinter.run();
                if (isNeedReturnChanges(goods, vendingMachine)) {
                    return vendingMachine.calculateChanges();
                }
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

    public boolean isNeedReturnChanges(Goods goods, VendingMachine vendingMachine) {
        return !goods.hasAnyStock() || goods.getMinPrice() >= vendingMachine.toDto().customerMoney();
    }
}
