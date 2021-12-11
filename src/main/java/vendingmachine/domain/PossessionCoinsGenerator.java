package vendingmachine.domain;

@FunctionalInterface
public interface PossessionCoinsGenerator {
    PossessionCoins generate(PossessionMoney possessionMoney);
}