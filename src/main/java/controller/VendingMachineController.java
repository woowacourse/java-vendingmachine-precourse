package controller;

import domain.*;
import dto.PaymentStatusDto;
import dto.VendingMachineStatusDto;
import service.*;
import view.InputView;
import view.OutputView;

import java.util.List;

import static util.message.InputMessage.*;

public class VendingMachineController {
    private final InputView inputView;
    private final PossessionAmountService possesionAmountService;
    private final VendingMachineService vendingMachineService;

    private final OutputView outputView;
    private final ProductsService productsService;
    private final PaymentService paymentService;
    private final VendingMachine vendingMachine;
    private final CoinCountGenerator coinCountGenerator;
    private final SelectedProductService selectedProductService;

    public VendingMachineController(){
        inputView = new InputView();
        possesionAmountService = new PossessionAmountService();
        vendingMachine = new VendingMachine();
        coinCountGenerator = new CoinCountGenerator();
        vendingMachineService = new VendingMachineService(vendingMachine, coinCountGenerator);
        outputView = new OutputView();
        productsService = new ProductsService();
        paymentService = new PaymentService();
        selectedProductService = new SelectedProductService();
    }

    public void start(){
        String amount = getPossessionAmount();
        PossessionAmount possessionAmount = createPossessionAmount(amount);
        List<VendingMachineStatusDto> statusList = vendingMachineService.generateRandomCoins(possessionAmount.getPossessionAmount());
        outputView.printVendingMachineStatus(statusList);
        String productInfo = getProductInfo();
        Products products = createProducts(productInfo);
        String paymentAmount = getPayment();
        Payment payment = createPayment(paymentAmount);
        PaymentStatusDto paymentStatusDto = paymentService.createPaymentStatusDto(payment);
        outputView.printPaymentStatus(paymentStatusDto);
        String wantedProduct = getSelectedProduct();
        SelectedProduct selectedProduct = createSelectedProduct(wantedProduct, products);
    }

    private SelectedProduct createSelectedProduct(String wantedProduct, final Products products){
        return selectedProductService.createSelectedProduct(wantedProduct, products);
    }

    private String getSelectedProduct(){
        return inputView.getUserInput(() -> {
            OutputView.printMessage(INPUT_SELECTED_PRODUCT.getValue());
            return inputView.readConsole();
        });
    }

    private String getPossessionAmount(){
        return inputView.getUserInput(() -> {
            OutputView.printMessage(INPUT_POSSESSION_AMOUNT_MESSAGE.getValue());
            return inputView.readConsole();
        });
    }

    private PossessionAmount createPossessionAmount(String possessionAmount){
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
