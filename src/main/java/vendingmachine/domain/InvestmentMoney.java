package vendingmachine.domain;

public class InvestmentMoney {
    private static final int DEFAULT_INVESTMENT_MONEY = 0;
    private static final int QUOTIENT = 10;
    private static final int REMAINDER = 0;

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
            throw new IllegalArgumentException();
        }
    }

    private void validateNegativeNumber(int investmentMoney) {
        if (investmentMoney < DEFAULT_INVESTMENT_MONEY) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivide(int investmentMoney) {
        if (investmentMoney % QUOTIENT != REMAINDER) {
            throw new IllegalArgumentException();
        }
    }

    public void calculate(Product product) {
        if (investmentMoney < product.getPrice()) {
            throw new IllegalArgumentException();
        }

        product.decreaseQuantity();
        investmentMoney -= product.getPrice();
    }

    @Override
    public String toString() {
        return investmentMoney + "원";
    }
}