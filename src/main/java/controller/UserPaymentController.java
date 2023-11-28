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

    public void generateUserBalance() {
        String paymentAmount = getPayment();
        try {
            Payment payment = createPayment(paymentAmount);
            PaymentStatusDto paymentStatusDto = userPaymentService.createPaymentStatusDto(payment);
            OutputView.printPaymentStatus(paymentStatusDto);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            generateUserBalance();
        }
    }

    private String getPayment(){
        OutputView.printMessage(INPUT_PAYMENT.getValue());
        return InputView.readConsole();
    }

    private Payment createPayment(String paymentAmount){
        return userPaymentService.createPayment(paymentAmount);
    }
}

