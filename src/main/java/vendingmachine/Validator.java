package vendingmachine;

import java.util.Map;

public class Validator {
    public Validator(){

    }
    public void validateAmount(String amount){
        int parsedAmount = -1;
        try {
            parsedAmount = Integer.parseInt(amount.trim());
        }catch (Exception e){
            System.out.println("[ERROR] 정수로 입력 해주세요");
            throw new IllegalArgumentException();
        }
        if(parsedAmount < 10) {
            System.out.println("[ERROR] 10보다 큰 수를 입력해 주세요");
            throw new IllegalArgumentException();
        }
        if(parsedAmount % 10 !=0) {
            System.out.println("[ERROR] 10으로 나누어 떨어지는 수를 입력해 주세요");
            throw new IllegalArgumentException();
        }
    }
    public void validateGoodsList(String goodsList){
        String[] list = goodsList.split(";");
        for(String goods : list){
            if(goods.charAt(0)!='['|| goods.charAt(goods.length()-1)!=']'){
                System.out.println("[ERROR] 대괄호로 묶여있어야 합니다.");
                throw new IllegalArgumentException();
            }
            goods = goods.replace("[","");
            goods = goods.replace("]","");
            String[] goodsInfo = goods.split(",");
            if(goodsInfo.length !=3){
                System.out.println("[ERROR] 상품 정보 개수는 3개여야 합니다.");
                throw new IllegalArgumentException();
            }
            checkGoodsInfo(goodsInfo[1],goodsInfo[2]);
        }
    }
    public void validateInputMoney(String money){
        int parsedAmount = -1;
        try {
            parsedAmount = Integer.parseInt(money.trim());
        }catch (Exception e){
            System.out.println("[ERROR] 정수로 입력 해주세요");
            throw new IllegalArgumentException();
        }
        if(parsedAmount < 10) {
            System.out.println("[ERROR] 10보다 큰 수를 입력해 주세요");
            throw new IllegalArgumentException();
        }
        if(parsedAmount % 10 !=0) {
            System.out.println("[ERROR] 10으로 나누어 떨어지는 수를 입력해 주세요");
            throw new IllegalArgumentException();
        }
    }
    public void validateUserOrder(String order, Map<String,Goods> goodsList,int leftMoney){
        if(!goodsList.containsKey(order)) {
            System.out.println("[ERROR] 상품 목록에 없는 제품입니다.");
            throw new IllegalArgumentException();
        }
        if(leftMoney < goodsList.get(order).getPrice()){
            System.out.println("[ERROR] 돈이 부족합니다.");
            throw new IllegalArgumentException();
        }
    }
    private void checkGoodsInfo(String price, String number){
        try{
            Integer.parseInt(price.trim());
            Integer.parseInt(number.trim());
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 가격과 수량은 정수여야 합니다.");
        }
        int goodsPrice = Integer.parseInt(price.trim());
        if(goodsPrice < 100) {
            System.out.println("[ERROR] 상품 가격은 100원 부터 시작입니다." );
            throw new IllegalArgumentException();
        }
        if(goodsPrice % 10 != 0){
            System.out.println("[ERROR] 상품 가격은 10원 단위여야 합니다." );
            throw new IllegalArgumentException();
        }
    }


}
