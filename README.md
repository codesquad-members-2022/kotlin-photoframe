# PhotoFrame Step2
##  ConstraintLayout에 View 배치하기, assests 폴더로 부터 이미지 로드
### 결과
![GIF 2022-02-16 오후 3-51-26](https://user-images.githubusercontent.com/58967292/154604632-02d4b65b-ebff-4e09-8b85-ba128eaeaaca.gif)

### 학습목표
* Constrain Layout
* ImageView의 주요 속성 

##Layout
### Layout 종류
* Linear Layout: 수직방향 혹은 수평방향 차례로 주어진 뷰를 정렬한다
* Relative Layout: 뷰들이 다른 뷰들로부터로 위치를 지정하거나, 자신이 속한 레이아웃을 기준으로 위치를 정한다.
* Constrain Layout: 뷰 사이에 수평, 수직방향의 제약을 주어 뷰들을 위치
* Table Layout: 뷰를 행과 열로 구성하여 표(테이블) 형태로 표현한다
* Frame Layout: 뷰들을 액자처럼 쌓아놓는다. 여러 뷰들을 추가하더라도 가장 나중에 추가한 뷰가 가장 위에 위치하게 된다. 레이아웃 내에 여러 뷰를 배치하는데 적합하지 않고, 주로 화면에 표시될 하나의 뷰를 바꿔가며 표시하는데 적합

### Linear Layout 기본속성
* 리니어 레이아웃은 다른 레이아웃과 다르게 방향 속성을 꼭 지정해 주어야 한다
* orientation 속성에  vertical(수직) horizontal(수평)을 지정해 주면 된다

### Layout gravity/ gravity
* gravity: View 내부의 content의 위치를 설정
* layout_gravity: 상위 View를 기준으로 했을 떄  View의 위치를 설정

### layout_weight
* 각 View에 가중치를 부여해 Width/Height을 비율로 부여한다
* 여백을 두고 싶은경우 weightSum과 함께 사용한다
* Linear Layout의 경우 수직/수평 방향에 따라 자식의 수평/수직을 0dp로 설정해줘야 작동한다

### Realtive Layout 기본 속성
* 상대적 레이아웃은 내부에 뷰를 배치할 때 기준이 되는 뷰가 존재해야 한다
* 이는 다른 뷰가 될 수도 있고, 부모 레이아웃이 될 수도 있다.
* 기본적으로 아무 위치를 지정하지않으면 부모 레이아웃의 상단,왼쪽에 배치된다
* 부모를 기준으로 하는 경우
    * layout_alignParentStart = "true"
    * layout_alignParentEnd = "true"
    * layout_centerParent = "true"
    * layout_alignParentBottom = "true"
    * layout_centerHorizontal = "true"
    * ...
    
* 다른 뷰를 기준으로 하는 경우
    * layout_toLeftOf  = @id
    * layout_above = @id
    * layout_toRightOf = @id
    * ...
* 속성정보: https://developer.android.com/reference/android/widget/RelativeLayout?hl=en

### Constrain Layout이 Linear/Relative Layout보다 많이 쓰이는 이유
* 다양한 화면 크기에 대응하는 반응형 UI를 쉽게 구성할 수 있다
* 중첩된 레이아웃을 사용하지 않고도 크고 복잡한 레이아웃을 만들 수 있다. 

### Constrain Layout 기본속성
* Constraint Layout에서 자식 뷰의 위치를 정의하려면 자식 뷰의 수직/수평 방향에 제약조건을 각각 하나이상 추가해야한다
* layout_constrainTop_toBottom/TopOf 
* layout_constrainBottom_toBottom/TopOf
* layout_constrainRight_toRight/LeftOf
* layout_constrainLeft_toRight/LeftOf
* layout_constrainStart_toEndOf
* layout_constrainEnd_toStartOf

### Constrain Layout 마진 줄떄 주의점
* 해당 방향으로 제약이 존재해야 마진이 적용된다는 규칙이 있다 

### match_constraint 속성
* layout width/height에 0dp를 준다는 것 = match_constraint를 값으로 주는것
* 제약에 뷰 크기를 맞추는 것

## ImageView
* src: 이미지뷰의 이미지 소스를 지정해주는 속성
* scaleType: 이미지 비율 조정
  * fitCenter: scaleType속성의 기본값, 가로or 세로 중 한 방향으로 스케일 된다. 이미지뷰의 센터를 기준으로 이미지 표시
  * fitXY: 가로,세로 방향으로 이미지가 이미지뷰를 빈틈없이 가득 채운다
  * center: 스케일 없이 이미지를 가운데 표시, 이미지가 뷰보다 크다면 그대로 잘리고, 작다면 작은 그대로 보여짐
  * centerCrop: 이미지 비율은 그대로 유지한 상태로 스케일 한다. 이미지 뷰를 벗어나는 부분은 잘라낸 채로 보여준다.

## Mission6 갤러리에서 사진 선택하기
### 결과
![GIF 2022-02-18 오전 11-07-26](https://user-images.githubusercontent.com/58967292/154605274-438dd489-e025-4ea8-a513-a6811e94dca5.gif)

### 학습목표
* intent
* 갤러리로부터 이미지를 가져오는 방법
* Floating ActionButton 
