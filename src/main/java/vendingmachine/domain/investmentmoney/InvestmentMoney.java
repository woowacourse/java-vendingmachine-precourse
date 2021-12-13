package vendingmachine.domain.investmentmoney;

import vendingmachine.domain.Coin;
import vendingmachine.domain.possessioncoin.PossessionCoin;
import vendingmachine.domain.product.Product;

public class InvestmentMoney {
    private static final int DEFAULT_INVESTMENT_MONEY = 0;
    private static final int QUOTIENT = 10;
    private static final int REMAINDER = 0;
    private static final String TO_STRING_FORMAT = "%d원";

    private static final String VALID_NUMBER_FORMAT = "[ERROR] 투입 금액은 숫자여야 합니다.";
    private static final String VALID_NEGATIVE_NUMBER = "[ERROR] 투입 금액은 음수가 될 수 없습니다.";
    private static final String VALID_DIVIDE = "[ERROR] 투입 금액은 10으로 나누어 떨어져야 합니다.";
    private static final String VALID_PRODUCT_PRICE = "[ERROR] 금액 부족으로 상품을 구매할 수 없습니다.";

    private int investmentMoney;

    public InvestmentMoney(String inputInvestmentMoney) {
        validateNumberFormat(inputInvestmentMoney);
        int investmentMoney = Integer.parseInt(inputInvestmentMoney);

        validateNegativeNumber(investmentMoney);
        validateDivide(investmentMoney);
        this.investmentMoney = investmentMoney;
    }

    private void validateNumberFormat(String inputInvestmentMoney) {
        try {
            Integer.parseInt(inputInvestmentMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NUMBER_FORMAT);
        }
    }

    private void validateNegativeNumber(int investmentMoney) {
        if (investmentMoney < DEFAULT_INVESTMENT_MONEY) {
            throw new IllegalArgumentException(VALID_NEGATIVE_NUMBER);
        }
    }

    private void validateDivide(int investmentMoney) {
        if (investmentMoney % QUOTIENT != REMAINDER) {
            throw new IllegalArgumentException(VALID_DIVIDE);
        }
    }

    public void calculate(int price) {
        if (investmentMoney < price) {
            throw new IllegalArgumentException(VALID_PRODUCT_PRICE);
        }
        investmentMoney -= price;
    }

    public boolean isPay(Product product) {
        return investmentMoney >= product.getPrice();
    }

    public boolean isPossibleChange(PossessionCoin possessionCoin) {
        Coin coin = possessionCoin.getCoin();
        return investmentMoney >= coin.getAmount();
    }

    public int trade(int amount, int quantity) {
        int minCoinQuantity = Math.min(investmentMoney / amount, quantity);
        investmentMoney -= amount * minCoinQuantity;
        return minCoinQuantity;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, investmentMoney);
    }
}