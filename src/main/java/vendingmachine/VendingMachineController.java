package vendingmachine;

import java.util.HashMap;
import java.util.LinkedHashMap;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Goods;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.VendingMachineDto;
import vendingmachine.service.BuyingService;
import vendingmachine.service.InputProcessingService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    void run() {
        InputProcessingService inputProcessingService = new InputProcessingService();
        VendingMachine vendingMachine = inputProcessingService.createVendingMachine(InputView::getUserInput,
                OutputView::printVendingMachineCoinsInputRequest, OutputView::printErrorMessage);
        OutputView.printVendingMachineCoins(vendingMachine.toDto());
        Goods goods = inputProcessingService.createGoods(InputView::getUserInput,
                OutputView::printGoodsInputRequest, OutputView::printErrorMessage);
        inputProcessingService.inputCostumerMoney(vendingMachine, InputView::getUserInput,
                OutputView::printCustomerMoneyInputRequest, OutputView::printErrorMessage);
        BuyingService buyingService = new BuyingService();
        Runnable balancePrinter = () -> OutputView.printBalance(vendingMachine.toDto());
        LinkedHashMap<Coin, Integer> changes = buyingService.buyGoods(vendingMachine, goods, InputView::getUserInput,
                balancePrinter, OutputView::printBuyingGoodsNameRequest, OutputView::printErrorMessage);
        OutputView.printChanges(changes);
    }
}
