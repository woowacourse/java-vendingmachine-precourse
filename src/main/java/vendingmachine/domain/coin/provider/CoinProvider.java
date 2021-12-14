package vendingmachine.domain.coin.provider;

public interface CoinProvider {
    int drawCoinLessThanBalance(int balance);
}
