package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Stock {
    private final String merchandise;
    private final int price;
    private final int count;

    public Stock(String input) {
        validateStockInput(input);
        List<String> stocks = parseStockInput(input);

        this.merchandise = stocks.get(0);
        this.price = Integer.parseInt(stocks.get(1));
        this.count = Integer.parseInt(stocks.get(2));
    }

    private void validateStockInput(String input) {
        if (!input.matches("^[[a-zA-Z]+,[0-9]+,[0-9]+]$")) {
            throw new IllegalArgumentException("error!");
        }
    }

    private List<String> parseStockInput(String input) {
        List<String> parsedStocks = new ArrayList<>();

        String chopped = input.substring(1, input.length() - 1);
        StringTokenizer tokenizer = new StringTokenizer(chopped, ",");
        while (tokenizer.hasMoreTokens()) {
            parsedStocks.add(tokenizer.nextToken());
        }

        return parsedStocks;
    }
}
