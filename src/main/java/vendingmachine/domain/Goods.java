package vendingmachine.domain;

import static vendingmachine.ErrorMessage.ERROR_GOODS_NOT_EXIST;
import static vendingmachine.ErrorMessage.ERROR_GOODS_NOT_UNIQUE;
import static vendingmachine.ErrorMessage.ERROR_GOODS_NO_STOCK;
import static vendingmachine.ErrorMessage.ERROR_INPUT_GOODS;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Goods {
    private static final String goodsRegex =
            "\\[[가-힣]+,\\d+0,(?:[1-9][0-9]?|100)](;\\[[가-힣]+,\\d+0,(?:[1-9][0-9]?|100)])*";
    private static final Pattern goodsRegexPattern =  Pattern.compile(goodsRegex);
    private final HashMap<String, GoodsInformation> goods = new HashMap<>();

    public Goods(String goodsInput) {
        validateGoodsInput(goodsInput);
        inputGoodsParser(goodsInput);
    }

    public GoodsInformation checkBuyingGoods(String goodsName) {
        validateBuyingGoods(goodsName);
        if (goods.get(goodsName).getStock() > 0) {
            return goods.get(goodsName);
        }
        throw new IllegalArgumentException(ERROR_GOODS_NO_STOCK.getMessage());
    }

    public boolean hasAnyStock() {
        int stockSum = 0;
        for (Entry<String, GoodsInformation> good : goods.entrySet()) {
            stockSum += good.getValue().getStock();
        }
        return stockSum != 0;
    }

    public int getMinPrice() {
        return goods.values().stream()
                .mapToInt(GoodsInformation::getPrice)
                .min()
                .orElseThrow();
    }

    private void validateBuyingGoods(String goodsName) {
        if (!goods.containsKey(goodsName)) {
            throw new IllegalArgumentException(ERROR_GOODS_NOT_EXIST.getMessage());
        }
    }

    private void validateGoodsInput(String goodsInput) {
        if (!goodsRegexPattern.matcher(goodsInput).matches()) {
            throw new IllegalArgumentException(ERROR_INPUT_GOODS.getMessage());
        }
    }

    private void validateGoodsNameUnique(String goodsName) {
        if (goods.containsKey(goodsName)) {
            throw new IllegalArgumentException(ERROR_GOODS_NOT_UNIQUE.getMessage());
        }
    }

    private void inputGoodsParser(String goodsInput) {
        StringTokenizer st = new StringTokenizer(goodsInput, "[],;");
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());
            validateGoodsNameUnique(name);
            goods.put(name, new GoodsInformation(price, quantity));
        }
    }

}
