package controller;

import dto.HoldingSumRequestDto;
import dto.MoneyRequestDto;
import dto.ProductNameRequestDto;
import dto.ProductsRequestDto;
import service.VendingMachineService;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final VendingMachineService vendingMachineService = new VendingMachineService();

    public void control() {
        initHoldingSum();
        saveProductsInfo();
        inputMoney();
        buyProduct();
    }
    private void initHoldingSum() {
        while (true) {
            try {
                HoldingSumRequestDto holdingSumRequestDto = inputView.readHolingSum();
                outputView.printCoins(vendingMachineService.changeHoldingSumToCoins(holdingSumRequestDto));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveProductsInfo() {
        while (true) {
            try {
                ProductsRequestDto productsRequestDto = inputView.readProducts();
                vendingMachineService.saveProductsInfo(productsRequestDto);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputMoney() {
        while (true) {
            try {
                MoneyRequestDto moneyRequestDto = inputView.readMoney();
                vendingMachineService.saveMoney(moneyRequestDto);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void buyProduct() {
        do {
            inputProductName();
        } while (!vendingMachineService.isEnd());
        outputView.printEnd(vendingMachineService.conveyCurrentMoney(), vendingMachineService.calculateChange());
    }

    private void inputProductName() {
        while (true) {
            try {
                ProductNameRequestDto productNameRequestDto = inputView.readProductName(
                    vendingMachineService.conveyCurrentMoney());
                vendingMachineService.purchaseProduct(productNameRequestDto);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
