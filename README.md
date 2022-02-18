# PhotoFrame 실습 1

## photoFrame logcat 사용시
1. logcat debug 모드
   이미지 파일     
![1](https://user-images.githubusercontent.com/83396157/154183130-bfc60408-abc0-4dbf-b0e6-82f67942d631.PNG)
![verbose_mode](https://user-images.githubusercontent.com/83396157/154183146-8376dbc7-5ce3-496f-a907-071dd6741f5c.PNG)

2. logcat error 모드
   이미지 파일
![error_mode](https://user-images.githubusercontent.com/83396157/154183141-058f73b9-b13a-4e4b-8b51-80ce99109907.PNG)

## photoFrame 시작시 글자 보이도록 변경
1. photoFrame TextView xml 파일 작성

2. photoFrame TextView text를 OnCreate 에서 변경 가능하도록 작성


## photoFrame snackbar 생성

1. Activity main의 버튼 클릭시 snackbar생성
![snackbar](https://user-images.githubusercontent.com/83396157/154183142-fb9615e4-b9cc-4aae-90a0-c3b41e5933c5.PNG)

## photoFrame activity 간 전환
1. Activity2 생성 및 버튼 구현


2. Activity Main에서 버튼 누를 시 Activity2 실행 

        val button: Button = findViewById(R.id.add_photo_button)

        button.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

![activity_1](https://user-images.githubusercontent.com/83396157/154183134-5e0c60e6-fe51-431f-bfd1-48fb195c4fcd.PNG)
![activity_2](https://user-images.githubusercontent.com/83396157/154183323-44f24aa3-10a1-42e8-a285-24730b2c66b3.PNG)

    3. activity 간 전환시 log 출력
![activity_chainging_log](https://user-images.githubusercontent.com/83396157/154183136-439ce800-4258-475c-ac02-3c0bab76fb1f.PNG)


## photoFrame 랜덤 사진 선택하기

1. random 한 숫자를 이용하여 가져올 파일을 선택해 주었습니다.
        
        val randomNum = (1..22).random()
            val randomID = if (randomNum < 10) {
                "0$randomNum"
            } else {
                randomNum.toString()
        }
   
2. 이후 숫자를 통해서 랜덤한 파일을 불러왔습니다.


## photoframe 사진 불러오기

1. Activity2 의 화면을 구성해 주었습니다.


2. 불러오기 기능을 getContent() 를 통해 구현해 주었습니다.



## 동작 

![studio64_bMoByFw4hU](https://user-images.githubusercontent.com/83396157/154605823-82e3fd8f-4475-4a9a-a909-9f105b48d0a2.gif)


## 정리

[NOTION](https://cream-dead-621.notion.site/Android-Layout-Activities-62210d37222d4828a1e1434cb13b5822)