# PhotoFrame Step1
## 1단계 프로젝트 실행하기
### 안드로이드 애뮬레이터에서 실행
![image](https://user-images.githubusercontent.com/58967292/153792063-08ed489b-7af4-4534-9085-0c638edf1d46.png)
### 하드웨어 기계에서 앱 실행
![image](https://user-images.githubusercontent.com/58967292/153981226-1d3bfe62-9b53-4607-9cfa-6bd704b71320.png)
### 학습목표
* 1 LogCat & Log 클래스
* 2 Activity
* 3 Activity 라이프 사이클
* 4.라이프 사이클 확인 방법


## LogCat
### How to use
* Log 클래스를 이용하여 logcat에 표시되는 로그 메시지를 만들 수 있습니다
* 일반적으로 Log클래스를 메서드를 이용하여 생성
* Log 클래스에 정의 메서드를 우선순위가 높은것부터 낮은것부터 나열하면
* ![image](https://user-images.githubusercontent.com/58967292/153996528-02a66c4d-7d6a-4310-986a-7c8291118d1b.png)
* 메서드 호출 형태는 그림과 같이  Tag:String, Message:String 일수도 있고
* Tag:String, Message:String tr:Throwable로 예외에 대한 기록을 할수도 있다. 
* TIP: 파라미터로 사용되는 Tag를 액티비티 별로 따로 변수로 선언하면 좋다
### LogCat 활용하기 : onCreate

```Kotlin
var tag= "MainActivity"
Log.d("${tag}","onCreate")
```

![step1_logcat](https://user-images.githubusercontent.com/58967292/153793055-f41b0568-eff4-4440-8f55-2e75d6ac078c.PNG)

* onCreate 뿐만아니라 액티비 라이프 사이클에 대한 콜백함수 모두에 LogCat을 출력해볼 수 있다 => 자세한 결과 4단계 액티비티 전환에서 구현
* LogCat이 아니라 Toast를 이용해 콜백함수 호출시 토스트 메시지가 출력되도록 구현해보았다.

```Kotlin
Toast.makeText(this, "onCreate()호출", Toast.LENGTH_SHORT).show()
```
![image](https://user-images.githubusercontent.com/58967292/153997253-f9b0770b-9e7b-4e57-9c96-b91c5cb812ad.png)


## Activity
* 액티비티는 사용자에게 사용자 인터페이스를 제공하는 앱 구성요소이다
* 액티비티는 화면의 기본 구성단위이다.

## Activity 작동
* UI는 XML 파일로, 동작은 .kt파일로 구성, 둘이 한 쌍을 이룸

## Activity 생명주기 + 확인방법
![image](https://user-images.githubusercontent.com/58967292/153981987-86468b48-206d-4d63-b347-28dbcf729cc1.png)

* 사람이 태어나서 죽을떄까지 유아기,청소년기,노년기를 거치듯 액티비티도 생성부터 소멸까지 여러단계를 거친다
* 액티비티는 각 상태마다 할 수 있는 행동, 해야하는 행동이 다르다.
* 액티비티는 사용자의 활동에 따라 새로운 상태에 들어가고, 그 상태에 들어가면 시스템은 미리 정의한 콜백 함수를 실행한다.

* onCreate()
  * 액티비티를 '생성된 상태'로 만들어준다
  * 액티비티에 필요한 초기 설정을 여기서 해주면된다 ( EX setContentView() 함수로 사용자에게 보여줄 레이아웃을 선택, 레이아웃을 정의한 파일(리소스)의 ID를 파라미터로 준다)
  * '생성된 상태'가 되려면 화면이 있어야 하고 화면이 있기 위해서는 사용할 레이아웃이 무엇인지 알아야 한다.
  * 한줄 요역: 시스템이 액티비티를 처음시작할때 실행되며, 레이아웃 지정, 클래스 범위 변수 초기화등 기본적인 앱 시작로직 구현해주는 단계이다. 

* onStart()
  * 액티비티가 시작된 상태에 들어가기 직전에 실행되는 콜백함수
  * 액티비티가 사용자에게 보이지만, 사용자와의 상호작용은 아직 준비하는 단계 => 포커스가 아직 없음
  * UI 관련 로직 초기화 처리 단계

* onResume()
  * 액티비티가 재개된 상태로 들어가기 직전에 실행되는 콜백함수. 
  * onResume()가 호출되는 Case 
    * 액티비타가 처음 실행되고 create-start를 거쳐 resume이 되는 경우
    * 다른 액티비티로 넘어갔다가, 다시 돌아오는 과정에서 restart->start 를 거쳐 resume이 되는 경우 
    * 이벤트로 인해 액티비티가 중단되거나 , 멀티 윈도우의 경우 다른 앱에 포커스가 갔다 다시 해당 앱으로 포커스가 생기는 경우  onPause() 상태에서 onResume()이 호출된다. 
  * 액티비티와 사용자와의 상호작용이 가능해진다.
  * 전화가 오거나, 다른 액티비티로 이동하는 등 포커스를 잃는 경우가 아닌 이상 액티비티는 재개된 상태로 존재

* 포커스
  *  특정 뷰가 사용자와 상호작용하기 시작하면 해당 뷰에 '포커스가 있다'라고 한다
  *  포커스가 없다 != 보이지 않는다 , 멀티 윈도우 환경에서 보일수 있다

* onPause()
  * 사용자가 액티비티를 떠나는 경우 처음 실행되는 콜백함수 
  * 더는 해당 액티비티에 포커스가 없다  but 액티비티가 소멸된 것이 아니다 
  * 액티비티가 완전히 보이지않을때나 다시 실행될때까지 pause 상태에 머무른다
  * onPause()가 호출되는 Case
    * 일부 이벤트가 앱실행을 방해함
    * 멀티 윈도우의 경우, 여러개의 앱을 실행하는데 포커스를 가질수있는 앱은 하나뿐이다. 포커스를 가진 앱 이외의 앱들은 일시중지 되어야 한다.
    * 새로운 반투명 액티비티가 실행 => 부분적으로 액티비티가 여전히 보일 수 있지만, 포커스가 없기 때문에 일시정지된 상태 
  * 액티비티가 보이지 않을 때 or 사용자와 상호작용할 필요가 없을 떄,  더 이상 실행할 필요없는 부분들을 비활성화 해주면 된다 
  * 대부분은 경우 onPause()이후 
  * onPause()가 지속되는 시간이 굉장히 짧음 => 사용자 정보를 DB에 저장하거나 네트워크 호출을 하는등 중요하거나 시간이 오래걸리는 작업을 수행하면 안된다
  * 부하가 큰 작업은 다음 콜백인 onStop()에서 수행해 줘야 한다

* onStop()
  * 액티비티가 사용자에게 더이상 표시 안되는 완전히 중단된 상태에 들어가기 직전에 실행되는 콜백함수
  * onPause()에서 언급한 부하가 큰 작업들을 실행할 수 있다

* onDestory()
  * 액티비티가 완전히 솔명되기 직전에 호출되는 콜백함수

* onRestart()
  * 중단된 상태에 있던 액티비티가 사용자에 의해 재실행되는 경우 먼저 호출되는 콜백함수
  * onstart() 함수가 이어서 호출된다

## 2단계 TextView  구현하기
### 결과
![image](https://user-images.githubusercontent.com/58967292/153997927-f31f26a5-1f27-45ab-8f3d-685a87e58dee.png)

### 학습목표
* 1 디자인 편집기
* 2 findViewByID
* 3 TextView 속성
* 4.findViewByID로 가져온 TextView의 속성값 변경

## Design Editor
### 1 팔레트
![image](https://user-images.githubusercontent.com/58967292/153998166-c5946841-7428-4726-8917-84b569ee5c90.png)
* 레이아웃으로 드래그 앤 드롭 할 수 있는 다양한 뷰와 레이아웃 리스트를 보여줌
* 드래그앤 드랍하면 XML 파일에도 자동으로 관련 코드가 생성됨

### 2 컴포넌트 트리
![image](https://user-images.githubusercontent.com/58967292/153999637-a4421db8-fbed-42a4-ab2e-b2d766e5af57.png)
* 레이아웃에는 계층 구조가 존재하는데, 컴포넌트 트리는 그 구조를 보기 좋게 보여준다

### 3 디자인 편집기
![image](https://user-images.githubusercontent.com/58967292/153998492-422b0e20-5e2d-4191-bdc9-c0c8e97c4891.png)
* 실질적으로 표현하고자 하는 레이아웃이 표현되는 곳(레이아웃 미리보기)
* 팔레트에서 뷰or 레이아웃을 드래그앤 드랍하여 이곳에 놓으면 레이아웃에 뷰가 추가된 것이 보인다
* 윗쪽의 툴바를 통해 미리보기 옵션을 조정할 수 있다.

![image](https://user-images.githubusercontent.com/58967292/153998739-c5a3080c-41d4-4598-bc7f-dff133b4ea16.png)

* 디자인&청사진: 편집기에서 레이아웃을 어떻게 표시할지 선택 => 사용자가 볼화면인 렌더링된 레이아웃을 보고싶다면 Design,  뷰의 윤곽선만 표시하고 싶다면 Blueprint, 둘다보고싶다면 Desing+BluePrint
* 화면 방향 및 레이아웃 변형: 화면을 세로방향으로 보고싶다면 Portrait, 가로방향으로 보고싶다면 LandScape*
* 데이/나이트 모드 선택: 데이/나이트 모드 별 레이아웃 확인 가능 
* 기기 유형 및 크기: 여러 유형의 기기중 선택된 기기에 대한 화면의 크기, 밀도와 같은 구성을 선택
* API버전: API 버전에 따라 레이아웃 형식이 달라진다. 해당 버전에 맞는 레이아웃을 선택할 때 사용
* 앱 테마: 미리보기 화면에 적용할 UI 테마를 선택, 지원되는 레이아웃에서만 쓰여서 레이아웃 디자인시 자주 사용되지는 않음
* 언어: UI 문자의 언어를 지정, LtoR, RtoL 언어가 존재하기 때문에(영어 한글은 LtoR) ,  Preview 기능을 통해  RtoL언어는 어떻게 표시되는지 확인 가능


### 4 속성창
![image](https://user-images.githubusercontent.com/58967292/153999851-b9bea4de-e884-45b8-ae76-3807f42671b9.png)
* 선택한 뷰의 여러 속성을 제어할 수 있는 영역

### 5 뷰모드
![image](https://user-images.githubusercontent.com/58967292/153999899-656a18b6-4fc7-4125-84c5-d4e85204af34.png)
* 레이아웃을 코드/디자인/분할 모드 중 하나로 표시함
* 분할모드는 코드창과 디자인창을 동시에 표시

## findViewByID

