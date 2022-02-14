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

