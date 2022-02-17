package com.codesquad.kotlinphotoframe

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codesquad.kotlinphotoframe.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setNextBtn()
    }

    fun setNextBtn(){
        binding.btnNext.setOnClickListener {
            val inputStream = assets.open("missionpicture/${getRandomNumber()}.jpg")
            /*
            val drawable = Drawable.createFromStream(inputStream, null)
            binding.ivPicture.setImageDrawable(drawable)
            */

            val bitmap = BitmapFactory.decodeStream(inputStream)
            binding.ivPicture.setImageBitmap(bitmap)

            // drawable, bitmap 모두 같은 결과
        }
    }

    fun getRandomNumber(): String{
        val num = (1..22).random()
        return if(num <= 9) "0$num" else num.toString()
    }
}