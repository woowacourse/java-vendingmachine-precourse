package vendingmachine.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.domain.Product;
import vendingmachine.dto.ProductInfo;

public class Parser {

    public static Map<String, Product> parseToStockMap(List<ProductInfo> stockInfo) {
        return stockInfo.stream()
                .collect(Collectors.toMap(
                        ProductInfo::name,
                        productInfo -> Product.create(productInfo.price(), productInfo.quantity())
                ));
    }

    public static List<ProductInfo> parseToProductInfoList(String input) {
        List<ProductInfo> productInfos = new ArrayList<>();

        List<String> list = Arrays.asList(input.trim().split(";"));

        list = list.stream()
                .map(it -> it.replaceAll("[\\[\\]]", ""))
                .toList();
        for (String it : list) {
            List<String> list1 = Arrays.asList(it.split(","));
            productInfos.add(
                    new ProductInfo(
                            list1.get(0), parseToInt(list1.get(1)), parseToInt(list1.get(2))
                    )
            );
        }
        return productInfos;
    }

    private static int parseToInt(String input) {
        return Integer.parseInt(input);
    }
}
