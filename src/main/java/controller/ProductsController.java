package controller;

import domain.Payment;
import domain.Products;
import dto.ProductNameDto;
import service.ProductsService;
import service.UserPaymentService;
import view.InputView;
import view.OutputView;

import static util.message.InputMessage.INPUT_PRODUCT_DETAIL;
import static util.message.InputMessage.INPUT_SELECTED_PRODUCT;
import static view.OutputView.printCurrentUserBalance;

public class ProductsController {
    private final ProductsService productsService;
    private final UserPaymentService userPaymentService;
    private Products products;

    public ProductsController(){
        productsService = new ProductsService();
        userPaymentService = new UserPaymentService();
    }

    public void generateProductInfo(){
        String productInfo = getProductInfo();
        try{
            products = createProducts(productInfo);
        } catch (IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            generateProductInfo();
        }
    }

    private String getProductInfo(){
        return InputView.readConsole();
    }

    private Products createProducts(String productInfo){
        return productsService.createProducts(productInfo);
    }

    public void buyProduct(){
        String wantedProduct = getSelectedProduct();
        ProductNameDto productNameDto = createSelectedProduct(wantedProduct);
        try{
            productsService.buyProduct(productNameDto);
            Payment payment = userPaymentService.getUserPayment();
            OutputView.printCurrentUserBalance(payment.getPayment());
        } catch(IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            buyProduct();
        }
    }

    private ProductNameDto createSelectedProduct(String wantedProduct){
        return ProductNameDto.create(wantedProduct);
    }

    private String getSelectedProduct(){
        OutputView.printMessage(INPUT_SELECTED_PRODUCT.getValue());
        return InputView.readConsole();
    }

    public boolean checkAvailableToPurchase() {
        Payment payment = userPaymentService.getUserPayment();

        boolean isSoldOutOfItemAvailableForBuy = productsService.checkSoldOutOfItemAvailableForBuy();
        boolean isUserBalanceNotEnough = payment.getPayment() < productsService.getMinItemPrice();

        return !isSoldOutOfItemAvailableForBuy && !isUserBalanceNotEnough;
    }
}

