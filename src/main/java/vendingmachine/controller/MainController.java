package vendingmachine.controller;

import vendingmachine.domain.*;
import vendingmachine.dto.ExchangeCoinsDto;
import vendingmachine.dto.ItemDto;
import vendingmachine.dto.OrderDetailDto;
import vendingmachine.dto.VendingMachineCoinsDto;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        VendingMachineCoins coins = createVendingMachineAmount();
        outputView.printVendingMachineAmount(VendingMachineCoinsDto.from(coins));
        Items items = createItems();
        InsertedAmount insertedAmount = createInsertedAmount();
        outputView.printInputAmount(insertedAmount.provideAmount());
        boolean canBuyMore = true;
        while (canBuyMore) {
            OrderDetailDto orderDetailDto = createOrderDetailDto(insertedAmount.provideAmount(), items);
            insertedAmount.updateAmount(orderDetailDto.getUpdatedInputAmount());
            outputView.printInputAmount(insertedAmount.provideAmount());
            canBuyMore = canBuyMore(items, insertedAmount);
        }
        generateExchangeCoins(coins, insertedAmount);
    }

    private void generateExchangeCoins(VendingMachineCoins coins, InsertedAmount insertedAmount) {
        long amount = insertedAmount.provideAmount();
        EnumMap<Coin, Long> exchangeCoins = coins.generateExchangeCoins(amount);
        ExchangeCoinsDto exchangeCoinsDto = ExchangeCoinsDto.from(exchangeCoins);
        outputView.printExchangeCoins(exchangeCoinsDto);
    }

    private boolean canBuyMore(Items items, InsertedAmount amount) {
        return amount.isEqualOrLargerThan(items.findPurchasableMinimumPrice()) && !items.hasNoQuantity();
    }

    private VendingMachineCoins createVendingMachineAmount() {
        return readUserInput(() -> {
            long amount = inputView.readVendingMachineAmount();
            return VendingMachineCoins.from(amount);
        });
    }

    private Items createItems() {
        return readUserInput(() -> {
            List<Item> items = inputView.readItems().stream()
                    .map(ItemDto::toItem)
                    .collect(Collectors.toList());
            return Items.from(items);
        });
    }

    private InsertedAmount createInsertedAmount() {
        return readUserInput(() -> {
            long amount = inputView.readInputAmount();
            return InsertedAmount.from(amount);
        });
    }

    private OrderDetailDto createOrderDetailDto(long inputAmount, Items items) {
        return readUserInput(() -> {
            String itemName = inputView.readOrderItemName();
            Item orderItem = items.buyItem(itemName, inputAmount);
            long updatedInputAmount = inputAmount - orderItem.providePrice();
            return OrderDetailDto.of(itemName, updatedInputAmount);
        });
    }

    private <T> T readUserInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}