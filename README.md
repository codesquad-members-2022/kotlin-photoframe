# 안드로이드 1주차

## Kotlin-photoframe

---

### 프로젝트 실행하기

- [x] 자동 생성된 MainActivity 클래스 onCreate 함수에서 `Log.d("MainActivity", "onCreate")` 코드를 추가하고 실행하면 Logcat 영역에 무엇이 출력되는지 확인한다.

<img width="1178" alt="로그기록" src="https://user-images.githubusercontent.com/29175138/153791685-2585205f-bdf6-48c8-961f-837d7c4c216c.png">

---

### TextView 구현하기

- [x] activity_main.xml에 TextView를 추가한다.
  - [x] Design editor의 기능을 모두 활용해본다.
    - text 내용, 글자색 변경 테스트

- [x] MainActivity에서 TextView에 대한 참조를 얻어 text를 변경한다.
  - [x] findViewById를 활용한다.
  - [x] onCreate 함수에서 text를 변경한다.
  - [x] TextView의 글자색, 배경색, 글자 크기를 변경해본다.

![TextView 구현하기](https://user-images.githubusercontent.com/29175138/153821908-12d4c352-d076-42b5-aca2-4b8e5afa44a0.png)

---

### Button 구현하기

- [x] activity_main.xml에 Button을 추가한다.
- [x] MainActivity에서 Button에 대한 참조를 얻는다.
- [x] Button을 클릭하면 '사진을 불러옵니다' 메시지를 띄운다.
  - [x] Button 클릭 이벤트에 대한 알림을 받아 처리한다.
  - [x] Snackbar를 활용한다.

- 버튼클릭 전

![버튼클릭 전](https://user-images.githubusercontent.com/29175138/153829065-2382f8bc-0f80-4205-b841-7c0ef75bc161.png)

- 버튼클릭 후

![버튼클릭 후](https://user-images.githubusercontent.com/29175138/153829035-8dc1b882-ca99-45b0-af45-1c6beab2d9c3.png)

---

### 다른 Activity로 이동하기

- [x] MainActivity에서 이동할 두번째 Activity를 추가한다.
  - [x] 두번째 Activity의 배경색상을 변경한다.
  - [x] AndroidManifest에 등록한다.
- [x] Activity Lifecycle의 모든 callback에 로그를 출력한다.
  - [x] `Log.d("$activityName", "$callbackName")`
- [x] MainActivity의 버튼 텍스트를 '다음'으로 변경하고, 클릭하면 두번째 Activity로 이동시킨다.
- [x] 두번째 Activity에 '닫기' 버튼을 추가하고, 클릭 시 다시 MainActivity로 이동시킨다.
  - [x] 이 때, MainActivity에 '사진을 불러왔습니다'라는 메시지를 띄운다.
  
#### Lifecycle 로그 확인

- 사용한 Logcat 필터

  - ![스크린샷 2022-02-14 오후 8 29 32](https://user-images.githubusercontent.com/29175138/153856349-8e46bd84-751b-414d-af1a-9e150fe02f91.png)

```text
2022-02-14 20:25:52.474 9407-9407/com.codesquad.kotlinphotoframe D/MainActivity: onCreate
2022-02-14 20:25:52.498 9407-9407/com.codesquad.kotlinphotoframe D/MainActivity: onStart
2022-02-14 20:25:52.504 9407-9407/com.codesquad.kotlinphotoframe D/MainActivity: onResume
2022-02-14 20:25:59.647 9407-9407/com.codesquad.kotlinphotoframe D/MainActivity: onPause
2022-02-14 20:25:59.835 9407-9407/com.codesquad.kotlinphotoframe D/PhotoActivity: onCreate
2022-02-14 20:25:59.984 9407-9407/com.codesquad.kotlinphotoframe D/PhotoActivity: onStart
2022-02-14 20:25:59.987 9407-9407/com.codesquad.kotlinphotoframe D/PhotoActivity: onResume
2022-02-14 20:26:00.878 9407-9407/com.codesquad.kotlinphotoframe D/MainActivity: onStop
2022-02-14 20:26:05.194 9407-9407/com.codesquad.kotlinphotoframe D/PhotoActivity: onPause
2022-02-14 20:26:05.253 9407-9407/com.codesquad.kotlinphotoframe D/MainActivity: onRestart
2022-02-14 20:26:05.255 9407-9407/com.codesquad.kotlinphotoframe D/MainActivity: onStart
2022-02-14 20:26:05.274 9407-9407/com.codesquad.kotlinphotoframe D/MainActivity: onResume
2022-02-14 20:26:06.276 9407-9407/com.codesquad.kotlinphotoframe D/PhotoActivity: onStop
2022-02-14 20:26:06.290 9407-9407/com.codesquad.kotlinphotoframe D/PhotoActivity: onDestroy
```

- 실행화면
  
  - ![Screenshot_1644838744](https://user-images.githubusercontent.com/29175138/153857735-16194529-e792-4980-a6e4-febbc6a8afe5.png)
  
---


#### 추가 학습거리 정리
- Activity에 대해서 학습한다.
  - **용어정리**
    - **View**
      - 유저 인터페이스 컴포넌트로서, 화면에 컨트롤(TextView, Button 등)을 그리고 이벤트를 핸들링하는 책임을 가지고 있다.
      - `Any` 클래스를 상속받고 있는 클래스이며 `위젯`이라고도 한다.
      - `View`들은 모두 코드로 작성하거나 XML을 이용해 구현한다.

    - **ViewGroup**
      - `ViewGroup`이라는 layout을 담당하는 클래스에는 `View` 또는 `ViewGroup`을 가질 수 있다.
      - 이런 `ViewGroup`들은 눈에 보이지는 않지만, layout들의 속성(배경색, margin 등)을 정의해 표현할 수 있다.
      - layout은 다음과 같은 구조를 가지고 있다.

        ![viewgroup_2x](https://user-images.githubusercontent.com/29175138/153980151-a47e358c-769e-4caf-86b1-a09ff14a3ac5.png)

    - **백 스택**
      - 화면을 전환되어 새로운 액티비티(B)가 실행되면 현재 실행되고 있던 액티비티(A)는 **백 스택**에 push되고 새로운 액티비티(B)가 이전 액티비티(A)에 push된 후 화면에 표현된다.
      - 뒤로가기 버튼 클릭 시 가장 위에 있는 새로운 액티비티(B)가 pop 되어 스택에서 사라짐과 동시에 액티비티(B) 또한 종료되고, 현재 가장 위에 있는 액티비티(A)가 다시 화면에 표현된다.


  - 대부분의 액티비티들은 사용자와 상호 작용하며, `setContentView(View)` 함수를 이용해 UI를 생성한다.
    - `setContentView` 함수는 매개변수로 3가지를 전달받는다.
      - View
      - View, LayoutParam
      - layoutResID
        - 내부적으로 LayoutInflater의 inflate 메소드를 이용해 XML로 작성된 layout의 내용을 파싱해 액티비티 화면을 구성한다.

  - 여러개의 액티비티들이 모여 하나의 앱을 구성한다.
  - 앱을 시작할 때 항상 같은 화면에서 시작되지 않는다. 즉, 앱은 다른 프로그래밍 언어들의 main()과 같은 시작점이 존재하지 않는다.
    - 단지 기본으로 설정되는 액티비티가 있으며 이 액티비티는 앱을 종료하고 다시 실행할 때 표시된다.
    - 알림창에 있는 카카오톡 메시지를 클릭하면 앱의 기본 화면이 아닌 메시지 화면으로 넘어가는 것
  - 현재 액티비티에서 다른 앱의 액티비티를 실행할 수 있다.
    - 카카오톡의 프로필 사진 변경 액티비티에서 사진첩의 특정 액티비티를 실행해 사진을 등록하는 것

- **Lifecycle은 무엇인가?**
  - 액티비티의 생성부터 소멸까지의 과정을 가리키는 것으로, 생명 주기 라고도 한다.
  - Lifecycle에는 기본적으로 4개의 상태가 존재한다.
    1. **active(활성 상태)**
      - 화면이 보여지고 있는 상태로, 보통 사용자들과 상호 작용 하는 화면이다.
      - 백 스택에서 가장 최상위에 있는 액티비티를 의미한다.

    2. visible(보이는 상태)
      - 액티비티에 대한 포커스는 잃었지만 볼 수 있는 상태이다.
  
        ![Android-Split-Screen-New-AH](https://user-images.githubusercontent.com/29175138/153993692-78e62a89-3340-4c97-9eaf-ccdf790acfc8.jpeg)
  
      - 위 사진에서 왼쪽 계산기를 이용할 경우 오른쪽의 인터넷은 포커스를 잃었지만 볼 수 있다.

    3. **stopped(정지 상태)**
      - 다른 액티비티에 완전히 가려져 있는 상태로, 현재 액티비티에 대한 상태나 정보는 남아있지만 더이상 사용자에게 보여지지 않으며 언젠가 시스템에서 메모리 확보를 위해 액티비티를 소멸시킬 수 있다.
      - 정지 상태에서 다시 활성화가 되면 `onStart` 콜백 함수에서 저장되었던 상태나 정보를 다시 불러와 복원시킨다.

    4. **destroy(소멸 상태)**
      - 액티비티가 완전히 종료되어 메모리에서 삭제되는 것을 말하는 것으로, 사용자가 다시 액티비티를 사용하기 위해서는 재시작해야 한다.

  - 이 과정은 총 6단계로 된 콜백 함수로 관리된다.
    1. **onCreate**
      - 액티비티가 처음 실행될 때 발생하는 콜백 함수로, 전체 Life Cycle 중 한 번만 실행되어야 한다.
      - 데이터를 바인딩하거나 뷰(View)를 연결하는 등의 액티비티 초기 설정을 할 때 사용된다.
      - `setContentView`함수를 실행하면 레이아웃을 구성하고 있는 XML또는 View를 파싱해 UI를 구성한다.
      - 이 콜백 함수는 이전 상태 정보를 저장하는 `savedInstanceState` 매개변수를 받는데, 이 매개변수는 앱이 중지된 상태이거나 기타 이유(시스템에서 메모리 관리를 위해 중지된 앱을 소멸시키는 등)에 의해 비정상적으로 종료됐을 경우 앱을 재실행할 때 종료되기 이전 상태로 되돌리기 위한 매개변수이다.
        - `onStop` 콜백에서 상태가 저장되며, `onSaveInstanceState`함수를 이용한다.
        - `onStart` 콜백에서 상태를 복구하며, `onRestoreInstanceState`함수를 이용한다.

    2. **onStart**
      - 액티비티가 시작되면 안드로이드 시스템은 이 콜백 함수를 호출한다.
      - foreground에 액티비티를 보내 사용자와 상호 작용 할 수 있도록 준비한다.

    3. **onResume**
      - 액티비티가 Resume 상태가 되면 액티비티를 화면에 표현되며 이 상태에서 앱과 사용자가 서로 상호 작용한다.
      - 어떤 이벤트가 발생해 포커스를 잃기 전까지 이 상태(Resume)에 머무르며 만약 홈으로 나가거나 다른 액티비티로 전환할 경우 일시중지 상태에 들어가게 된다.

    4. **onPause**
      - 사용자가 현재 액티비티를 떠나는 첫 번째 신호로 이 메서드를 호출한다. 떠난다는 것은 foreground에서 보이지 않는다는 것을 의미하나, 경우에 따라(멀티 윈도우 등)에서는 여전히 표시될 수 있다.
      - 멀티 윈도우 환경일 때는 onPause가 되더라도 보이는 상태일 수 있기 때문에 UI관련 리소스를 해제하기 위해서는 onStop을 사용하는 것이 좋다.

    5. **onStop**
      - 액티비티를 사용자가 더 이상 볼 수 없거나 사용할 수 없으면 중단된 상태에 들어가며 이 콜백 함수를 실행한다.
      - onStop에 UI 관련 작업을 작성한다면 멀티 윈도우 모드에서도 UI 갱신이 가능하다.

    6. **onDestroy**
      - 액티비티가 소멸되기 전 호출되는 함수로 아래 두 가지 경우 중 하나일 때 이 콜백 함수를 호출한다.
        1. 사용자가 앱을 완전히 종료 (finish 호출)한 경우
        2. 시스템이 일시적으로 액티비티를 소멸시키는 경우

    - 이 과정을 그림으로 나타내면 아래와 같다.

      ![activity_lifecycle](https://user-images.githubusercontent.com/29175138/153997584-a3a4b8fe-33ab-4cac-b502-bac6ca801ab2.png)

  - 위 6단계를 다시 아래와 같이 구분할 수 있다.
    1. **전체 수명 (entire lifetime)**
      - `onCreate`와 `onDestroy`함수 사이를 의미하며 `onCreate`에서 상태나 리소스등을 생성하고 `onDestroy`에서 모든걸 해제한다.
      - 앱의 실행과 종료를 뜻한다.

    2. **가시 수명 (visible lifetime)**
      - `onStart`와 `onStop`함수 사이를 의미하며 액티비티를 볼 수 있는 상태를 의미한다.
      - 실제로 아래와 같이 액티비티는 종료되지 않았지만 볼 수만 있는 상태에서는 `onStop`함수가 호출된다.
  
        ![Screenshot_1644902190](https://user-images.githubusercontent.com/29175138/153997214-799a96f0-fa1c-458a-83f2-453045bf4501.png)

    3. **전경 수명 (foreground lifetime)**
      - `onResume`과 `onPause`함수 사이를 의미하며 액티비티를 볼 수 있고 사용자와 상호 작용이 가능한 상태를 의미한다.
  
- **Lifecycle이 변경되었음은 어떻게 알 수 있는가?**
  - 상태가 변경되면 시스템에서 변경된 상태에 맞게 콜백 함수를 호출한다.
  
---


- **Button이 알림을 받을 수 있는 Event 종류를 학습한다.**
  - Button 뿐 아니라 레이아웃을 구성하는데 필요한 View 객체로부터 이벤트 리스너를 `override` 해 구현할 수 있다.
    - override 할 때는 `setOnXXXX` 형식으로 할 수 있다.
  - View 클래스에서 제공하는 UI관련 이벤트 리스너는 아래와 같다.
    1. `OnClickListener`
      - 사용자가 해당 View를 클릭 또는 터치했을 때 발생하는 이벤트
    2. `OnLongClickListener`
      - 사용자가 해당 View를 1초간 클릭 또는 터치했을 때 발생하는 이벤트
    3. `OnFocusChangeListener`
      - 해당 View에 포커스가 발생한 경우 발생하는 이벤트
    4. `OnKeyListener`
      - 사용자가 해당 View에 포커스를 맞춘 상태에서 하드웨어 키를 누르거나 키에서 손을 떼면 발생하는 이벤트
    5. `OnTouchListener`
      - 사용자가 해당 View에 터치할 경우 발생하는 이벤트

- **Snackbar와 Toast 용도 비교 및 활용**
  - **Toast**
    - 작은 팝업으로 작업에 관한 간단한 피드백을 제공
    - 토스트 메시지가 표시된 후 일정시간 이후 자동으로 사라짐
    - 단, API 31이상에서는 텍스트가 2줄로 제한되고 애플리케이션 아이콘이 함께 표현됨

      ![Screenshot_1645009570](https://user-images.githubusercontent.com/29175138/154252156-4d1945a0-faaf-4257-9bf7-da5e690999ab.png)

  - **Snackbar**
    - Toast와 동일하게 화면 아래쪽에 메시지가 표시된 후 일정시간 이후에 자동으로 사라짐
    - Toast와의 차이점은 Snackbar는 사용자가 실행할 수 있는 옵션이 포함되어 있다.
    - 아래와 같이 활용할 수 있다.

      ![Screenshot_1645009781](https://user-images.githubusercontent.com/29175138/154252755-b69f6bbf-0b5c-4b75-beed-ce5becd740da.png)

