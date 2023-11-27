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

    public void generateCoins(InputView inputView, OutputView outputView) {
        PossessionAmount possessionAmount = initPossessionAmount(inputView, outputView);

        try {
            initCoins(possessionAmount);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            generateCoins(inputView, outputView);
        }
    }

    public void initCoins(PossessionAmount possessionAmount){
        vendingMachineService.generateRandomCoins(possessionAmount.getPossessionAmount());
    }

    public PossessionAmount initPossessionAmount(InputView inputView, OutputView outputView){
        String amount = getPossessionAmount(inputView);
        return createPossessionAmount(amount);
    }



    private String getPossessionAmount(InputView inputView){
        return inputView.getUserInput(() -> {
            OutputView.printMessage(INPUT_POSSESSION_AMOUNT_MESSAGE.getValue());
            return inputView.readConsole();
        });
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
