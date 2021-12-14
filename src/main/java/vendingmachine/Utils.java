package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Utils {

    public static HashMap<Coin, Integer> makeCoinHash(){
        HashMap<Coin, Integer> coinList = new HashMap<>();
        coinList.put(Coin.COIN_500, 0);
        coinList.put(Coin.COIN_100, 0);
        coinList.put(Coin.COIN_50, 0);
        coinList.put(Coin.COIN_10, 0);
        return coinList;
    }


    public static int vendMoneyInput(){
        System.out.println(Message.INPUT_VEND_MONEY);
        String inputVendMoney = Console.readLine();
        if(Integer.parseInt(inputVendMoney)<0){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputVendMoney);
    }

    public static List<Product> parseProd(String prodInput){
        List<String>splitList = Arrays.asList(prodInput.split(";"));
        List<Product> products = new ArrayList<Product>();
        for(String prod: splitList){
            String substringProd = prod.substring(1,prod.length()-1);
            List<String> splitSubstringProd = Arrays.asList(substringProd.split(","));
            Product newProduct = new Product(splitSubstringProd.get(0), Integer.parseInt(splitSubstringProd.get(1)), Integer.parseInt(splitSubstringProd.get(2)));
            products.add(newProduct);
        }
        return products;
    }

}
