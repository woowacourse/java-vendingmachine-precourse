package view;

import dto.CoinsResponseDto;
import dto.MoneyResponseDto;

public class OutputView {
    public void printCoins(CoinsResponseDto coinsResponseDto) {
        System.out.println();
        System.out.println(ViewConstant.COINS_MESSAGE);
        coinsResponseDto.getCoins().forEach((amount, number) -> System.out.printf(("%d원 - %d개\n"), amount, number));
    }

    public void printEnd(MoneyResponseDto moneyResponseDto, CoinsResponseDto coinsResponseDto) {
        System.out.printf(ViewConstant.CURRENT_MONEY, moneyResponseDto.getMoney());
        System.out.println(ViewConstant.CHANGE);
        coinsResponseDto.getCoins().forEach((amount, number) -> System.out.printf(("%d원 - %d개\n"), amount, number));
    }
}
