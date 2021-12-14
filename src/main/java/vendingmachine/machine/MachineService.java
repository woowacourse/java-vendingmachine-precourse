package vendingmachine.machine;

import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinService;
import vendingmachine.product.Product;
import vendingmachine.product.ProductService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static vendingmachine.constant.Constant.PRODUCT_SPLITTER;

public class MachineService {
    private final CoinService coinService = new CoinService();
    private final ProductService productService = new ProductService();

    public void makeCoins(Machine machine,int money) {
        Map<Coin, Integer> coins = machine.getCoins();
        while( money > 0 ){
            Coin coin = coinService.findCoinByPrice(money);
            coins.put(coin ,coins.get(coin)+1); //선택된 코인 1개 증가
            money-=coin.getAmount();
        }
    }

    public void makeProductList(Machine machine,String infoList){
        List<Product> productList = machine.getProductList();

        Arrays.stream(infoList.split(PRODUCT_SPLITTER))
                .forEach(info->{
                    productList.add(productService.makeProduct(info));
                });
    }

    public void insertMoney(Machine machine, int money){
        machine.insertMoney(money);
    }

    public void buyProduct(Machine machine, String productName){
        machine.buyProduct(productName);
    }

    public void giveChanges(Machine machine){
        machine.returnMoney();
    }

}
