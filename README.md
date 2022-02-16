## 요구사항 

- [x] Emulator를 만들고 앱을 실행하기 or Android 기기 활용하기
- [x] Logcat 활용하기
  - [x] MainActivity 클래스에서 onCreate 함수에서 `Log.d("MainActivity", "onCreate")` 실행하기
- [x] activity_main.xml에 TextView 추가하기
  - [x] Design editor 이용하기
- [x] MainActivity에서 TextView에 대한 참조하기
  - [x] findViewById 확인하기
  - [x] onCreate 함수에서 Text 변경하기
  - [x] 글자색, 배경색, 글자 크기 변경하기
- [x] activity_main.xml에 버튼 추가하기
- [x] MainActivity에서 Button에 대한 참조하기
  - [x] Button 클릭 이벤트에 대해 알림받아 처리하기
  - [x] Snackbar 이용하기
- [x] 새로운 화면 추가하고, 다음 버튼 클릭 시, 이전화면에서 이동하기
  - [x] 새로운 화면에 배경색상을 변경한다.
  - [x] AndroidManifest에 등록한다.
- [x] Activity Lifecycle의 모든 callback에 로그 출력하기 `Log.d("$activityName", "$callbackName")`
- [x] 새로운 화면에서 닫기 버튼 클릭시, 다시 이전화면으로 돌아오기
  - [x] 닫기 버튼 클릭 시, MainActivity에 사진을 불러왔습니다. 메시지 출력하기
- [x] ImageView 240 x 240 크기로 배치하기
- [x] assets 폴더에 이미지 넣기
- [x] assets 폴더의 이미지 파일을 열어 Bitmap으로 변환해 ImageView에 표기하기
  - [x] 다음 버튼 클릭시 다운로드 받은 이미지 01~22까지 랜덤으로 숫자를 선택해서 ImageView에 표시하기
  - [x] 앱이 처음 실행되었을 때는 ImageView의 배경색만 보인다.
  - [x] 이전 단계에 구현했던 화면 이동 기능 제거하기
  - [x] 랜덤으로 숫자 생성하고, fileName을 포맷에 맞게 변경하기
- [x] 이미지 scaleType 속성으로 활용하기
- [x] ConstraintLayout 중앙 정렬하기
- [x] 플로팅 버튼 추가하기
- [ ] 액자 이미지를 화면에 추가하기
- [ ] 갤러리에서 저장한 사진을 가져와서 보여줄 수 있도록 구현하기
- [ ] 액자 이미지와 갤러리에서 불러온 이미지의 배치를 일부 겹쳐서 표기하기

### Emulator 실행하기  
  
  <img width="385" alt="스크린샷 2022-02-14 오전 11 29 27" src="https://user-images.githubusercontent.com/66770613/153789962-3ebda869-9791-4e31-870f-93214080f924.png" width = 250px height = 500px>  
  
  
### Logcat 활용하기

  <img width="809" alt="스크린샷 2022-02-14 오전 11 34 12" src="https://user-images.githubusercontent.com/66770613/153790416-eea631f8-abd4-44bc-a6d6-f9969fa4b4bb.png">  


### TextView 활용하기

  <img width="303" alt="스크린샷 2022-02-14 오후 12 37 40" src="https://user-images.githubusercontent.com/66770613/153796117-3864e913-09ba-4491-9a1a-0ce39300de7e.png" width = 250px height = 500px>  
  
  
### Button 활용하기

  <img width="303" alt="스크린샷 2022-02-14 오후 1 19 25" src="https://user-images.githubusercontent.com/66770613/153799374-e5a577f9-192a-4b1e-9088-152052b02e63.png" width = 250px height = 500px>  
  
  
### 다른 Activity로 이동하기

  <img width="300" alt="스크린샷 2022-02-14 오후 6 01 10" src="https://user-images.githubusercontent.com/66770613/153832459-9d2e33de-3f2a-44c9-8d62-908b2fa006f3.png" width = 250px height = 500px >  
  
  <img width="300" alt="스크린샷 2022-02-14 오후 6 00 53" src="https://user-images.githubusercontent.com/66770613/153832488-cc01d33a-4437-437a-8dc9-8e27363867b8.png" width = 250px height = 500px>  
  
  <img width="953" alt="스크린샷 2022-02-14 오후 6 09 58" src="https://user-images.githubusercontent.com/66770613/153833863-d57f387b-4557-4f4d-9de4-020b87cd1ee7.png">  


### xml에서 이미지 추가하기

<img width="300" alt="스크린샷 2022-02-16 오후 7 43 44" src="https://user-images.githubusercontent.com/66770613/154248455-28340ac7-408a-4c69-b53a-b4bbb68a4f48.png">  

<img width="300" alt="스크린샷 2022-02-16 오후 7 45 10" src="https://user-images.githubusercontent.com/66770613/154248670-6792c889-0021-4cd8-96d2-67a976b0e276.png">  







