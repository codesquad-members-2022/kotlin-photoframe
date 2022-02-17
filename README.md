# 👉 첫번째 미션
#### 1. 🔖 Android Emulator에서 앱 실행하기
- Android 스튜디오 설치
- Tools - Android - AVD manager 열기
- AVD 생성하기
  ![1](https://user-images.githubusercontent.com/95393311/153788727-3668186b-be41-4dc3-b022-74a43d340b4f.JPG)  
   > <AVD 생성 완료>

  ![1 5](https://user-images.githubusercontent.com/95393311/153788758-e4af3e29-4c94-4d94-aa82-eb0f17cf70c0.JPG)  
   > <AVD 실행>

  ![2](https://user-images.githubusercontent.com/95393311/153788876-954910fb-31ad-4270-a6fa-3abac74f5c42.JPG)
   > <Run device에 AVD가 추가됨>
  
  ![3](https://user-images.githubusercontent.com/95393311/153788902-a9476e3f-2496-4c8f-bc59-e575149ece87.JPG)  
    > <Run 했을 때의 AVD>
- Tools - Android - SDK manager 를 통해 원하는 sdk 설치 및 업데이트 가능

#### 2. 🔖 Logcat 활용하기
![4](https://user-images.githubusercontent.com/95393311/153789939-07b34a29-213d-4b5c-a2e1-a1fdb1113964.JPG)
   > <Log 코드 추가한 후>

#### <추가> 🔖 Text Editor 활용하기
- Text Editor에서 직접 사이즈나 색깔 텍스트 크기 등을 조절한다면??
  ![7](https://user-images.githubusercontent.com/95393311/153999351-747702d7-9c05-449b-a70f-d9a90695eadc.JPG)
- `res`>`value` 파일 아래의 xml 파일에서 코드가 자동으로 생성되는 점을 확인함

#### 3. 🔖 TextView 활용하기
1. TextView의 ID 설정하기
   1. activity_main.xml 파일로 가서 design 탭의 ID 항목에 직접 ID를 넣는다
   2. xml 파일의 코드에서 TextView 안에 `android:id="@+id/[id넣기]` 를 한다
2. findViewById 활용
   1. `val textForFrame: TextView = findViewById(R.id.textForFrame)` 와 같이 인자로 R.id.id이름을 넣는다 (import android.widget.TextView 됨)
   ```
   findViewById의 코드
    public <T extends View> T findViewById(@IdRes int id) {
    return getDelegate().findViewById(id);
    }
    ```
   2. `findViewById`는 `AppCompatActivity` 클래스의 메서드
3. TextView의 속성을 이용한다.
   1. `import android.widget.TextView` import 먼저
   2. `textForFrame.text` >> `.text` : TextView의 text에 String 할당
   3. `textForFrame.setTextColor(Color.parseColor("#FF0000"))` >> `.setTextColor(Int)` : text의 색깔을 삽입 (여기서는 Color.parseColor("#FF0000")로 Red를 삽입함)
   4. `textForFrame.setBackgroundColor(Color.YELLOW)` >> `setBackgroundColor(Int)` : text 배경색에 색깔을 삽입 (.setBackroundColor는 TextView.class가 아니라 View.class 속성)
   5. `textForFrame.setTextSize(5,8.0f)` >> `setTextSize(unit:Int, size:float)` : text 크기를 조절한다
   6. [더알아보기](https://developer.android.com/reference/android/widget/TextView?hl=en#setHighlightColor(int))  
     > <결과>
      ![5](https://user-images.githubusercontent.com/95393311/153839811-9c977412-5f69-4eae-a3da-4039360d1e80.JPG)


#### 4. 🔖 Button 구현하기
![8](https://user-images.githubusercontent.com/95393311/154019677-4f0d8946-e53c-4a34-a963-cd4fb55ac9b6.JPG)
1. XML 파일에서 Design editor로 button 넣기
   ![6](https://user-images.githubusercontent.com/95393311/153998191-130c0ec1-e342-4d85-9b7b-90b5e587ca8f.JPG)
2. 코드로 button 참조하기
   1. `import android.widget.Button` import 먼저
   2. `Button` 클래스는 `TextView` 클래스를 상속받았기 때문에 `TextView`의 모든 기능을 활용할 수 있음
   3. 따라서 텍스트를 할당하는 것도 동일하게 `.text` 활용함
3. Button 클릭 이벤트에 대한 알림 수신하기
   1. `.setOnClickListner{ }` 를 통해 `클릭`했을 때 블록을 수행한다
4. Snack Bar와 Toast 구현하기
   1. Snack Bar
      1. `Snackbar.make()`를 통해 Snack Bar를 생성하고
      2. `.setAction()` 을 통해 Snack Bar 안에서의 액션(버튼)을 추가하고
      3. `show()`를 통해 Snack Bar를 보여줌
   2. Toast
      1. Toast도 유사하게 `makeText()`를 통해 Toast 메세지를 생성함
   3. Snack Bar VS Toast
      1. Snack Bar의 `make()`는 인자로 `View` 타입을 받지만 Toast는 `Context`를 받는다
      2. 앱이 포그라운드에 있다면 토스트 메시지 대신 스낵바를 사용하는 것이 좋습니다. 스낵바에는 사용자가 실행할 수 있는 옵션이 포함되어 있으며 이를 통해 더 나은 앱 환경을 제공할 수 있습니다.
      3. 앱이 백그라운드에 있고 사용자가 어떤 조치를 취하게 하려면 토스트 메시지 대신 알림을 사용하세요.
   4. 참고자료
      1. [스낵바](https://material.io/components/snackbars/android#using-snackbars)
      2. [Toast](https://developer.android.com/guide/topics/ui/notifiers/toasts?hl=ko#kotlin)
      3. [알림](https://developer.android.com/guide/topics/ui/notifiers/notifications?hl=ko)


#### 5. 🔖 다른 Activity로 이동하기
##### 👀 새 Activity 생성
1. Activity 생성 및 layout 생성 (여기서는 직접 kt 파일과 xml파일을 생성하여 연결함)(다른 방법으로는 alt+insert를 통해 activity를 직접 생성)
2. `AndroidManifest.xml`에 새로 만든 Activity 등록
##### 👀 새 Activity 꾸미기
1. main activity와 동일하게 배경색과 버튼 생성하고 설정
##### 👀 Log.d 넣어 callback 로그 출력하기
1. 각 Activity에 `onStart()` `onResume()` `onPause()` `onStop()` `onDestory()` 함수 오버라이드하기
2. 각 콜백함수에 `Log.d("$activity", "$callback")` 넣기
##### 👀 두 번째 Activity로 이동
1. `Intent(현재액티비티, 이동할액티비티)`를 생성하고 startActivity(intent타입)을 통해 이동할 수 있다
##### 👀 두 번째 Activity에서 '닫기' 누르면 다시 첫 번째 액티비티로 이동한 후에 메세지 출력
1. 닫기 버튼의 클릭 이벤트 수신에 `finish()` 메서드를 써서 두 번째 activity를 stop() 후 destroy()함
2. 여기서 `registerForActivityResult()` 메서드를 활용함
   1. 여기서 많이 헤맸는데 그 이유로 자꾸 `.setOnClickListner{}` 에서 등록한 후에 결과값을 가져오려다 보니 에러가 발생함
   `MainActivity@379f7ff is attempting to register while current state is RESUMED. LifecycleOwners must call register before they are STARTED.`
   2. 따라서, 액티비티결과값을 클릭 이벤트가 발생하기 전에 선언하여 문제를 해결(왜 이건 되는지 의문)
      ![11](https://user-images.githubusercontent.com/95393311/154078597-734aae6b-868b-49b7-870a-6d513b1b1e02.JPG)


# 👉 두번째 미션

#### 1. 🔖 XML 코드로 ConstraintLayout에 View 배치하기
1. [x] XML 코드 MainActivity에 ImageView를 240 x 240 크기로 배치한다.
   1. 알고있는 xml 코드로 직접 imageview와 dp 사이즈를 설정
   2. 잘 모르는 속성이 있다면 design editor로 추가한 후에 어떤 코드가 추가되는지 확인하고 지우고 다시 코드로 작성해서 추가
2. [x] ImageView ~ Button까지 제약조건을 추가해 ConstraintLayout의 중앙에 정렬한다.
   1. 각 속성에서 오른쪽과 왼쪽에 제약 조건을 추가하고 bias를 0.5씩 주었습니다.
   2. 3개의 view를 체인화하고 체인 스타일을 `packed`로 했습니다.
   3. 그리고 textview 위 아래로 여백을 주어 보기 좋도록 배치하였습니다.
3. [x] assets 폴더의 이미지 파일 01.jpg를 열어 Bitmap으로 변환해 ImageView에 표시한다.
   1. main 폴더 및에 assets 파일 폴더를 생성하고 다운받은 이미지를 넣었습니다.
   2. jpg, png 파일 등은 압축되어져 있는 파일이지만 bitmap 압축되지 않은 파일이다. 따라서 bitmap으로 변환하기 위해서는 이런 파일들을 decode해야합니다.
   3. decode하기 위해서는 [BitmapFactor](https://developer.android.com/reference/android/graphics/BitmapFactory?hl=en#BitmapFactory()) 클래스를 활용했습니다.  
      `val bitmap = BitmapFactory.decodeStream(resources.assets.open(filename))`
4. [x] '다음' 버튼 클릭 시, 다운로드 받은 이미지 01~22까지 랜덤으로 숫자를 선택해서 ImageView에 표시한다.
   1. `배열.random()`를 통해 배열의 요소를 랜덤하게 반환하도록 했습니다.
   2. 미리 사이즈가 정해져있기 때문에 Array(22)를 사용했습니다.
   3. `val filename = Array<String>(22) {i -> String.format("%02d", i+1) + ".jpg"}.random()`
   4. 이미지는 imageView 메서드를 활용했습니다. `imageView.setImageBitmap(bitmap)`
5. [x] ImageView의 scaleType 속성을 활용해 이미지를 표시하는 방법을 결정한다.
   1. scaleType은 넣어둔 imageView에 꽉차도록 `FIT_XY` 를 선택했습니다.
   2. `imageView.scaleType = ImageView.ScaleType.FIT_XY`
   3. 더 많은 scaleType은 [여기](https://developer.android.com/reference/kotlin/android/widget/ImageView.ScaleType)를 참고하시기 바랍니다.


#### 2. 갤러리에서 사진 선택하기
##### 1. Activity 연결하기
1. [x] MainActivity 화면 오른쪽 하단에 아래와 같은 버튼을 추가하고, 이전 단계에서 만들었던 두번째 Activity로 이동시킨다. 
   1. [x] FloatingActionButton을 사용한다. 
      - 공식사이트가 굉장히 친절해서 간단하게 구현할 수 있었습니다.
      - [Add a Floating Action Button](https://developer.android.com/guide/topics/ui/floating-action-button)
      - [Buttons: floating action button](https://material.io/components/buttons-floating-action-button)
   2. [x] Vector Asset에서 버튼에 사용할 arrow 리소스를 생성한다.
      1. 역시나 공식사이트가 유용했습니다.
         - [Create app icons with Image Asset Studio](https://developer.android.com/studio/write/image-asset-studio?hl=ko)



