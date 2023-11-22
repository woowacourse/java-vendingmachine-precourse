package vendingmachine.controller;

import vendingmachine.domain.*;
import vendingmachine.dto.ItemDto;
import vendingmachine.dto.OrderDetailDto;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

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
        VendingMachineAmount amount = createVendingMachineAmount();
        //TODO amount 로 동전 무작위 생성

        Items items = createItems();
        long inputAmount = createInputAmount();
        outputView.printInputAmount(inputAmount);
        boolean canBuyMore = true;
        while (canBuyMore) {
            OrderDetailDto orderDetailDto = createOrderDetailDto(inputAmount, items);
            long updatedInputAmount = orderDetailDto.getUpdatedInputAmount();
            outputView.printInputAmount(updatedInputAmount);
            canBuyMore = canBuyMore();
        }
        //TODO 잔돈 반환
    }

    private boolean canBuyMore() {
        //TODO 잔돈 반환 조건 체크
    }

    private VendingMachineAmount createVendingMachineAmount() {
        return readUserInput(() -> {
            long amount = inputView.readVendingMachineAmount();
            return VendingMachineAmount.from(amount);
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

    private long createInputAmount() {
        return readUserInput(inputView::readInputAmount);
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
