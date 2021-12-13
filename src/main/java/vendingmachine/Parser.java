package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public Parser(){

    }
    public List<Goods> parseGoods(String input){
        List<Goods> goodsList = new ArrayList<>();
        String[] list = input.split(";");
        for(String goodsInfo : list){
            goodsInfo = goodsInfo.replace("[","");
            goodsInfo = goodsInfo.replace("]","");
            String[] goodsInfoList = goodsInfo.split(",");
            Goods goods = new Goods(goodsInfoList[0],Integer.parseInt(goodsInfoList[1]),Integer.parseInt(goodsInfoList[2]));
            goodsList.add(goods);
        }
        return goodsList;
    }

}
