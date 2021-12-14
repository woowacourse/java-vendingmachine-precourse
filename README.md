# 3주차미션 _🤹‍♂️자판기🔮🧁🍧🧃



## 0. 자판기 소개 🥤

* 이 자판기는 반환되는 동전의 개수가 최소한이 되는 자판기 프로그램이다.
* 초기 설정으로 돈을 투입하여 `잔돈`을 생성하고,  판매하고자 하는 `상품 정보`(이름, 가격, 수량)를 입력하여 설정할 수 있다. 
* 상품을 구매하기 위해 `돈을 투입`하고, 돈이 남아 있다면 원하는 상품을 입력하여 구매하는 과정을 계속할 수 있다.
* 물건을 더 이상 구매할 수 없는 경우에는 가능한 잔돈만을 반환하는데, 기대하는 잔돈 모두를 돌려받지 못할 수 있다. 즉, 잔돈 종류의 개수가 부족한 경우 잔돈을 먹는 이상한 자판기다🤹‍♂️



## 1. 기능 목록 🔍

- [x] 자판기가 보유하고 있는 금액을 입력 받는다.
- [x] 입력 받은 금액을 기준으로 자판기가 보유할 동전의 개수를 무작위로 생성한다.
  - [x] 이후 투입된 금액으로는 동전을 생성하지 않는다.
  - [x] 자판기 보유 동전의 종류와 수량 출력하여 보여준다.
- [x] 상품명, 가격, 수량 입력 받는다.
  - [x] [상품명,가격,수량];[상품명,가격,수량] 형태로 입력 받는다.
  - [x] 이때 상품 가격은 100원부터 시작하여 10원으로 나누어 떨어지는 수이다.
- [x] 투입 금액을 입력 받는다.
- [x] 구매할 상품명을 입력 받는다 -> 구매할 수 있을 때까지 상품 구매를 반복한다.

```
투입 금액: 3000원
구매할 상품명을 입력해 주세요.
콜라
```

- [x] 남은 금액이 상품의 최저 가격 보다 적을 시 잔돈 반환한다.
- [x] 모든 상품이 소진된 경우 잔돈 반환한다.
- [x] 동전 수량에 따라 잔돈을 반환할 수 없는 경우를 제외하고 반환할 수 있는 동전만 반환한다. 📍그리디 알고리즘
  - [x] 반환되지 않는 금액은 자판기에 남는다. 
- [x] 사용자가 입력을 잘못한 경우 `IllegalArgumentException`를 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받는다.



## 2. 예외 처리🚩

이번 미션에서는 주어진 규칙 중에 명확하지 않는 점들이 많기 때문에 나름대로 여러 경우들을 고려하여 예외 처리를 많이 해야 했습니다. 아래는 기능 구현을 하며 고려한 예외 처리 목록입니다.

- [x] 자판기 보유 금액 입력 관련 예외처리

  - [x] 숫자만 입력할 수 있다.

  - [x] 10원단위로 입력할 수 있다.

  - [x] 공백은 인정하지 않는다.

  - [x] 0은 인정하지 않는다.

  - [x] 음수는 인정하지 않는다.

    

- [x] 상품 정보(상품명, 가격, 수량) 입력 관련 예외처리

  - [x] 상품명에는 문자, 숫자로 입력 가능하다.

  - [x] 상품명은 한자리 이상 입력해야 한다 -> 빈값 인정하지 않는다.

  - [x] 가격과 수량에는 숫자만 입력할 수 있다.

  - [x] 가격은 100원부터 가능하며, 10원 단위로 입력할 수 있다.

  - [x] 서로 다른 상품명만 입력할 수 있다 -> 상품 중복 불가하다.

  - [x] 상품 정보는 다음 형식을 맞춰 입력할 수 있다.

    - [x] 상품명, 가격, 수량은 쉼표(,)로 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분한다.

    ```
    [콜라,1500,20];[사이다,1000,10]
    ```

    

- [x] 투입 금액 입력 관련 예외처리

  - [x] 숫자만 입력할 수 있다.
  - [x] 공백은 인정하지 않는다.
  - [x] 0은 인정하지 않는다.
  - [x] 음수는 인정하지 않는다.

  

- [x] 구매할 상품 이름 입력 관련 예외처리

  - [x] 상품 리스트에 해당 상품이 존재해야 구매가 가능하다.
    * 상품 이름이 상품 객체로 만들어지는지부터 확인
  - [x] 남은 투입 금액 보다 해당 상품 가격이 작거나 같아야 구매 가능하다.
  - [x] 상품의 재고량이 1 이상이어야 가능하다.



[기능 및 프로그래밍 요구사항](/markdown/기타요구사항정리.md)

