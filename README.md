## 코드스쿼드 Android Class Step1

### :one: 프로젝트 실행하기
- 자동 생성된 MainActivity 클래스 onCreate 함수에서 Log.d("MainActivity", "onCreate") 코드를 추가하고 실행하면 Logcat 영역에 무엇이 출력되는지 확인하기
<br>

![image](https://user-images.githubusercontent.com/69443895/153800037-b829be7e-6cb9-4e53-a642-33301fd2c1b4.png)
<br>

![image](https://user-images.githubusercontent.com/69443895/153828163-8fdd3406-49ad-4290-8ae3-39cea440cd6d.png)
- 앱을 실행시키고 overview 버튼을 눌러 앱에서 잠시 나간 상태에서 다시 앱으로 돌아온 후 종료하는 과정에서 호출되는 생명주기 콜백 함수의 순서를 로그캣 출력을 통해 알아보았다
- 홈 버튼, 뒤로 가기 버튼을 제외한 나머지 버튼을 overview 버튼이라고 부르는 것 같다 -> 현업에서는 어떻게 부를까..?
- https://android.stackexchange.com/questions/32697/what-is-the-offical-name-of-the-third-on-screen-button

<br>

### :two: TextView
- 버튼을 눌러 텍스트뷰의 속성을 변경하도록 구현
- setBackgroundColor & setBackgroundResource -> 둘 모두 인자를 사용해서 Drawable 객체 생성 후 이 객체로 setBackground를 호출한다
- 위 두개의 함수 결과는 동일

![image](https://user-images.githubusercontent.com/69443895/153925935-7bb22801-5757-4c25-9da6-8d8e95a1f9b3.png) ![image](https://user-images.githubusercontent.com/69443895/153926021-e79e695f-5893-41d6-bd9c-29c7ab7b9881.png)

- 버튼 클릭 시 텍스트 내용, 텍스트 색상, 텍스트 뷰 배경색을 변경
- 다시 버튼 클릭 시 기존 상태로 변경

<br>

### :three: Button
- '사진 추가' 버튼 클릭 시 스낵바가 나타나게 구현

![image](https://user-images.githubusercontent.com/69443895/153988206-b6701df1-d1ac-4092-afba-3faa88e7ccc5.png) ![image](https://user-images.githubusercontent.com/69443895/153988137-f6df45f4-1b16-4ef2-9bd2-12d3a3f5e132.png)

<br>

### :four: Activity 전환하기
- MainActivity 에서 '다음' 버튼을 통해 SecondActivity로 이동 후 뒤로가기를 눌러 다시 MainActivity로 돌아오는 과정에서 각 액티비티의 life cycle 콜백함수에서 로그를 출력했다

![image](https://user-images.githubusercontent.com/69443895/154012788-2879a179-e724-4334-b7d6-d3531674822b.png)

<br>

### :five: Activity 전환 후 결과 가져오기
- startActivityForResult 는 현재 Deprecated되어 있는 상태다
- 이유를 살펴보자면, 다음과 같다
  + AndroidX Activity와 Fragment에 도입된 Activity Result API 사용을 적극 권장.
  + 결과를 얻는 Activity를 실행하는 로직을 사용할 때, 메모리 부족으로 인해 프로세스와 Activity가 사라질 수 있다. (특히 카메라 같은 메모리를 많이 사용하는 작업은 소멸 확률이 굉장히 높다.)
<br>

- 이를 위해 registerForActivityResult 를 사용하도록 권장하고 있다
- Activity Result API에서 제공하는 registerForActivityResult() API를 통해 결과 콜백을 등록할 수 있습니다  -공식문서-
<br>

- SecondActivity에서 '닫기' 버튼을 눌러 액티비티를 종료하는 과정에서 문자열 데이터도 같이 넘겨주도록 구현
- 토스트 메시지를 사용했고 기존 토스트 메시지에서는 아이콘이 없었지만 Android 12 부터는 아이콘이 같이 출력되는 것 같다
(앱이 Android 12(API 수준 31) 이상을 타겟팅한다면 토스트 메시지는 텍스트 두 줄로 제한되고 텍스트 옆에 애플리케이션 아이콘이 표시됩니다
- 공식문서 -)

![image](https://user-images.githubusercontent.com/69443895/154044524-49f69f96-7f19-4795-8d0f-ea56f15d7574.png) ![image](https://user-images.githubusercontent.com/69443895/154044644-67f121d8-f139-48d9-b121-d8c35af0d4c8.png)

![image](https://user-images.githubusercontent.com/69443895/154044841-46965a36-59ab-47cb-8a74-8c5b3cfc6e2a.png)

<br>

## 토스트 메시지 사용의 대안
앱이 포그라운드에 있다면 토스트 메시지 대신 [스낵바](https://material.io/components/snackbars)를 사용하는 것이 좋습니다. 스낵바에는 사용자가 실행할 수 있는 옵션이 포함되어 있으며 이를 통해 더 나은 앱 환경을 제공할 수 있습니다.
(https://developer.android.com/guide/topics/ui/notifiers/toasts?hl=ko)


