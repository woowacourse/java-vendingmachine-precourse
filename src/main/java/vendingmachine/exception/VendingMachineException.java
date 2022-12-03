package vendingmachine.exception;

public class VendingMachineException {

     public void validMoneyInputForm(String money){
        final String ONLY_NUMBER = "^[0-9]*$";
        if(!money.matches(ONLY_NUMBER))
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력하세요.");
    }

    public void validGoodsInputForm(String goods){
        final String GOODS_INPUT_FORM = "\\[[가-힇]*,?[0-9]*,?[0-9]*\\];?";
        if(goods.replaceAll(GOODS_INPUT_FORM,"").length()!=0)
            throw new IllegalArgumentException("[ERROR] 상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어주세요.");
    }
}
