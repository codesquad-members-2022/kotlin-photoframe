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
3. TextView의 속성을 이용한다.
   1. `textForFrame.text` >> `.text` : TextView의 text에 String 할당
   2. `textForFrame.setTextColor(Color.parseColor("#FF0000"))` >> `.setTextColor(Int)` : text의 색깔을 삽입 (여기서는 Color.parseColor("#FF0000")로 Red를 삽입함)
   3. `textForFrame.setBackgroundColor(Color.YELLOW)` >> `setBackgroundColor(Int)` : text 배경색에 색깔을 삽입 (.setBackround는 TextView.class가 아니라 View.class 속성)
   4. `textForFrame.setTextSize(5,8.0f)` >> `setTextSize(unit:Int, size:float)` : text 크기를 조절한다
   5. [더알아보기](https://developer.android.com/reference/android/widget/TextView?hl=en#setHighlightColor(int))  
     > <결과>
      ![5](https://user-images.githubusercontent.com/95393311/153839811-9c977412-5f69-4eae-a3da-4039360d1e80.JPG)
            
