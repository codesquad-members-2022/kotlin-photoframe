## Step 01

### 프로그래밍 요구사항


- [x] Logcat 활용하기
- [x] 자동 생성된 MainActivity 클래스 onCreate 함수에서 Log.d("MainActivity", "onCreate") 코드를 추가하고 실행하면 Logcat 영역에 무엇이 출력되는지 확인한다.

### 동작 결과
<img width="800" alt="스크린샷 2022-02-14 오후 2 59 47" src="https://user-images.githubusercontent.com/79504043/153829455-071f1155-f6d6-4a8e-9f7c-2d9b621a60e3.png">

<br>
<br/>

---

## Step 02

### 프로그래밍 요구사항


- [x] activity_main.xml에 TextView를 추가한다.
- [ ] Design editor의 기능을 모두 활용해본다.
- [x] MainActivity에서 TextView에 대한 참조를 얻어 text를 변경한다.
  - [x] findViewById를 활용한다.
  - [x] onCreate 함수에서 text를 변경한다.
  - [x] TextView의 글자색, 배경색, 글자 크기를 변경해본다.

### 추가학습거리
- [x] TextView의 주요 속성은 어떤게 있는지 학습한다.
  - [x] 원하는 글꼴을 받아서 적용해본다.
  - [x] 글자의 두께(weieht)를 원하는 두께로 변경해본다.


### 동작 결과

<img width="500" alt="스크린샷 2022-02-14 오후 2 59 47" src="https://user-images.githubusercontent.com/79504043/153830133-f6809636-5fd8-4f55-9df5-70308839ce8c.png">


<br>
<br/>

---

## Step 03

### 프로그래밍 요구사항

- [x] activity_main.xml에 Button을 추가한다.
- [x] MainActivity에서 Button에 대한 참조를 얻는다.
- [x] Button을 클릭하면 '사진을 불러옵니다' 메시지를 띄운다.
  - [x] Button 클릭 이벤트에 대한 알림을 받아 처리한다.
  - [x] Snackbar를 활용한다.

### 추가학습거리

- [x] Button이 알림을 받을 수 있는 Event 종류를 학습한다.
- [x] 사용자에게 피드백을 줄 수 있는 방법에 대해 학습한다.
  - [x] Snackbar와 Toast의 용도를 비교하고 활용할 줄 안다.

### 동작 결과
[동작 영상](https://user-images.githubusercontent.com/79504043/153856296-fe363a1d-8a1b-49f5-8688-aef93cd648c5.mp4)


## Step 04

### 프로그래밍 요구사항

- [x] MainActivity에서 이동할 두번째 Activity를 추가한다.
  - [x] 두번째 Activity의 배경색상을 변경한다.
  - [x] AndroidManifest에 등록한다.
- [x] Activity Lifecycle의 모든 callback에 로그를 출력한다.
- [x] MainActivity의 버튼 텍스트를 '다음'으로 변경하고, 클릭하면 두번째 Activity로 이동시킨다.
- [x] 두번째 Activity에 '닫기' 버튼을 추가하고, 클릭 시 다시 MainActivity로 이동시킨다.
  - [x] 이 때, MainActivity에 '사진을 불러왔습니다'라는 메시지를 띄운다.

### 추가학습거리

- [x] Activity를 생성할 때 상속받는 AppCompatActivity가 무엇인지 학습한다.
- [x] Activity 전환 시 Lifecycle이 어떻게 변화하는지 학습한다.
- [x] Activity는 화면 이동을 어떻게 관리하는지 학습한다.
- [x] Activity와 관련된 새로운 용어들에 대해 학습한다.

### 동작 결과
[동작 영상](https://user-images.githubusercontent.com/79504043/154179634-7b0a3a46-d64e-4bff-a090-28db207eddbb.mp4)



