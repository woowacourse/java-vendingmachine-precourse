package view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import dto.CoinsResponseDto;
import dto.MoneyResponseDto;

public class OutputView {
    public void printCoins(CoinsResponseDto coinsResponseDto) {
        System.out.println();
        System.out.println(ViewConstant.COINS_MESSAGE);
        List<Integer> coins = new ArrayList<>(coinsResponseDto.getCoins().keySet());
        coins.stream()
            .sorted(Comparator.reverseOrder())
            .forEach(amount -> System.out.printf(("%d원 - %d개\n"), amount, coinsResponseDto.getCoins().get(amount)));
    }

    public void printEnd(MoneyResponseDto moneyResponseDto, CoinsResponseDto coinsResponseDto) {
        System.out.printf(ViewConstant.CURRENT_MONEY, moneyResponseDto.getMoney());
        System.out.println(ViewConstant.CHANGE);
        List<Integer> coins = new ArrayList<>(coinsResponseDto.getCoins().keySet());
        coins.stream()
            .sorted(Comparator.reverseOrder())
            .forEach(amount -> System.out.printf(("%d원 - %d개\n"), amount, coinsResponseDto.getCoins().get(amount)));
    }
}
