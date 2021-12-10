package vendingmachine.domain.coin.util;

public interface CoinProvider {
    int drawCoinLessThanBalance(int balance);
}
