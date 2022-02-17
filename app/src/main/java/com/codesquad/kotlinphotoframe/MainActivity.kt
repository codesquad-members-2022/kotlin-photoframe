package com.codesquad.kotlinphotoframe

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import java.lang.Exception
import kotlin.random.Random
import android.content.Intent
import com.codesquad.kotlinphotoframe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainText.text = "Stark의 사진액자"
        binding.mainText.setTextColor(Color.BLUE)
        binding.mainText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)

        binding.mainButton.text = "사진 추가"
        binding.mainButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)
        binding.mainButton.setOnClickListener(this)

        binding.buttonGoSubActivity.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.main_button -> {
                val images =
                    listOf( // Int 로 숫자를 랜덤 생성할 시 01, 02 와 같이 앞에 0을 구현하기 힘들어서 String 리스트로 처리
                        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"
                    )
                val randomIdx = Random.nextInt(images.size)
                val image = images[randomIdx]
                try {
                    val assetManager = resources.assets
                    val inputStream = assetManager.open("Demo Images/$image.jpg")
                    val bitmap: Bitmap = BitmapFactory.decodeStream(inputStream)
                    binding.mainImage.setImageBitmap(bitmap)
                } catch (e: Exception) {
                    e.message
                }
            }
        }
    }
}