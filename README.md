# Step1 프로젝트 실행하기

## 기능 요구사항

2022년 2월 14일 월요일, 오전 11:53:07 완성

내 아이디로  fork를 사용한후 윈도우 터미널로 클론을 해 github와 디렉토리를 연결함

![프로젝트 실행](https://user-images.githubusercontent.com/91953080/153999758-aeb33386-b5fc-4798-ac0e-88e70c1e77e5.png)

## 프로그래밍 요구사항

2022년 2월 15일 화요일, 오전 01:00:50 완성

onCreate함수에 코드를 추가후 CTRL+F 로 onCreate를 검색해서 찾음

![로그챗 확인](https://user-images.githubusercontent.com/91953080/153999852-a097e983-bb8d-4809-a2fc-53de2c46aca7.png)

# Step2,3 TextView 및 Button 구현하기

## 기능 요구사항

![버튼 구현](https://user-images.githubusercontent.com/91953080/154183935-a8164a11-01da-446f-8981-f2b9541e18d6.png)

## 프로그래밍 요구사항

findViewByid를 활용해 activity_main.xml의 id를 참조해서 onCreate함수에서 text,글자색,글자 크기를 변경했다.

그 이후 텍스트를 가운데 정렬하려했는데 레이아웃 내에서 가운데 정렬하는방법은 activity_main.xml 의 코드에
android:textAlignment="center"를 추가하면 됐지만 
레이아웃 자체를 앱화면의 가운데에 정렬하는방법은
android:layout_gravity="center"를 추가하면 된다고하는데 작동을 하지않았다.

![레이아웃 정렬](https://user-images.githubusercontent.com/91953080/154185095-58fafdd0-fca9-4766-9af8-30c4d39c71d4.png)

추측으로는 activity_main.xml의 시작태그가 <LinearLayout>이 아니여서라고 짐작되는데 변경해도되는지, 변경방법은 찾지를 못해 다른방법을 찾다가
디자인에서 우클릭>Center 항목에서 방법을 찾았다.

![레이아웃 정렬2](https://user-images.githubusercontent.com/91953080/154185412-8f30b7d6-468b-4413-8de2-1ce8c1f6da74.png)
버튼은 textView를 수정하는 방법과 비슷하게 진행함

# Step4 라이프싸이클 별 로그챗 및 두번쨰 Activity 구현

패키지에서 우클릭>new를 통해서 새로운 액티비티를 만들었음
그 후 AndroidManifest를 확인하니 MainActivity2가 자동으로 만들어져 있었음

![새로운 액티비티](https://user-images.githubusercontent.com/91953080/154432280-d5c4be73-017f-488e-aa66-65e98ddd3644.png)

라이프싸이클 함수를 추가해서 해당 라이프싸이클 함수 실행시 로그챗이 실행되도록 Log.d함수를 추가함

![로그d](https://user-images.githubusercontent.com/91953080/154432852-56409b9b-3824-420d-b5f4-01ad9d291ad9.png)
