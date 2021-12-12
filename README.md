# 미션 - 자판기

## 🛠 기능 구현 목록

### 자판기 초기 설정

- 자판기가 보유한 금액을 입력받기 위한 메세지를 출력한다.
    - 출력 메세지 : "자판기가 보유하고 있는 금액을 입력해 주세요."
- 자판기가 보유한 금액을 입력받는다.
    - 입력 예시 : "450"

- 자판기가 보유한 금액을 금액별 랜덤한 갯수의 동전으로 만든다.
- 자판기의 보유 금액을 동전별 갯수를 출력한다.
    - 출력 예시  
      자판기가 보유한 동전  
      500원 - 0개  
      100원 - 4개  
      50원 - 1개  
      10원 - 0개

- 상품을 진열하 위한 메세지를 출력한다.
    - 출력 메세지 : "상품명과 가격, 수량을 입력해 주세요."
- 상품명과 가격, 수량을 입력받는다.
    - 입력 예시 : "[콜라,1500,20];[사이다,1000,10]"

### 자판기 사용

- 투입할 금액을 입력받기 위한 메세지를 출력한다.
    - 출력 메세지 : "투입 금액을 입력해 주세요."
- 투입할 금액을 입력받는다.
    - 입력 예시 : "3000"

- 남은 금액이 남은 상품을 구매할 수 있을 경우, 아래를 반복한다.
    - 투입 금액 중 현재 남은 금액을 출력해준다.
        - 출력 예시 : "투입 금액: 3000원"
    - 구매할 상품명을 입력받기 위한 메세지를 출력한다.
        - 출력 메세지 : "구매할 상품명을 입력해 주세요."
    - 구매할 상품명을 입력받는다.
        - 입력 예시 : "콜라"

- 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우,
    - 투입 금액 중 현재 남은 금액을 출력해준다.
        - 출력 예시 : "투입 금액: 3000원"
    - 잔돈을 출력한다.
        - 출력 예시  
          잔돈  
          100원 - 4개  
          50원 - 1개
    - 잔돈을 반환할 때 최소 갯수의 동전으로 반환해야한다.
    - 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.  
      이 때, 남은 잔돈은 자판기에 남는다.

## 📌 예외 처리 사항

- 사용자 입력시 생기는 에러는 'IllegalArgumentException'을 발생시킨다.
- '[ERROR]'로 시작하는 에러 메세지를 출력한 뒤 해당 부분을 다시 입력받는다.

### 예외 상황 및 에러 메세지

- 자판기의 보유 금액 입력시
    - 숫자인지 확인해야한다.  
      에러 메세지 : "[ERROR] 금액은 숫자여야 합니다."
    - 10원 단위로 나누어 떨어지는지 확인해야한다.  
      에러 메세지 : "[ERROR] 금액은 10원 단위로 나누어 떨어져야 합니다."
    - 음수 단위가 입력되었는지 확인해야한다.  
      에러 메세지 : "[ERROR] 금액은 음수가 될 수 없습니다."

- 상품명,가격,수량 입력시
    1. 상품명

    - 빈 칸인지 확인해야한다.  
      에러 메세지 : "[ERROR] 빈 칸은 입력하실 수 없습니다."
    - 중복을 확인해야한다.  
      에러 메세지 : "[ERROR] 중복된 상품명을 사용하실 수 없습니다."

    2. 가격

    - 빈 칸인지 확인해야한다.  
      에러 메세지 : "[ERROR] 빈 칸은 입력하실 수 없습니다."
    - 숫자인지 확인해야한다.  
      에러 메세지 : "[ERROR] 금액은 숫자여야 합니다."
    - 음수인지 확인해야한다.  
      에러 메세지 : "[ERROR] 금액은 음수가 될 수 없습니다."
    - 100원 이상이 입력되었는지 확인해야한다.  
      에러 메세지 : "[ERROR] 가격은 100원 이상 입력하셔야합니다."
    - 10원 단위로 나누어 떨어지는지 확인해야한다.  
      에러 메세지 : "[ERROR] 금액은 10원 단위로 나누어 떨어져야 합니다."

    3. 수량

    - 빈 칸인지 확인해야한다.  
      에러 메세지 : "[ERROR] 빈 칸은 입력하실 수 없습니다."
    - 숫자인지 확인해야한다.  
      에러 메세지 : "[ERROR] 금액은 숫자여야 합니다."
    - 음수인지 확인해야한다.  
      에러 메세지 : "[ERROR] 금액은 음수가 될 수 없습니다."
    - 1개 이상이 입력되었는지 확인해야한다.  
      에러 메세지 : "[ERROR] 수량은 1개 이상 입력하셔야합니다."

- 구매할 상품명 입력시
    - 빈 칸인지 확인해야한다.  
      에러 메세지 : "[ERROR] 빈 칸은 입력하실 수 없습니다."
