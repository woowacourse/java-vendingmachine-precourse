package vendingmachine.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.domain.Product;
import vendingmachine.dto.ProductDTO;

public class Parser {

    public static Map<String, Product> parseToStockMap(List<ProductDTO> stockInfo) {
        return stockInfo.stream()
                .collect(Collectors.toMap(
                        ProductDTO::name,
                        productInfo -> Product.create(productInfo.price(), productInfo.quantity())
                ));
    }

    public static List<ProductDTO> parseToProductInfoList(String input) {
        List<ProductDTO> productDTOS = new ArrayList<>();

        List<String> list = Arrays.asList(input.trim().split(";"));

        list = list.stream()
                .map(it -> it.replaceAll("[\\[\\]]", ""))
                .toList();
        for (String it : list) {
            List<String> list1 = Arrays.asList(it.split(","));
            productDTOS.add(
                    new ProductDTO(
                            list1.get(0), parseToInt(list1.get(1)), parseToInt(list1.get(2))
                    )
            );
        }
        return productDTOS;
    }

    public static int parseToInt(String input) {
        return Integer.parseInt(input);
    }
}
