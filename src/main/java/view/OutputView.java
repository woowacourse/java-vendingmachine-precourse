package view;

import dto.CoinsResponseDto;

public class OutputView {
    public void printCoins(CoinsResponseDto coinsResponseDto) {
        System.out.println();
        System.out.println(ViewConstant.COINS_MESSAGE);
        coinsResponseDto.getCoins().forEach((amount, number) -> System.out.printf(("%d원 - %d개\n"), amount, number));
    }
}
