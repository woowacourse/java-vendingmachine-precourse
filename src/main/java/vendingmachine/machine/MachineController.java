package vendingmachine.machine;

import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinController;
import vendingmachine.product.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MachineController {
    private final CoinController coinController = new CoinController();

    public void makeCoins(Machine machine,int money) {
        Map<Coin, Integer> coins = machine.getCoins();
        while( money > 0 ){
            Coin coin = coinController.pickPossibleRandomCoin(money);
            coins.put(coin ,coins.get(coin)+1); //선택된 코인 1개 증가
            money-=coin.getAmount();
        }
    }

    public void makeProductList(Machine machine,String infoList){
        List<Product> productList = machine.getProductList();

        Arrays.stream(infoList.split(";"))
                .forEach(info->{
                    productList.add(makeProduct(info));
                });
    }

    private Product makeProduct(String product){
        String[] infos = makeProductInfo(product);
        return new Product(infos[0],Integer.valueOf(infos[1]),Integer.valueOf(infos[2]));
    }

    private String[] makeProductInfo(String product){
        return product.split(",");
    }




}
