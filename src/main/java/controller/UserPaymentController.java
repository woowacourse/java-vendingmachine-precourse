package controller;

import domain.Payment;
import dto.PaymentStatusDto;
import service.UserPaymentService;
import view.InputView;
import view.OutputView;

import static util.message.InputMessage.INPUT_PAYMENT;

public class UserPaymentController {
    private final UserPaymentService userPaymentService;

    public UserPaymentController(){
        userPaymentService = new UserPaymentService();
    }

    public void generateUserBalance(InputView inputView, OutputView outputView) {

        try {
            initUserPayment(inputView, outputView);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            generateUserBalance(inputView, outputView);
        }
    }

    public void initUserPayment(InputView inputView, OutputView outputView){
        String paymentAmount = getPayment(inputView);
        Payment payment = createPayment(paymentAmount);
        PaymentStatusDto paymentStatusDto = userPaymentService.createPaymentStatusDto(payment);
        outputView.printPaymentStatus(paymentStatusDto);
    }

    private String getPayment(InputView inputView){
        return inputView.getUserInput(() -> {
            OutputView.printMessage(INPUT_PAYMENT.getValue());
            return inputView.readConsole();
        });
    }

    private Payment createPayment(String paymentAmount){
        return userPaymentService.createPayment(paymentAmount);
    }
}

