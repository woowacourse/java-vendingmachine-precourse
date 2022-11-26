package controller;

import dto.HoldingSumRequestDto;
import service.VendingMachineService;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final VendingMachineService vendingMachineService = new VendingMachineService();

    private void initHolindSum() {
        HoldingSumRequestDto holdingSumRequestDto = inputView.inputHolingSum();
        vendingMachineService.changeHoldingSumToCoins(holdingSumRequestDto);
    }
}
