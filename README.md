# step 1
## Logcat 활용
![logcat](https://user-images.githubusercontent.com/65541248/153802186-2c8a79be-d645-48df-86cb-92d61f5c2b9a.png)


## Lifecycle은 무엇인가?

lifecycle 관련 공식문서
https://developer.android.com/guide/components/activities/activity-lifecycle

![Lifecycle](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fcs6PT5%2FbtqIDD8T93n%2FTxDj98W7xC0dq2H2qviLb1%2Fimg.png)

---

![Lifecycle2](https://t1.daumcdn.net/cfile/tistory/270A4848593E460E21)


앱이 실행된 후 다른 Activity 화면으로 전환되거나, 스마트폰 화면이 꺼지거나 혹은 앱이 종료될 때와 같이 상태 변화가 있을 때마다 Activity 클래스는 상태 변화를 알아차릴 수 있는 여러 콜백을 제공한다.

* onCreate : 시스템이 먼저 Activity를 생성할 때 실행, 필수적으로 구현해야 함. 이 메서드에서 Activity의 전체 수명 주기 동안 한 번만 발생해야 하는 기본 애플리케이션의 시작 로직을 실행함.

* onStart : Activity가 시작됨 상태에 들어갈 때 이 콜백을 호출하게 됨, (화면에 보여지기 시작할 때) onStart가 호출되면 활동이 사용자에게 표시 됨. 이 콜백이 완료되면 onResume 메서드를 호출 함.

* onResume :Activity 재개됨 상태에 들어가면 onResume() 콜백을 호출한다. 이 상태에 들어 갔을 때 앱이 사용자와 상호작용한다. 어떤 이벤트가 발생하여 앱에서 포커스가 떠날 때 까지 앱이 이 상태에 머무르게 된다.

* onPause : 사용자가 Activity를 떠나는 것을 나타내는 첫 번째 신호로 이 메소드를 호출하게 된다. (해당 활동이 항상 소멸되는 것은 아님)

* onStop : Activity가 사용자에게 더 이상 표시되지 않으면 중단됨 상태에 들어가고, 시스템은 onStop 콜백을 호출 한다. 예를 들어 다른 Activity의 실행으로 완전히 가려질 때 적용된다.

* onDestory : Activity가 종료되는 경우, 시스템이 일시적으로 Activity를 소멸시키는 경우에 Activity가 완전히 소멸되기 전에 호출된다.

사용자의 반응에 따라 onCreate, onStart, onResume, onPause, onStop, onDestroy 가 호출되면서 Lifecycle의 변경을 알려준다.

Lifecycle 콜백을 잘 구현하여 앱에서 특별한 예외 상황에 대한 버그가 발생하지 않도록 예방할 수 있다.


# step 2
<img src="https://user-images.githubusercontent.com/65541248/153802823-f10c6806-aec4-4b56-a50b-c231d4cc75e5.png" height="600"/>


# step 3

<img src="https://user-images.githubusercontent.com/65541248/153875479-ded7ea63-77ea-47a5-b070-3a82b31acdb5.png" height="600"/>
<img src="https://user-images.githubusercontent.com/65541248/153875301-13c40439-c188-431c-8c77-c0e1217171ca.png" height="600"/>


--- 
## Snack bar VS Toast


스낵바와 토스트의 가장 큰 차이점은 사용자의 액션을 받아서 처리하느냐 안하느냐의 차이.
토스트는 사용자에게 정보성으로 제공되는 메세지인 반면에 스낵바는 메세지를 주는 동시에 경고성 알림을 주고 사용자에게 확인버튼을 제공하여 클릭을 유도할 수 있다.

<img src="https://user-images.githubusercontent.com/65541248/153869052-4b6e4469-e7a2-44ac-b6dc-50961f1cf2de.png" height="600"/>
<img src="https://user-images.githubusercontent.com/65541248/153875064-aeb55388-2aad-4ae0-8d19-87b619472e2c.png" height="600"/>


Snackbar 버튼 유도 코드
```
  Snackbar.make(view, "hello", Snackbar.LENGTH_INDEFINITE)
            .setAction("Yes") {
                val snackbar2 = Snackbar.make(view, "확인 스낵바 메시지 입니다.", Snackbar.LENGTH_LONG)
                snackbar2.show()
            }
            .show();
```
Toast 코드
```
Toast.makeText(this,"hello world!",Toast.*LENGTH_LONG*).show()
```



# Step 4

<img src="https://user-images.githubusercontent.com/65541248/153882616-0a904517-bce2-4223-9774-f90666c3de8f.png" height="400"/>
<img src="https://user-images.githubusercontent.com/65541248/153882625-bc9b62ef-1208-4bed-ad77-e562fb2d2644.png" height="400"/>
<img src="https://user-images.githubusercontent.com/65541248/154008398-e350b5c6-5c51-4405-b672-74b120950d0e.png" height="400"/>




## AppCompatActivity

Activity가 가져야 하는 기능들이 AppCompatActivity에 들어있다.

우리는 이를 상속받는것만으로 손쉽게 액티비티를 만들 수 있는 것
우리는 여기다 필요한 것들을 추가해서 액티비티를 생성하면 된다.


## Log 출력

첫번째 화면
![1](https://user-images.githubusercontent.com/65541248/154005739-06530c85-fc48-4124-94ef-0f9d3560a19b.png)

두번째 화면
![2](https://user-images.githubusercontent.com/65541248/154005759-f31512e2-4127-44e5-989b-4f6696461562.png)

세번째 화면
![3](https://user-images.githubusercontent.com/65541248/154005762-7956f957-82ee-4aef-95f2-90dcd704a3fb.png)

# step5
<img src="https://user-images.githubusercontent.com/65541248/154447419-57f4dcc2-7cb3-4460-a0cc-4402d31b44bb.png" height="400"/>


### ConstraintLayout이란?
ConstraintLayout은 복잡한 레이아웃을 정의하는 새방식
복잡한 UI에서도 중첩된 레이아웃을 최소화 할 수 있고, 위치를 배치하는 방법에 있어서 기존 layout은 한계가 많아서 ConstraintLayout을 사용 함

# step 6

<img src="https://user-images.githubusercontent.com/65541248/154645938-aba13ccc-5366-49e6-907a-7a4cba8b2ce1.png" height="400"/>
<img src="https://user-images.githubusercontent.com/65541248/154645973-28722a96-f82d-4bef-bcdc-d5e9a493368e.png" height="400"/>

<img src="https://user-images.githubusercontent.com/65541248/154645979-bc40e1b0-5240-4819-8a81-68a50279ded2.png" height="400"/>
<img src="https://user-images.githubusercontent.com/65541248/154645991-e500c512-3a70-4754-8747-c5fa3deba2d3.png" height="400"/>