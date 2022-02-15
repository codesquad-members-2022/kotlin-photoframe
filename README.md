# 미션1
## 학습 목표
- [x] 포토프레임에 대한 github 저장소 저장소를 fork하고 로컬에 clone할 수 있다.
- [x] 간단히 코드를 추가하고 저장소에 commit하고 push할 수 있다.
- [x] Pull Request를 보낼 수 있다.
- [x] PR 머지 이후 변경된 사항을 로컬에 pull로 가져올 수 있다.
- [x] 리뷰 절차에 따라서 자신의 브랜치로 Pull Request를 생성한다.

## 기능요구사항
- [x] 포토프레임 프로젝트 저장소를 본인 저장소로 fork하고 로컬에 clone한다.
- [x] Emulator를 만들고 앱을 실행한다.
	- [x] Android Emulator에서 앱 실행
- [ ] Android 기기가 있다면, 개발자 옵션을 켜고 USB 디버깅이 가능한 상태로 만든 후 앱을 실행한다.
	- [ ] 하드웨어 기기에서 앱 실행
- [x] README.md 파일을 자신의 프로젝트에 대한 설명으로 변경한다.
- [x] 단계별로 미션을 해결하고 리뷰를 받고나면 README.md 파일에 주요 작업 내용(바뀐 화면 이미지, 핵심 기능 설명)과 완성 날짜시간을 기록한다.
- [x] 실행한 화면을 캡처해서 README.md 파일에 포함한다.
## 프로그래밍 요구사항
- [x] Logcat 활용하기
	- [x] Logcat을 이용한 로그 작성 및 보기
- [x] 자동 생성된 MainActivity 클래스 onCreate 함수에서 Log.d("MainActivity", "onCreate") 코드를 추가하고 실행하면 Logcat 영역에 무엇이 출력되는지 확인한다.

## 추가학습거리
- [ ] Activity에 대해 학습한다.
- Lifecycle은 무엇인가?
- 사용자가 앱을 이용할때 일어나는 앱을 탐색 하거나 정지 등을 해서 변화가 일어날때 상태 변화를 알려주는 것
- Lifecycle이 변경되었음은 어떻게 알 수 있는가?
- 사용자의 반응에 따라 Activity가 첫 시작할때, 다시 시작할때, 화면에 나올때 포커스를 잃을때, 정지할때, 없어 질때 각각 onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy()가 호출되면서 Lifecycle의 변경을 알린다.
## 결과
<img width="1261" alt="스크린샷 2022-02-14 오후 12 23 31" src="https://user-images.githubusercontent.com/79190824/153797452-6bdbf9c9-cf18-4f54-b8e7-851c220121dd.png">


# 미션2 텍스트 변경하고 색 크기 바꾸기
## 학습 목표
- [ ] Layout Editor 사용에 익숙해진다
- [x] TextView를 추가하고, text를 할당할 수 있다
## 기능요구사항
- [x] 앱이 실행되면 "${name}의 사진액자" 라는 텍스트가 보인다.
- [x] 실행한 화면을 캡처해서 README.md 파일에 포함한다.

## 프로그래밍 요구사항
- [x] activity_main.xml에 TextView를 추가한다.
- [ ] Design editor의 기능을 모두 활용해본다.
- [x] MainActivity에서 TextView에 대한 참조를 얻어 text를 변경한다.
- [x] findViewById를 활용한다.
- [x] onCreate 함수에서 text를 변경한다.
- [x] TextView의 글자색, 배경색, 글자 크기를 변경해본다.

## 추가 요구 사항
- [ ] TextView의 주요 속성은 어떤게 있는지 학습한다.

## 결과

<img width="472" alt="스크린샷 2022-02-14 오후 5 10 13" src="https://user-images.githubusercontent.com/79190824/153825219-a7cac8e9-d156-451c-99c1-763504bd0b65.png">


# 미션3 버튼
## 학습 목표
- [x] Button을 추가하고, 클릭 이벤트를 처리할 수 있다.

