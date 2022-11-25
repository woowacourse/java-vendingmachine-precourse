package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Stocks {
    private List<Stock> stocks = new ArrayList<>();

    public Stocks(String input) {
        List<String> parsedInputs = parseStockInput(input);
        for (String parsedInput : parsedInputs) {
            stocks.add(new Stock(parsedInput));
        }
    }

    private List<String> parseStockInput(String input) throws IllegalArgumentException{
        List<String> stocks = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(input, ";");
        while(tokenizer.hasMoreTokens()){
            stocks.add(tokenizer.nextToken());
        }

        return stocks;
    }

    public void purchaseStock(String stock){

    }
}
