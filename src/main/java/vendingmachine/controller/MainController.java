package vendingmachine.controller;

import vendingmachine.domain.Item;
import vendingmachine.domain.Items;
import vendingmachine.domain.VendingMachineAmount;
import vendingmachine.dto.ItemDto;
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