## 기능요구사항
- [x] 앱을 실행하면 '사진 추가' 버튼이 보인다.

- [x] 버튼을 클릭하면 '사진을 불러옵니다' 메시지가 노출되었다가 사라진다.

- [x] 실행하고 버튼을 터치하기 이전/이후 화면을 캡처해서 README.md 파일에 포함한다.

## 프로그래밍 요구사항
- [x] activity_main.xml에 Button을 추가한다.

- [x] MainActivity에서 Button에 대한 참조를 얻는다.

- [x] Button을 클릭하면 '사진을 불러옵니다' 메시지를 띄운다.

- [x] Button 클릭 이벤트에 대한 알림을 받아 처리한다.

- [x] Snackbar를 활용한다.

## 추가학습거리
- [ ] Button이 알림을 받을 수 있는 Event 종류를 학습한다.

- [ ] 사용자에게 피드백을 줄 수 있는 방법에 대해 학습한다.

- [ ]Snackbar와 Toast의 용도를 비교하고 활용할 줄 안다.
## 결과
- 전
<img width="295" alt="button" src="https://user-images.githubusercontent.com/79190824/153844699-8b96a229-e93d-40db-b88c-5df84dfa363c.png">

- 후
<img width="295" alt="msg" src="https://user-images.githubusercontent.com/79190824/153844684-5d555448-d69d-46ba-972e-50bb2d7407e1.png">


## 다른 Activity로 이동하기

## 학습 목표
- [x] Application 구성 요소에 대해 학습한다.

- [x] 패키지에 새로운 Activity를 추가하고, Activity 간 전환을 구현할 수 있다.

- [x] Activity 전환 시 Lifecycle 변경 단계를 학습한다.

- [x] 명시적 Intent를 생성하고 메시지를 전달할 수 있다.

## 기능요구사항
- [x] 새로운 화면을 추가하고, '다음' 버튼 클릭 시, 이전 화면에서 이동시킨다.

- [x] 새로운 화면에서 '닫기' 버튼 클릭 시, 다시 이전 화면으로 되돌아갈 수 있다.

- [x] 실행하고 새로운 화면을 캡처해서 README.md 파일에 포함한다.

## 프로그래밍 요구사항
- [x] MainActivity에서 이동할 두번째 Activity를 추가한다.

- [x] 두번째 Activity의 배경색상을 변경한다.

- [x] AndroidManifest에 등록한다.

- [x] Activity Lifecycle의 모든 callback에 로그를 출력한다.
	- [x]Log.d("$activityName", "$callbackName")

- [x] MainActivity의 버튼 텍스트를 '다음'으로 변경하고, 클릭하면 두번째 Activity로 이동시킨다.

- [x] 두번째 Activity에 '닫기' 버튼을 추가하고, 클릭 시 다시 MainActivity로 이동시킨다.
	- [x] 이 때, MainActivity에 '사진을 불러왔습니다'라는 메시지를 띄운다.

## 추가학습거리
- [x] Activity를 생성할 때 상속받는 AppCompatActivity가 무엇인지 학습한다.

- [x] Activity 전환 시 Lifecycle이 어떻게 변화하는지 학습한다.

- [x] Activity는 화면 이동을 어떻게 관리하는지 학습한다.

- [x] Activity와 관련된 새로운 용어들에 대해 학습한다.
- Toast 사용
![result](https://user-images.githubusercontent.com/79190824/153996794-c0b24ff3-5d71-45d4-9e71-7678df638a16.gif)

- Snackbar 사용
![화면-기록-2022-02-15-오후-6 56 16](https://user-images.githubusercontent.com/79190824/154038029-2581e36d-7bd0-4033-8c69-717958c5e8b7.gif)

- Lifecycle callback log

<img width="823" alt="logcat" src="https://user-images.githubusercontent.com/79190824/153996529-31e0ab00-ce1b-4945-aaf1-5f21c966af1a.png">
