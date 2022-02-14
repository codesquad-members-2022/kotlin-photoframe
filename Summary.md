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

### 👉 TextView의 기능