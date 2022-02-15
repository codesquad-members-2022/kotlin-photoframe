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
```Kotlin
    @Override
    public <T extends View> T findViewById(@IdRes int id) {
        return getDelegate().findViewById(id);
    }
```
* View를 상위 제한 타입으로 하는 제네릭 함수다 
* View를 상속받는 타입을 id를 통해 가져올수 있다. 
* 따라서 xml파일을 통해 UI를 구현할때 각 뷰(위젯)에 적절한 id를 부여하는 것이 중요하다. 

* textView 가져오기 
```Kotlin
val photoFrameTv = findViewById<TextView>(R.id.tv_photoframe)
```

## TextView 속성
### View
* 뷰는 앱에서 우리가 눈으로 볼 수 있는 모든 것 + 사용자와 상호작용하는 구성요소 
* 버튼,이미지,텍스트, 입력창 등..
* 뷰를 위젯이라도고 부른다
* 뷰의 종류에는 뷰 그룹도 있다. (뷰그룹역시 뷰다)
* 뷰 그룹은 뷰지만 레이아웃 역할을 하면 여러가지 뷰를 담거나 or 다른 뷰 그룹을 담는 역할을 한다 
![image](https://user-images.githubusercontent.com/58967292/154002340-10787649-c37d-4bc0-861f-22f22f2fed81.png)

* 뷰 그룹도 뷰라는 사실
![image](https://user-images.githubusercontent.com/58967292/154002468-85cc5d07-15d1-4fce-9e55-2b547cc54f84.png)

### View 공통 속성
### layout_width/height
* layout_width:  뷰 너비
* layout_height: 뷰 높이 
* width와 height에 쓰이는 대표적인 값 
 * match_parent: 해당 뷰를 담고 잇는 부모 레이아웃의 크기에 맞춤
 * wrap_content:  해당 뷰안에 들어가있는 내용에 크기를 자동으로 맞춤
 * 직접지정: xxxdp처럼 크기를 직접 지정 , layout_weight을 쓸경우 width와 height을 0dp로 선언

### dp
* Density-independent pixel의 줄임말
* 직역: 밀도(해상도)에 독립적이다
* 고상해도 기기의 경우 같은 면적에 픽셀이 촘좀하게 존재하며, 저사행도의 경우 느슨하게 존재한다
* px 단위로 이미지를 표현할 경우,  해상도가 다른 안드로이드 기기에서 다르게 보인다
* dp는 같은 크기로 보여주고만 만든 단위
* dp는 해상도별 픽셀값을 자동으로 조정해줌 => 개발자는 해상도를 고려하지 않고 dp를 사용하여 개발하면 됨

### 패딩과 마진
![image](https://user-images.githubusercontent.com/58967292/154003546-552f3178-f189-4536-a768-6f6e2db8d98a.png)
* Padding: 뷰안에 있는 내용과 뷰 외각사이의 여백
* Margin: 부모 레이아웃과 뷰사이의 간격
* layout_margin:  상하좌우
* layout_marginTop: 위
* layout_marginBottom: 아래
* layout_marginStart: 시작점
* layout_marginEnd:끝점
* layout_marginLeft: 왼쪽
* layout_marginHorizontal: 수평방향
* layout_marginVertical: 수직방향

* start/end 와 left/right 차이
 * LTR와 RTL 언어가 존재하기 때문에 존재
 * LTR과 RTL 미러링 기능을 지원하는 start-end를 쓰는것을 권장

### TextView 속성
![image](https://user-images.githubusercontent.com/58967292/154004855-771f4ce5-7168-407c-9446-970418a32583.png)
* 안드로이드 공식문서에서 텍스트 뷰를 살펴보았다 
* 엄청나게 많은 속성이 존재한다 . 따라서 자주 사용될 만할 속성만 살펴보았다. 

* text, textColor, textSize, textStyle 
* text: 텍스트 뷰에서 보여줄 글자를 지정,  직접 텍스트를 입력할수도 있고, string.xml에 선언할 문자열을 불러올수 도 있다(권장)
* textColor: 텍스트 색깔을 지정,  RGB코드를 직접 입력할수도 있고, Color.xml에 정의된 컬러를 불러올수도 있다. 
* textSize: 텍스트 크기를 지정,  숫자뒤 sp or dp붙인다.
* textStyle: 텍스트 스타일 지정 (bold,italic...) => 둘 이상의 스타일을 적용하고 싶다면 | 를 사용해서 열거하면 된다 ( textStyle뿐만 여러개 value를 허용하는 속성의 경우도 마찬가지)

### sp / dp
* scale independent pixel의 줄임말
* 안드로이드 설정 화면에서 사용자는 안드로이드 시스템 전체에서 보여지는 텍스트의 크기를 선택하여 설정할 수 있는데 SP는 해당 설정에 영향을 받는다.
* sp를 사용하고  설정에서 텍스트크기를 키우면 UI에 보이는 글자크기도 같이 커짐
* dp를 사용할경우 설정의 텍스트크기와 상관없이 일정 글자크기 유지

## findViewByID로 가져온 TextView 속성변경
### text 변경
* 가져온 textView.text로 직접 text 속성에 접근해서 변경가능
* textView.setText로 변경가능 => onCreate()에서 선언시 text속성에 직접 접근하는 방법으로 수정하라고 ide가 권함 

### TextColor 변경
* textView.setTextColor로 변경가능 
* setTextColor(Color.RED) 처럼 Color클래스에서 Color를 가져올수도있고
* setTextColor(Color.parseColor("#FF000000")); RGB 코드값으로 부터 컬러를 뽑아낼수도 있다
* setTextColor(Color.rgb(200,0,0)); 직접 RGB값 삽입으로 컬러 선택가능
* var color= ContextCompat.getColor(context, R.color.your_color)로 color.xml에 정의한 color를 가져와
* setTextColr(color)로 컬러 변경가능  

### TextSize 변경
* textView.setTextSize로 변경가능
* setTextSize(float size)으로 변경하면 scaled-pixel단위로 변경된다  = textView.textSize로 직접 접근해서 변경가능
* setTestSize(int unit, float size) => unit부분에 Dimension.SP or DP or PX 를 통해 단위 설정 가능 

### backgroundColor 변경
* textView.setBackgroundColor(Color color)로 변경가능
* Color에 대한것은 textColor와 똑같이 동작

## 3 버튼 추가하기
### 결과
![image](https://user-images.githubusercontent.com/58967292/154012713-86a99221-4b2d-4670-8401-071b45431ec2.png)

![image](https://user-images.githubusercontent.com/58967292/154012829-78373047-6090-4f3a-a753-6f6f78f9fc48.png)

### 학습 목표
* Button 이벤트 처리
* SnackBar vs Toast 

## Button 이벤트처리
### 입력 이벤트
* onClick(): 사용자가 (터치 모드에 있을 때) 항목을 터치하거나, 탐색 키 또는 트랙볼을 사용하여 해당 항목에 포커스를 맞추고 적절한 'Enter' 키를 누르거나, 트랙볼을 누르면 호출
* onLongClick(): 사용자가 (터치 모드에 있을 때) 항목을 길게 터치하거나, 탐색 키 또는 트랙볼을 사용하여 해당 항목에 포커스를 맞추고 적절한 'Enter' 키를 길게 누르거나 트랙볼을 길게 누르면(1초간) 호출
* onFocusChange(): 사용자가 탐색 키 또는 트랙볼을 사용하여 항목 쪽으로 이동하거나 항목에서 멀어지면 호출됩니다.
* onKey(): 사용자가 항목에 포커스를 맞추고 있으면서 기기에 있는 하드웨어 키를 누르거나 키에서 손을 떼면 호출됩니다.: 
* onTouch():  사용자가 터치 이벤트로서의 자격을 만족하는 작업을 수행하는 경우에 호출되며, 여기에는 누르기, 손 떼기와 화면에서 이루어지는 모든 움직임 동작(항목의 경계 내에서)이 포함됩니다.

### 이벤트처리
* 각 이벤트에 대해서 View에 eventListener를 등록해주어서 처리한다
* 이번 미션의 경우 Button과 setOnClickListener를 사용한다

```Kotlin
val addPhotoBtn = findViewById<Button>(R.id.btn_photoframe)
 addPhotoBtn.setOnClickListener{
   이벤트 처리
 }
 ```
 
 ### SnackBar
 ```Kotlin
 public class Snackbar extends BaseTransientBottomBar<Snackbar>
 ```
 * 사용방법은 간단하다  
 * SnackBar.make를 이용해 SnackBar를 생성
 * static make(View view, CharSequence text, int duration)
  * view: 뷰를 지정하여야 하며, Snackbar는 Snackbar를 화면에 보여줄 수 있도록 해당 view의 부모 view를 찾게 됩니다. 
  * text: 문자열을 집어넣으면 됩니다. or resId = 정수값의 id 이니, strings.xml의 id
  * duration: LENGTH_LONG, LENGTH_SHORT, LENGTH_INDEFINITE 세 종류 중 하나. LENGTH_INDEFINITE  무한으로 보여줘야 할 때 사용 + 8000처럼 직접 시간입력 가능 
 * SnackBar.show를 이용해 레이아웃에 표시

### SnackBar vs Toast
* 둘 다 간단한 메시지를 출려하는데 사용되는 뷰
* 차이점
 * duration 지정부분에서 toast의 경우, LENGTH_INDEFINITE 불가
 * toast와 달리 SnackBar는 setOnclick을 통해 사용자와 상호작용 가능 ( 이부분이 가장 큰 차이점이라 생각)
 * toast보다 snackbar가 좀 더 custom하게 사용하는데 유리하다

* 결론:  가능한 Toast보다는 SnackBar를 사용하라
* 추가:  Dialog에 관해서도 학습해보자

## 4단계 액티비티 전환
### 결과
![image](https://user-images.githubusercontent.com/58967292/154017351-e04b3317-e906-4132-9b46-402795cbc4f1.png)
![image](https://user-images.githubusercontent.com/58967292/154017517-446b0aea-ac12-4c5e-9330-7fe509c6a798.png)
![image](https://user-images.githubusercontent.com/58967292/154017550-af15b1cd-4ea2-451d-8cc4-d583c8cfc99f.png)
![image](https://user-images.githubusercontent.com/58967292/154017733-fe0ebe34-d212-4ca1-b290-d1c031814aab.png)

### 학습 목표
* 인덴트 + Activity는 화면 이동을 어떻게 관리하는지
*  AppCompatActivity
*  Activity 전환 시 Lifecycle이 어떻게 변화하는지 
