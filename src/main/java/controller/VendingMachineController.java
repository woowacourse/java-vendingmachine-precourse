package controller;

import domain.CoinCountGenerator;
import domain.PossesionAmount;
import domain.VendingMachine;
import dto.VendingMachineStatusDto;
import service.PossessionAmountService;
import service.VendingMachineService;
import view.InputView;
import view.OutputView;

import java.util.List;

import static util.message.InputMessage.INPUT_POSSESSION_AMOUNT_MESSAGE;
import static util.message.InputMessage.INPUT_PRODUCT_DETAIL;
import static util.message.OutputMessage.VENDING_MACHINE_STATUS;

public class VendingMachineController {
    private final InputView inputView;
    private final PossessionAmountService possesionAmountService;
    private final VendingMachineService vendingMachineService;

    private final OutputView outputView;

    public VendingMachineController(){
        inputView = new InputView();
        possesionAmountService = new PossessionAmountService();
        VendingMachine vendingMachine = new VendingMachine();
        CoinCountGenerator coinCountGenerator = new CoinCountGenerator();
        vendingMachineService = new VendingMachineService(vendingMachine, coinCountGenerator);
        outputView = new OutputView();
    }

    public void start(){
        String amount = getPossessionAmount();
        PossesionAmount possessionAmount = createPossessionAmount(amount);
        List<VendingMachineStatusDto> statusList = vendingMachineService.generateRandomCoins(possessionAmount.getAmount());
        outputView.printVendingMachineStatus(statusList);
        String productInfo = getProductInfo();
    }

    private String getPossessionAmount(){
        return inputView.getUserInput(() -> {
            OutputView.printMessage(INPUT_POSSESSION_AMOUNT_MESSAGE.getValue());
            return inputView.readConsole();
        });
    }

    private PossesionAmount createPossessionAmount(String possessionAmount){
        return possesionAmountService.createPossessionAmount(possessionAmount);
    }

    private String getProductInfo(){
        return inputView.getUserInput(() -> {
            OutputView.printMessage(INPUT_PRODUCT_DETAIL.getValue());
            return inputView.readConsole();
        });
    }
}
