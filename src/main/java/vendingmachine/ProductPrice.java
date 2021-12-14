package vendingmachine;


import validator.ExceptionMessage;

// 클래스: 접근제어자, class, 이름
public class ProductPrice {
    // 프로퍼티: 접근제어자, 자료형, 이름
    private int price;
    private int discount;

    // 생성자: 접근제어자, 이름, 매개변수(params)
    public ProductPrice() {
        this.price = 0;
    }

    // 메서드: 접근제어자, 반환 데이터타입, 이름, 매개변수
    public int getPrice() {
        return this.price;
    }

    // 데이터타입, 이름, 할당 메서드(매개변수)
    ProductPrice productPrice = new ProductPrice(); // ProductPrice 클래스 변수 productPrice -> 인스턴스

    public ProductPrice(int price) {
        if (price < 0 && price % 10 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PHRASE);
        }
        this.price = price;
    }

    // all-arguments constructor

    public ProductPrice(String price) {
        int priceTemp = Integer.parseInt(price);

        if (priceTemp < 0 && priceTemp % 10 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PHRASE);
        }
        this.price = priceTemp;
    }
}
