# PhotoFrame 실습 1

## photoFrame logcat 사용시
    1. logcat debug 모드
        이미지 파일     

    2. logcat error 모드
        이미지 파일

## photoFrame 시작시 글자 보이도록 변경
    1. photoFrame TextView xml 파일 작성

    2. photoFrame TextView text를 OnCreate 에서 변경 가능하도록 작성

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_photo_frame)
            Log.d("MainActivity", "onCreate")

            val t = findViewById<TextView>(R.id.photo_frame_header2)
            t.text = "실습"
        }
    }