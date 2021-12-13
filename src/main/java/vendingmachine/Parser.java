package vendingmachine;


import java.util.HashMap;
import java.util.Map;

public class Parser {
    public Parser(){

    }
    public Map<String,Goods> parseGoods(String input){
        Map<String,Goods> goodsList = new HashMap<>();
        String[] list = input.split(";");
        for(String goodsInfo : list){
            goodsInfo = goodsInfo.replace("[","");
            goodsInfo = goodsInfo.replace("]","");
            String[] goodsInfoList = goodsInfo.split(",");
            String goodsName = goodsInfoList[0];
            int price = Integer.parseInt(goodsInfoList[1]);
            int number = Integer.parseInt(goodsInfoList[2]);
            Goods goods = new Goods(goodsName,price,number);
            goodsList.put(goodsName,goods);
        }
        return goodsList;
    }

}
