package view;

import dto.PaymentStatusDto;
import dto.VendingMachineStatusDto;
import util.message.OutputMessage;

import java.util.List;

import static util.message.OutputMessage.*;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printVendingMachineStatus(List<VendingMachineStatusDto> statusList) {
        System.out.println(VENDING_MACHINE_STATUS.getValue());
        for (VendingMachineStatusDto statusDto : statusList) {
            System.out.println(String.format("%d" + WON.getValue() + HYPHEN.getValue() + "%d" + COUNT.getValue(), statusDto.getCoin(), statusDto.getCount()));
        }
    }

    public void printPaymentStatus(PaymentStatusDto paymentStatusDto){
        System.out.println(PAYMENT_AMOUNT.getValue() + paymentStatusDto.getPayment() + WON.getValue());
    }
}
