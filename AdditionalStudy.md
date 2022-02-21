# 🙋‍♂️학습 정리

### 👉 안드로이드 에뮬레이터란?
- Android Emulator는 컴퓨터에서 Android 기기를 시뮬레이션함으로써 실제로 기기가 없어도 다양한 기기 및 Android API 수준에서 애플리케이션을 테스트할 수 있도록 도와주는 작업 도구

#### 🔖 AVD란?
- Android Virtual Device(AVD)는 Android Emulator에서 시뮬레이션하려는 Android 스마트폰이나 태블릿, Wear OS, Android TV, Automotive OS 기기의 특성을 정의하는 구성 도구
- [AVD사용자가이드](https://developer.android.com/studio/run/managing-avds?hl=ko)

### 👉 Logcat의 역할
- `import android.util.Log` 해야함
- Android 스튜디오의 Logcat 창에는 시스템 메시지(예: 가비지 컬렉션 발생)와 Log 클래스를 사용하여 앱에 추가한 메시지가 표시됩니다.
- Log 클래스를 사용하여 logcat에 표시되는 로그 메시지를 만들 수 있습니다. 일반적으로 다음과 같은 로그 메서드를 사용해야 하며, 우선순위가 가장 높은 것부터(또는 상세 수준이 가장 낮은 것부터) 순서대로 나열되어 있습니다. 
  - Log.e(String, String) (오류)
  - Log.w(String, String) (경고)
  - Log.i(String, String) (정보)
  - Log.d(String, String) (디버그)
  - Log.v(String, String) (상세)

### 👉 Activity
#### 🔖 Activity란?
- Activity은 Android 플랫폼에서 앱을 구성하는 기본 요소 중 하나입니다. Activity은 `사용자가 앱과 상호작용하기 위한 진입점 역할`을 하며 사용자가 앱 내에서(뒤로 버튼으로) 탐색하거나 앱 간에(최근 버튼으로) 이동하는 방법의 중심이기도 합니다.
- 코틀린은 시작점이 fun main() 함수지만, Android 앱의 경우 onCreat()가 시작점이라 볼 수 있다.
- [참고](https://developer.android.com/guide/components/activities)
- [참고](https://developer.android.com/guide/components/activities/intro-activities)
#### 🔖 Activity Lifecycle
![생명주기](https://user-images.githubusercontent.com/95393311/153831069-a715ad2f-2ad5-4d18-9a3f-047792f67f24.JPG)
- Activity은 수명 주기 전체 기간(Lifecycle)에 걸쳐 여러 상태를 거칩니다. 상태 간 전환을 처리하는 데 일련의 콜백을 사용할 수 있습니다.
- 각 액티비티는 콜백 함수를 통해 새로운 상태로 들어가게 됩니다.
- [참고1](https://developer.android.com/guide/components/activities/activity-lifecycle
#### 🔖 Activity Lifecycle이 변경되는 걸 아는 방법
- Lifecycle-Aware Components 를 활용하면 됨
- `DefaultLifecycleObserver`
- [DefaultLifecycleObserver](https://developer.android.com/reference/androidx/lifecycle/DefaultLifecycleObserver))
- [참고2](https://developer.android.com/topic/libraries/architecture/lifecycle)

#### 👉 Text Editor
- Text Editor에서 직접 사이즈나 색깔 텍스트 크기 등을 조절한다면??
![7](https://user-images.githubusercontent.com/95393311/153999351-747702d7-9c05-449b-a70f-d9a90695eadc.JPG)
- `value` 파일 아래의 xml 파일에서 `resource` tag에 코드가 자동으로 생성되는 점을 확인함 

### 👉 TextView의 기능
- A user interface element that displays text to the user. 
- 자세한 설명은 공식사이트로 대체
  - [TextView](https://developer.android.com/reference/android/widget/TextView?hl=en#summary)
  - 텍스트 입력 및 수정을 위한 인터페이스 [EditText](https://developer.android.com/reference/android/widget/EditText)
  - TextView의 룩앤쀨을 커스텀마이징하기 위해서는? [Styles and Themes](https://developer.android.com/guide/topics/ui/look-and-feel/themes)
  
### 👉 Button 의 이벤트 종류

### 👉 사용자에게 피드백 주는 방법
- 사용자에게 피드백을 주는 방식에는 크게 스낵바, 토스트, 알림이 있다
- 스낵바
  - Snackbars provide lightweight feedback about an operation.
  - Snackbars can contain an action
  - 앱이 foreground 상태이면 특정 액션 옵션을 포함할 수 있는 스낵바를 추천
- Toast
  - 앱이 background 상태이며, 특정 액션을 취하지 않아도 될때에는 Toast를 추천
- Notification
  - 앱이 background 상태이고 사용자에게 특정 액션 옵션을 주고 싶다면 notification을 추천
  1. [스낵바](https://material.io/components/snackbars/android#using-snackbars)
  2. [Toast](https://developer.android.com/guide/topics/ui/notifiers/toasts?hl=ko#kotlin)
  3. [알림](https://developer.android.com/guide/topics/ui/notifiers/notifications?hl=ko)
### 👉 AppCompatActivity 란?

### 👉 App 전환 시 Lifecycle 변화
```
Coordinating activities
When one activity starts another, they both experience lifecycle transitions. The first activity stops operating and enters the Paused or Stopped state, while the other activity is created. In case these activities share data saved to disc or elsewhere, it's important to understand that the first activity is not completely stopped before the second one is created. Rather, the process of starting the second one overlaps with the process of stopping the first one.

The order of lifecycle callbacks is well defined, particularly when the two activities are in the same process (app) and one is starting the other. Here's the order of operations that occur when Activity A starts Activity B:

1. Activity A's onPause() method executes.
2. Activity B's onCreate(), onStart(), and onResume() methods execute in sequence. (Activity B now has user focus.)
3. Then, if Activity A is no longer visible on screen, its onStop() method executes.

This predictable sequence of lifecycle callbacks allows you to manage the transition of information from one activity to another.
```
- [공식문서](https://developer.android.com/guide/components/activities/activity-lifecycle.html#soafa) 에서 발췌한 글이며, 쉽게 얘기해 다른 액티비티가 만들어지기 전에 첫번째 액티비티가 완전히 정지되지 않는다는 것이다
  ![12](https://user-images.githubusercontent.com/95393311/154180273-91c9168b-4803-4962-a347-84abca5e6daa.JPG)
### 👉 Activity는 화면 이동을 어떻게 관리?





### 👉 Floating 버튼 추가
1. [플로팅 작업 버튼 추가](https://developer.android.com/guide/topics/ui/floating-action-button)
