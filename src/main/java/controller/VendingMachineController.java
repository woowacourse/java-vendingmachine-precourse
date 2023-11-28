package controller;

import domain.*;
import dto.CoinsDto;
import dto.VendingMachineStatusDto;
import service.*;
import view.InputView;
import view.OutputView;

import java.util.List;

import static util.message.InputMessage.*;

public class VendingMachineController {
    private final PossessionAmountService possesionAmountService;
    private final VendingMachineService vendingMachineService;

    public VendingMachineController(){
        possesionAmountService = new PossessionAmountService();
        vendingMachineService = new VendingMachineService();
    }

    public void generateCoins() {
        String amount = getPossessionAmount();

        try {
            PossessionAmount possessionAmount = createPossessionAmount(amount);
            initCoins(possessionAmount);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            generateCoins();
        }
    }

    public void initCoins(PossessionAmount possessionAmount){
        vendingMachineService.generateRandomCoins(possessionAmount.getPossessionAmount());
    }

    private String getPossessionAmount(){
        OutputView.printMessage(INPUT_POSSESSION_AMOUNT_MESSAGE.getValue());
        return InputView.readConsole();
    }

    private PossessionAmount createPossessionAmount(String possessionAmount){
        return possesionAmountService.createPossessionAmount(possessionAmount);
    }

    public void printChange() {
        CoinsDto coinsDto = vendingMachineService.getChange();
        OutputView.printChange(coinsDto);
    }

    public void printGeneratedCoins() {
        CoinsDto coinsDto = vendingMachineService.getCurrentCoins();
        OutputView.printVendingMachineHoldingCoins(coinsDto);
    }

}
