package controller;

import domain.*;
import dto.VendingMachineStatusDto;
import service.PaymentService;
import service.PossessionAmountService;
import service.ProductsService;
import service.VendingMachineService;
import view.InputView;
import view.OutputView;

import java.util.List;

import static util.message.InputMessage.*;
import static util.message.OutputMessage.VENDING_MACHINE_STATUS;

public class VendingMachineController {
    private final InputView inputView;
    private final PossessionAmountService possesionAmountService;
    private final VendingMachineService vendingMachineService;

    private final OutputView outputView;
    private final ProductsService productsService;
    private final PaymentService paymentService;

    public VendingMachineController(){
        inputView = new InputView();
        possesionAmountService = new PossessionAmountService();
        VendingMachine vendingMachine = new VendingMachine();
        CoinCountGenerator coinCountGenerator = new CoinCountGenerator();
        vendingMachineService = new VendingMachineService(vendingMachine, coinCountGenerator);
        outputView = new OutputView();
        productsService = new ProductsService();
        paymentService = new PaymentService();
    }

    public void start(){
        String amount = getPossessionAmount();
        PossesionAmount possessionAmount = createPossessionAmount(amount);
        List<VendingMachineStatusDto> statusList = vendingMachineService.generateRandomCoins(possessionAmount.getPossessionAmount());
        outputView.printVendingMachineStatus(statusList);
        String productInfo = getProductInfo();
        Products products = createProducts(productInfo);
        String paymentAmount = getPayment();
        Payment payment = createPayment(paymentAmount);
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

    private Products createProducts(String productInfo){
        return productsService.createProducts(productInfo);
    }

    private String getPayment(){
        return inputView.getUserInput(() -> {
            OutputView.printMessage(INPUT_PAYMENT.getValue());
            return inputView.readConsole();
        });
    }

    private Payment createPayment(String paymentAmount){
        return paymentService.createPayment(paymentAmount);
    }
}
