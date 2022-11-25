package vendingmachine.domain;

import static vendingmachine.ui.MessageUtils.INVALID_STOCKS_INPUT;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Stock {
    private final String merchandise;
    private final Money price;
    private int count;

    public Stock(String input) {
        validateStockInput(input);
        List<String> stocks = parseStockInput(input);

        this.merchandise = stocks.get(0);
        this.price = new Money(stocks.get(1));
        this.count = Integer.parseInt(stocks.get(2));
    }

    private void validateStockInput(String input) {
        if (!input.matches("^\\[[^0-9]+,[1-9][0-9][0-9],[0-9]+\\]$")) {
            throw new IllegalArgumentException(INVALID_STOCKS_INPUT.msg());
        }
    }

    private List<String> parseStockInput(String input) throws IllegalArgumentException{
        List<String> parsedStocks = new ArrayList<>();
        String chopped = input.substring(1, input.length() - 1);
        StringTokenizer tokenizer = new StringTokenizer(chopped, ",");
        while (tokenizer.hasMoreTokens()) {
            parsedStocks.add(tokenizer.nextToken());
        }
        return parsedStocks;
    }

    public String getMerchandise() {
        return merchandise;
    }

    public boolean hasStock() {
        return count > 0;
    }

    public Integer getPrice() {
        return price.getAmount();
    }

    public void purchase() {
        count--;
    }
}
