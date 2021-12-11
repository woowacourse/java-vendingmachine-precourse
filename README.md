# 미션 - 자판기

## 🎮 프로젝트 소개

반환되는 동전이 최소한이 되는 자판기를 구현한다.

자판기 관리자는 자판기가 보유할 금액과 상품을 입력한다.<br>
입력된 금액을 바탕으로 500, 100, 50, 10원 단위로 이루어진 무작위 동전을 생성한다.

입력된 상품을 바탕으로 상품을 등록한다.<br>
상품가격은 100원 이상의 10원 단위로 나누어떨어져야하며 1개 이상의 상품이 등록되어야한다.

사용자가 자판기에 금액을 투입한다.<br>
투입 금액을 바탕으로 상품을 구매할 수 있다.<br>
상품 구매 시 투입 금액이 해당 상품의 금액만큼 감소한다.

잔돈을 반환해야 할 경우 반환할 수 있는 만큼의 잔돈을 반환한다.

잘못된 입력의 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

## 🛠 기능 목록

* 자판기가 보유할 금액을 입력받는다.
    * [ERROR] 입력이 숫자인지 검증한다.
    * [ERROR] 입력이 10의 배수인지 검증한다.
    * [ERROR] 입력이 양수인지 검증한다.

* 입력받은 금액을 바탕으로 자판기가 보유할 동전을 무작위로 생성한다.
* 자판기가 보유한 동전 목록을 출력한다.

* 상품 목록을 입력받는다.
    * [ERROR] 상품명은 빈칸일 수 없습니다.
    * [ERROR] 가격은 100원 이상이며 10원으로 나누어떨어지는 자연수여야 합니다.
    * [ERROR] 수량은 자연수여야 합니다.

* 투입 금액을 입력받는다.
    * [ERROR] 투입 금액은 10으로 나누어떨어지는 자연수여야 합니다.

* 투입 금액을 바탕으로 상품을 구매한다.
    * [ERROR] 등록되지 않은 상품입니다.
    * [ERROR] 잔액이 부족합니다.
    * [ERROR] 해당 상품은 품절입니다.

* 잔돈을 반환한다.
    * [ERROR] 남은 금액으로 살 수 있는 상품이 없습니다.
    * [ERROR] 모든 상품이 소진되었습니다.

* 잔돈으로 잔액을 만들 수 없을 경우 잔액보다 작고 가장 근접한 잔돈만큼 반환한다.