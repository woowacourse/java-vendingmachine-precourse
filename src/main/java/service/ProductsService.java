package service;

import domain.Payment;
import domain.Product;
import domain.Products;
import domain.wrapper.Name;
import dto.ProductNameDto;
import repository.ProductsRepository;
import repository.UserPaymentRepository;
import util.exception.NoMatchingCoinException;
import util.exception.NotEnoughBalanceException;
import util.message.ExceptionMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsService {

    private final UserPaymentRepository userPaymentRepository = UserPaymentRepository.getInstance();
    private final ProductsRepository productsRepository = ProductsRepository.getInstance();

    public Products createProducts(final String productsInfo){
        return productsRepository.createProducts(productsInfo);
    }

    public boolean checkSoldOutOfItemAvailableForBuy() {
        Payment payment = userPaymentRepository.get();
        Products products = productsRepository.findAll();
        return products.getProducts().stream()
                .filter(product -> Integer.valueOf(product.getPrice()) <= payment.getPayment())
                .allMatch(Product::isSoldOut);
    }

    public Integer getMinItemPrice() {
        Products products = productsRepository.findAll();
        List<Integer> productPrices = products.getProducts().stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());

        return Collections.min(productPrices);
    }

    public void buyProduct(ProductNameDto productNameDto) {
        Name productName = productNameDto.toEntity();
        Product product = productsRepository.findByProductName(productName);

        Payment userPayment = userPaymentRepository.get();
        if (!userPayment.canBuy(product)) {
            throw new NotEnoughBalanceException();
        }

        Product purchasedProduct = product.decreaseQuantity();

        userPaymentRepository.update(userPayment.subtract(product.getPrice()));
        productsRepository.updateByItemName(productName, purchasedProduct);
    }

}
