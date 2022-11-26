package controller;

import dto.HoldingSumRequestDto;
import dto.ProductsRequestDto;
import service.VendingMachineService;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final VendingMachineService vendingMachineService = new VendingMachineService();

    private void initHolindSum() {
        while (true) {
            try {
                HoldingSumRequestDto holdingSumRequestDto = inputView.readHolingSum();
                outputView.printCoins(vendingMachineService.changeHoldingSumToCoins(holdingSumRequestDto));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void saveProductsInfo() {
        while (true) {
            try {
                ProductsRequestDto productsRequestDto = inputView.readProducts();
                vendingMachineService.saveProductsInfo();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
