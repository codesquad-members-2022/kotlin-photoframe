## Step 01

### 작업 목록

- [x] Logcat 활용하기
- [x] Logcat 영역에 무엇이 출력되는지 확인

### 동작 결과
<img width="800" alt="스크린샷 2022-02-14 오후 2 59 47" src="https://user-images.githubusercontent.com/79504043/153829455-071f1155-f6d6-4a8e-9f7c-2d9b621a60e3.png">

## 추가 학습 정리
### Activity LifeCycle
**onCreate**
- 액티비티를 새로 생성하면 클래스 안에 onCreate가 자동으로 생성되어 있는 것을 볼 수 있다.
- 그 말은 반드시 구현해야 하는 메서드
- onCreate는 액티비티가 생성되면 가장 먼저 실행되는 메서드
- 화면 레이아웃 정의, 뷰를 생성하거나 데이터 바인딩 등을 이곳에서 수행한다.
- 생명 주기 동안 딱 한 번만 실행되는 메서드
- 액티비티 최초 실행 시에만 해야 할 작업을 수행한다.

**onStart**
- 액티비티가 화면에 표시되기 직전에 호출
- 화면에 진입할 때마다 실행되어야 하는 코드를 이곳에 작성한다.

**onResume**
- 잠시 액티비티가 일시정지 되었다가 **돌아오는 경우** onResume 메서드가 호출 (Ex : 다른 액티비티가 액티비티를 덮어버리거나 앱 사용 중 전화가 와서 잠시 앱을 떠나는 경우)
- 만약 액티비티가 재개되었을 때 실행해야 할 코드가 있다면 이곳에 작성하면 된다.

참고 사항
> Regardless of which build-up event you choose to perform an initialization operation in, make sure to use the corresponding lifecycle event to release the resource. If you initialize something after the ON_START event, release or terminate it after the ON_STOP event. If you initialize after the ON_RESUME event, release after the ON_PAUSE event.

공식문서에 다음과 같이 적혀 있는 것을 확인할 수 있는데 이를 해석해 보면,
- onStart에서 초기화 작업을 했다면 -> onStop에서 리소스 해제 / 종료 작업
- onResume에서 초기화 작업을 했다면 -> onPause에서 리소스 해제 / 종료 작업

라고 명시 돼 있다.

**onPause**
- 쉽게 말해 방해되는 이벤트가 발생하면 이 메서드가 호출
- foreground 에 있지 않을 때 실행할 필요가 없는 기능들을 onPause에서 일시 정지

주의 사항
> onPause() execution is very brief, and does not necessarily afford enough time to perform save operations. For this reason, you should not use onPause() to save application or user data, make network calls, or execute database transactions; such work may not complete before the method completes.

공식문서 페이지에서 onPause는 아주 잠깐 실행되는 메서드이므로 데이터를 저장하거나, 네트워크를 호출하는 등 무거운 작업을 하면 안 된다고 경고한다.

왜냐하면 말 그대로 잠깐 실행 되기 때문에 메서드가 완료되는 시점에 작업이 끝나지 않았을 수 있기 때문이다.

**onStop**
- 액티비티가 사용자에게 더 이상 보이지 않으면 이 메서드가 호출된다.
- 무거운 작업이 이곳에서 수행된다.

**onRestart**
- 홈으로 나갔다가 다시 돌아오거나 다른 액티비티로 갔다가 뒤로 가기 버튼을 통해서 돌아오는 경우 이 메서드가 호출된다.

**onDestroy**
- 앱이 완전히 종료하는 경우 호출된다.

<br>
<br/>

---

## Step 02

### 작업 목록

- [x] activity_main.xml에 TextView를 추가
- [x] MainActivity에서 TextView에 대한 참조를 얻어 text를 변경
- [x] TextView의 글자색, 배경색, 글자 크기, 글꼴 등을 변경

### 동작 결과

<img width="500" alt="스크린샷 2022-02-14 오후 2 59 47" src="https://user-images.githubusercontent.com/79504043/153830133-f6809636-5fd8-4f55-9df5-70308839ce8c.png">


## 추가 학습 정리
### TextView 의 속성
**android:text**
- text는 TextView의 내용
- 텍스트 뷰에 표현할 텍스트를 여기에 넣어준다.
- 텍스트가 너무 길다면 res/value/strings.xml에 적어둔 리소스 값을 활용

**android:textStyle**
- 문자열 기본적인 효과에 대한 것으로, normal, bold, italic 중 하나를 선택해서 일반, 굵게, 기울이기 형태로 텍스트를 표현

**android:textColor**
- 문자열의 폰트 색을 지정한다.
- #FF0000처럼 16진수 RGB 포맷을 이용

**android:textSize**
- 폰트 크기를 지정합니다.

**android:maxLines**
- 화면에 표시될 최대 줄 수를 의미한다.




<br>
<br/>

---

## Step 03

### 작업 목록

- [x] activity_main.xml에 Button을 추가
- [x] MainActivity에서 Button에 대한 참조 얻기
- [x] Snackbar를 활용

