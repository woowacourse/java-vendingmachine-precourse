package vendingmachine.exception;

public class VendingMachineException {

    public void validMoneyInputForm(String money) {
        final String ONLY_NUMBER = "^[0-9]*$";

        if (!money.matches(ONLY_NUMBER))
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력하세요.");
    }

    public void validMoneyRange(String money) {
        if (Integer.parseInt(money) < 10)
            throw new IllegalArgumentException("[ERROR] 금액은 10원부터 시작입니다.");
    }

    public void validGoodsInputForm(String goods) {
        final String GOODS_INPUT_FORM = "\\[.*,?[0-9]*,?[0-9]*\\];?";

        if (goods.replaceAll(GOODS_INPUT_FORM, "").length() != 0)
            throw new IllegalArgumentException("[ERROR] 상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어주세요.");
    }

    public void validGoodsMoneyType(int money) {
        if (money < 100)
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원부터 시작합니다.");

        if (money % 10 != 0)
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10원 단위로 입력하세요.");
    }
}
