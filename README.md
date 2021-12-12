# 미션 - 자판기


## 🚀 기능 목록

### Vending machine

- 보유 금액
  - [ERROR] 숫자가 입력되지 않은 경우 exception이 발생해야 한다.
  - [ERROR] 10원으로 나누어 떨어지지 않는 금액이 들어오는 경우 exception이 발생해야 한다.
- 보유 동전
  - 자판기는 보유금액을 받아 500, 100, 50, 10원의 랜덤한 동전을 가질 수 있다.
  - 현재 자판기가 보유중인 Coin 종류 리스트를 반환할 수 있다.
  - RandomUtils의 값으로 각 랜덤한 동전을 받아 전체 동전에서 차감될 때 까지 랜덤한 동전을 받을 수 있다.
  - [ERROR] RandomUtils에서는 500, 100, 50, 10의 동전이 들어오지 않는 경우 exception이 발생해야 한다.
  - [ERROR] 랜덤한 동전이 현재 Money보다 큰 경우 exception이 발생해야 한다.
- 보유 상품
  - 보유 상품은 상품명, 가격, 수량으로 구성되어 있다.
  - [ERROR] 상품명이 중복되어 들어올 경우 exception이 발생해야 한다.
  - [ERROR] 가격이 100원 이하일 경우 exception이 발생해야 한다.
  - [ERROR] 가격이 10원으로 나누어떨어지지 않는 금액이 들어오는 경우 exception이 발생해야 한다.
- 상품 구매
  - [ERROR] 숫자가 입력되지 않은 경우 exception이 발생해야 한다.
  - [ERROR] 상품명이 vending machine에 존재하지 않는 경우 exception이 발생해야 한다.
  - [ERROR] 상품의 남은 수량이 0인데 구매하는 경우 exception이 발생해야 한다.
  - [ERROR] 구매하려는 상품의 가격이 현재 보유 Money보다 클 경우 exception이 발생해야 한다.
  - 상품을 구매하면 해당 상품의 수량이 1 차감되고, 보유 금액이 상품 금액만큼 차감된다.
  - 보유 금액이 최소 상품 금액보다 작을 경우 잔돈이 반환되어야 한다.
  - 모든 상품이 소진될 경우 잔돈이 반환되어야 한다.
  - 잔돈이 반환될 때 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환하고 나머지 금액은 자판기에 남는다.

#### ⌨️ 입력

- 상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분한다.

```
[콜라,1500,20];[사이다,1000,10]
```

#### 🖥 출력

- 자판기가 보유한 동전

```
500원 - 0개
100원 - 4개
50원 - 1개
10원 - 0개
```

- 잔돈은 반환된 동전만 출력한다.

```
100원 - 4개
50원 - 1개
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR]로 시작해야 한다.

```
[ERROR] 금액은 숫자여야 합니다.
```

#### 💻 프로그래밍 실행 결과 예시

```
자판기가 보유하고 있는 금액을 입력해 주세요.
450

자판기가 보유한 동전
500원 - 0개
100원 - 4개
50원 - 1개
10원 - 0개

상품명과 가격, 수량을 입력해 주세요.
[콜라,1500,20];[사이다,1000,10]

투입 금액을 입력해 주세요.
3000

투입 금액: 3000원
구매할 상품명을 입력해 주세요.
콜라

투입 금액: 1500원
구매할 상품명을 입력해 주세요.
사이다

투입 금액: 500원
잔돈
100원 - 4개
50원 - 1개
```