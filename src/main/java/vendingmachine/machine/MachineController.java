package vendingmachine.machine;

import vendingmachine.coin.Coin;
import vendingmachine.coin.CoinController;
import vendingmachine.product.Product;
import vendingmachine.product.ProductController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static vendingmachine.constant.Constant.PRODUCT_SPLITTER;

public class MachineController {
    private final CoinController coinController = new CoinController();
    private final ProductController productController = new ProductController();

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

        Arrays.stream(infoList.split(PRODUCT_SPLITTER))
                .forEach(info->{
                    productList.add(productController.makeProduct(info));
                });
    }





}
