package com.codesquad.kotlinphotoframe


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTextView = findViewById<TextView>(R.id.main_text) // UI 요소를 사용 시 보통 lateinit 을 사용해 객체를 선언하면 좋다.
        myTextView.text = "Stark의 사진액자"
        myTextView.setTextColor(Color.BLUE) // 텍스트 색깔이나 사이즈를 xml 이 아니라 틀린 코드에서 동적으로 처리하는 이유?
        myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)

        val imageView = findViewById<ImageView>(R.id.main_image)
        val images = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22")
        val randomIdx = Random.nextInt(images.size)
        val image = images[randomIdx]

        val button = findViewById<Button>(R.id.main_button)
        button.text = "사진 추가"
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)
        button.setOnClickListener {
            try {
                val assetManager = resources.assets
                val inputStream = assetManager.open("Demo Images/$image.jpg")
                val bitmap: Bitmap = BitmapFactory.decodeStream(inputStream)
                imageView.setImageBitmap(bitmap)
                inputStream.close()
            } catch (e: Exception) {
                e.message
            }
        }
    }
}