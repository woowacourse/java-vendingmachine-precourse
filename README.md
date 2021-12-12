# 미션 - 자판기

## 기능 목록 및 구조

- 이번 미션에서 새로이 적용할 개념 : 람다식, Stream
- Self_Challenge!!
  - 기존 프로그래밍 조건인 인덴트 2이하, 메소드라인 15줄 이하에서 <br>
                     인덴트 1이하, 메소드라인 10줄 이하로 더 극단적인 요구사항을 스스로 정함.<br>
                     이유 : 메소드의 기능 담당을 최소로 만들기 위한 개인 훈련 용도

- Architecture : MVC Pattern

1. Model
   1. Item
   - [x] 현재 제품의 가격을 가져오는 기능
   - [x] 현재 제품의 수량을 가져오는 기능
   - [x] 현재 제품의 수량이 0이하인지 아닌지 검사하는 기능
   - [x] 현재 제품의 수량을 특정 수만큼 감소시키는 기능
   - [x] 현재 제품의 수량을 특정 수만큼 증가시키는 기능
   2. ItemList (일급 컬렉션)
   - [x] 특정 이름을 가진 제품의 수량을 특정 수만큼 감소시키는 기능
   - [x] 전 제품이 품절인지 검사하는 기능
   - [x] 특정 이름을 가진 제품의 가격을 가져오는 기능
   - [x] 현재 품절되지 않은 상품 중 가장 싼 제품의 가격을 가져오는 기능
   - [ ] 사고자 하는 제품이름이 제품 리스트에 있는지 검사하는 기능
   - [ ] 현재 투입금액으로 특정 이름을 가진 제품을 살 수 있는지 검사하는 기능
   - [ ] 이미 품절된 제품을 사는 지 검사하는 기능
   3. User
   - [x] 현재 투입 금액을 가져오는 기능
   - [x] 현재 투입 금액이 남아있는 제품의 가격 중 가장 싼 제품보다 작은지 검사하는 기능
   - [x] 현재 투입 금액을 특정 액수만큼 감소시키는 기능
   4. Coin
   - [ ] 초기 투입 금액을 기준으로 동전을 생성하는 기능
   - [ ] 현재 투입 금액을 기준으로 랜덤하게 500원, 100원, 50원, 10원 동전 중 하나를 생성하는 기능
   - [ ] 현재 거스름돈을 기준으로 잔돈을 생성하는 기능
   - [ ] 현재 거스름돈을 기준으로 반환해야 하는 동전의 액면 금액을 가져오는 기능
   - [ ] 현재 거스름돈을 기준으로 반환해야 하는 동전의 갯수를 가져오는 기능
   - [ ] 현재 반환해야 하는 동전의 갯수를 차감하는 기능
   - [ ] 현재 남아있는 동전이 있는지 확인하는 기능
   
2. View
   1. InputView(interface)
      1. CoinInputView
         - [ ] 자판기의 초기 동전 투입 금액을 가져오는 기능
         - [ ] 자판기의 초기 동전 투입 금액이 유효한지 확인하는 기능
           - 예외) 
             1. 빈 입력인 경우
             2. 숫자가 아닌 경우
             3. 10원 단위로 나누어떨이지지 않는 경우
             4. 양수가 아닌 경우
      2. ItemInformationInputView
         - [ ] 자판기의 제품 목록 입력을 가져오는 기능
         - [ ] 자판기의 제품 목록 입력이 유효한지 확인하는 기능
           - 예외)
             1. 빈 입력인 경우
             2. 세미콜론(;)을 기준으로 아이템이 하나도 없는 경우
             3. 쉼표(,)를 기준으로 제품이름,제품가격,제품수량의 형식이 아닌 경우
             4. 제품이름이 빈 입력인 경우
             5. 제품이름에 특수문자 혹은 공백이 있는 경우
             6. 제품가격이 빈 입력인 경우
             7. 제품가격이 숫자가 아닌 경우
             8. 제품가격이 10원 단위가 아닌 경우
             9. 제품가격이 양수가 아닌 경우
             10. 제품수량이 빈 입력인 경우
             11. 제품수량이 숫자가 아닌 경우
             12. 제품수량이 양수가 아닌 경우
      3. ItemChoiceView
         - [ ] 현재 투입금액에서 사고자 하는 제품의 입력을 가져오는 기능
         - [ ] 현재 투입금액에서 사고자 하는 제품의 입력이 유효한지 검사하는 기능
           - 예외)
             1. 제품이름이 빈 입력인 경우
             2. 제품이름에 특수문자 혹은 공백이 있는 경우
      4. UserMoneyInputView
         - [ ] 사용자의 초기 투입 금액 입력을 가져오는 기능
         - [ ] 사용자의 초기 투입 금액 입력이 유효한지 검사하는 기능
           - 예외)
             1. 초기 투입 금액이 빈 입력인 경우
             2. 초기 투입 금액이 숫자가 아닌 경우
             3. 초기 투입 금액이 10원 단위가 아닌 경우
             4. 초기 투입 금액이 양수가 아닌 경우
   2. OutputView
      - [ ] 자판기의 초기 동전 투입 금액 입력을 요구하는 기능
      - [ ] 자판기의 제품 목록 입력을 요구하는 기능
      - [ ] 사용자의 초기 투입 금액을 요구하는 기능
      - [ ] 현재 사용자의 투입 금액을 출력하는 기능
      - [ ] 현재 사용자의 구입 제품 입력을 요구하는 기능
      - [ ] 현재 자판기의 동전 상황을 출력하는 기능

3. Controller
   1. TransactionController
      - [ ] 전체 거래 프로세스를 진행하는 기능
   2. UserAndItemController
      - [ ] 개별 거래 프로세스를 진행하는 기능
   3. ParsingInputController
      - [ ] 제품 목록을 1차적으로 세미콜론(;), 2차적으로 쉼표(,)를 기준으로 나눈 후 제품 목록을 업데이트 하는 기능

4. Utils
   1. Messages
      - [ ] OutputView에 필요한 메세지 혹은 예외 메세지를 가져오는 기능
   2. Validator
      - [ ] 입력이 빈 입력인지 검사하는 기능
      - [ ] 입력이 숫자인지 검사하는 기능
      - [ ] 입력이 특수문자 혹은 공백을 포함하는지 검사하는 기능
      - [ ] 입력이 특정 숫자로 나누어떨어지는지 검사하는 기능
      - [ ] 입력이 양수인지 검사하는 기능
      - [ ] 제품 입력이 비었는지 검사하는 기능
      - [ ] 제품 입력이 제품이름,제품가격,제품수량의 형식을 만족하는지 검사하는 기능
      - [ ] 입력이 제품 목록에 있는지 검사하는 기능
      - [ ] 입력에 해당 하는 제품의 가격 미만인지 검사하는 기능
      - [ ] 입력에 해당 하는 제품의 수량이 0인지 검사하는 기능
      - [ ] 제품 이름에 해당하는 입력을 검사하는 기능
        1. 입력이 빈 입력인지 검사
        2. 입력이 특수문자 혹은 공백을 포함하는지 검사
      - [ ] 제품 가격에 해당하는 입력을 검사하는 기능
        1. 입력이 빈 입력인지 검사
        2. 입력이 숫자인지 검사
        3. 입력이 특정 숫자로 나누어떨어지는지 검사
        4. 입력이 양수인지 검사
      - [ ] 제품 수량에 해당하는 입력을 검사하는 기능
        1. 입력이 빈 입력인지 검사
        2. 입력이 숫자인지 검사
        3. 입력이 양수인지 검사