### 동작 결과
[동작 영상](https://user-images.githubusercontent.com/79504043/153856296-fe363a1d-8a1b-49f5-8688-aef93cd648c5.mp4)


### 추가 학습 정리
**이벤트 리스너의 종류**

| 이벤트 리스너의 메소드  | 이벤트 발생 시점  |
|:----------|:----------|
| onClick()    | 뷰를 클릭할 때 (대표 사례: Button)|
| onLongClick()| C뷰를 길게 클릭할 때 |
| onFocusChange() | 포커스가 한 뷰에서 다른 뷰로 바뀔 때   |
| onKey()    | 키를 누르거나 뗄 때 |
| onTouch() | 사용자가 화면에 뷰를 터치할 때 (손을 댈 때, 댄 채로 움직일 때, 뗄 때 모두 포함) |
| onCreateContextMenu() | 컨텍스트 메뉴가 생성될 때|

<br>
<br/>


## Step 04

### 작업 목록

- [x] MainActivity에서 이동할 두번째 Activity를 추가한다.
    - [x] 두번째 Activity의 배경색상을 변경한다.
    - [x] AndroidManifest에 등록한다.
- [x] Activity Lifecycle의 모든 callback에 로그를 출력한다.
- [x] MainActivity의 버튼 텍스트를 '다음'으로 변경하고, 클릭하면 두번째 Activity로 이동시킨다.
- [x] 두번째 Activity에 '닫기' 버튼을 추가하고, 클릭 시 다시 MainActivity로 이동시킨다.
    - [x] 이 때, MainActivity에 '사진을 불러왔습니다'라는 메시지를 띄운다.

### 동작 결과
[동작 영상](https://user-images.githubusercontent.com/79504043/154179634-7b0a3a46-d64e-4bff-a090-28db207eddbb.mp4)

### 추가 학습 벙리

- 일반적으로 액티비티를 선언할 때, Activity를 상속받아서 작성
- Activity는 종류가 여러가지 존재

<img width="300" alt="스크린샷 2022-02-18 오전 10 05 04" src="https://user-images.githubusercontent.com/79504043/154597768-b56b5e5c-fcc8-48a0-9cc9-94e1241f9dfe.png">

- AppCompatActivity 클래스는 안드로이드의 하위버전을 지원하는 액티비티
- ActionBar는 최신버전에서 지원하지 않는다. 하지만 AppCompatActivity 클래스를 사용하면 액션바를 동작할 수 있다.



<br>
<br/>


## Step 05

### 작업 목록

- [x] '다음' 버튼 클릭 시, 다운로드 받은 이미지 01~22까지 랜덤으로 숫자를 선택해서 ImageView에 표시
- [x] ImageView의 scaleType 속성을 활용해 이미지를 표시하는 방법을 결정
- [x] ImageView ~ Button까지 제약조건을 추가해 ConstraintLayout의 중앙에 정렬

### 동작 결과
[동작 영상](https://user-images.githubusercontent.com/79504043/154248484-090c10d4-1033-4c6e-a82b-7de0b0444c64.mp4)

### 추가 학습 정리
** ConstraintLayout**
- ConstraintLayout은 위젯을 유연한 방식으로 배치하고 크기를 조정할 수 있는 ViewGroup
- 다양한 종류의 제약사항들을 사용할 수 있다.
-  ( Relative positioning, Margins, Centering positioning, Circular positioning, Visibility behavior, Dimension constraints, Chains, Virtual Helpers objects, Optimizer )

**ImageView**
- 비트맵 (BitMap) 또는 드로어블(Drawable) 리소스 같은 이미지 리소스를 그리는 뷰(View)
- mageView 클래스는 TextView와 마찬가지로 android.view.View 클래스로부터 상속되었기 때문에, View 클래스에서 제공하는 기능과 속성을 그대로 사용할 수 있다.
- ImageView에 표시할 수 있는 이미지 파일의 종류는 여러 가지가 있지만, png 또는 jpg 형식의 파일이 가장 많이 사용된다.
- 이미지 파일(png, jpg)을 Drawable 리소스에 추가하기 위해서 현재 작업 중인 프로젝트의 소스 아래 "/res/drawable/" 디렉토리에 이미지 파일을 복사한다.
- 추가한 이미지 파일을 화면에 표시하기 위해, ImageView를 Layout 리소스 XML 파일에 추가하고, "src" 속성에 이미지(Drawable)의 리소스 ID를 지정한다.
- 외에도 android:maxWidth, android:baseline, android:tint 등 여러 xml 속성을 지원한다.


<br>
<br/>


## Step 06

### 작업 목록

- [x] 액자 이미지를 화면에 추가
- [x] 갤러리에 저장한 사진을 가져와서 보여줄 수 있도록 구현

### 동작 결과
[동작 영상](https://user-images.githubusercontent.com/79504043/154602967-a3719994-2740-4327-83fd-a7d5707aee1d.mp4)

### 추가 학습 정리
- callback for an Activity Result 즉 Activity Result 를 콜백으로 호출하는 기능을 했던 startActivityForResult(), onActivityResult() 가 deprecated 되었다.
- 새로운 방법인 registerForActivityResult 는 인자로 ActivityResultContracts 클래스의 Static 함수를 넣는다. 이때 Result 를 받기 위해 Activity 를 싱행하는 StartActivityForResult 를 넣고 람다식에 result로 받아온 값을 어떻게 사용할 지 정의해준다.
- 인자로 받아온 result 객체에서 resultCode를 이용해 RESULT_OK 인지 확인해 주고 it.data 를 이용해 보내온 Intent Data 를 이용할 수 있다.

이 외에도 여러 ActivityResultContracts 클래스의 Static 함수들이 존재한다.

<img width="600" alt="스크린샷 2022-02-18 오전 11 08 36" src="https://user-images.githubusercontent.com/79504043/154604163-37b9badc-5f47-41e7-a2c2-e861d4cbdb54.png">


--- 
