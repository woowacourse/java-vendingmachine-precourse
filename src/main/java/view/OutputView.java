package view;

import domain.constant.Constant;
import dto.CoinsDto;
import dto.PaymentStatusDto;
import util.message.OutputMessage;

import static com.sun.javafx.font.FontResource.ZERO;
import static domain.Coin.*;
import static util.message.OutputMessage.*;
import static util.message.OutputMessage.COIN_10;
import static util.message.OutputMessage.COIN_100;
import static util.message.OutputMessage.COIN_50;
import static util.message.OutputMessage.COIN_500;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printCoin(String type, int coinQuantity) {
        System.out.println(String.format(COIN_OUTPUT_FORMAT.getValue(), type, coinQuantity));
    }

    public static void printPaymentStatus(PaymentStatusDto paymentStatusDto){
        System.out.println(String.format(PAYMENT_AMOUNT.getValue(), paymentStatusDto.getPayment()));
    }

    public static void printCurrentUserBalance(int userBalance) {
        System.out.println(String.format(PAYMENT_AMOUNT.getValue(), userBalance));
    }

    public static void printChange(CoinsDto coinsDto) {
        System.out.println(CHANGE_MESSAGE.getValue());

        printCoinIgnoringZero(COIN_500.getValue(), coinsDto.getCoin500Quantity());
        printCoinIgnoringZero(COIN_100.getValue(), coinsDto.getCoin100Quantity());
        printCoinIgnoringZero(COIN_50.getValue(), coinsDto.getCoin50Quantity());
        printCoinIgnoringZero(COIN_10.getValue(), coinsDto.getCoin10Quantity());

        if (coinsDto.getAllCoinQuantity() == ZERO) {
            System.out.println(NO_CHANGE_MESSAGE.getValue());
        }
    }

    private static void printCoinIgnoringZero(String type, int coinQuantity) {
        if (coinQuantity > Constant.ZERO.getValue()) {
            System.out.println(String.format(COIN_OUTPUT_FORMAT.getValue(), type, coinQuantity));
        }
    }

    public static void printVendingMachineHoldingCoins(CoinsDto coinsDto) {
        System.out.println(VENDING_MACHINE_STATUS.getValue());
        printCoin(COIN_500.getValue(), coinsDto.getCoin500Quantity());
        printCoin(COIN_100.getValue(), coinsDto.getCoin100Quantity());
        printCoin(COIN_50.getValue(), coinsDto.getCoin50Quantity());
        printCoin(COIN_10.getValue(), coinsDto.getCoin10Quantity());
    }
}
