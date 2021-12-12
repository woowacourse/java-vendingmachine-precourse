## 2주차 코드에 대한 피드백

### 예외처리에 대해서 좀 더 생각 해 봤어야 했나??

자동차 경주 게임 미션의 경우

이름에 빈값이 들어간다면?? 

이름에 쉼표가 들어간다면??

등등...

생각보다 사용자 입력은 예외상황이 엄청 많다!!! 

예외 상황에 대처하면 할 수록 좋은 코드가 될 것 이다. 이번 3주차 미션에는 좀 더 예외 상황에 유연하게 대처 해야 겠다.

### 기능 목록 구현이 너무 구체적이었나??

구체적이었다 함은 너무 코드 레벨 수준으로 기능 목록을 작성 했다. 

좀 더 추상적이고 인터페이스 적으로 적어야 겠다.

그렇다고 해서 기능 목록을 듬성듬성 작성 한다는 것을 의미 하지 않는다. 

추상적으로 적되, 모든 상황을 커버 할 수 있도록 기능 목록을 구현 해야 한다. 

### gitignore에 추가해야 될 것들

.idea 파일은 이미 클론 받은 파일에도 추가 되어 있고, .metadata도 gitignore에 추가 해야 겠다. 

### 객체에 메세지를 보내라??

2주차 피드백에 주신 예시가 너무 좋다. 현재 position이 max 인지 아닌지 판단하는 기능을 구현 할 때 필요한 것들은 다음과 같다. 

```java
@Override
public List getWinners(GameData gameData) {
   List<String> winners = new ArrayList<>();
   int maxPosition = figureOutMaxPosition(gameData);
   return getWinnersList(gameData, winners, maxPosition);
}

private List<String> getWinnersList(GameData gameData, List<String> winners, int maxPosition) {
   for (Car car : gameData.getCars()) {
      if (car.getPosition() == maxPosition) {
         winners.add(car.getName());
      }
   }
   return winners;
}
```

피드백에 올려 주신 것과  너무 똑같이 구현해서 좀 소름이 돋았다. Model 안에 들어 있는 객체에 최대한 로직을 넣지 않기 위해서 car 객체에 position을 뽑아서 controller에서 로직을 구현 하려고 했는데, 객체의 private 필드를 직접 접근 할 수 있는 getter를 사용하기 보다 메세지를 보내서 최대한 숨기려고 노력 해 봐야 겠다. 

### 필드의 수를 줄여보자...

2주차 피드백에 주신 예시를 보고 처음에 딱 떠오른 생각은 데이터베이스 정규화다. 

제 3정규화를 보게 되면 이행적 종속을 없애도록 테이블을 분해 하라고 명시되어 있는데, 피드백으로 주신 

private List<Car> cars; 

private List<String> winners; 

private int maxDistance;
3개의 필드 중에서 cars 변수만 있으면 winners와 maxDistance가 종속적으로 결정되기 때문에, 필드에 넣지 않고 함수를 통해 구현 한다. 

### 디테일을 잘 지켜서 코딩해 보자...

하드코딩 또 했네... 생각보다 혼자서 개발 하다 보니까 하드코딩을 하게 된다. 

함수 및 변수 네이밍을 좀 더 고민해서 코딩 해 보자.. 

## 기능 구현 목록

### Components

1. 보유 금액
2. 상품 가격

### UI(View)

1. 자판기가 보유하고 있는 금액을 콘솔창을 통해서 입력받는다. 
2. 자판기가 보유한 동전을 콘솔창에 출력한다. 
3. 상품명과 가격, 수량을 콘솔창을 통해서 입력받는다. 
4. 콘솔창을 통해서 사용자에게 투입 금액을 입력받는다.
5. 콘솔창을 통해서 사용자에게 남은 투입 금액을 출력한다. 
6. 콘솔창을 통해서 사용자에게 구매할 상품명을 입력받는다. 
7. 콘솔창에 잔돈을 출력한다. 

### Logic(Controller)

1.
