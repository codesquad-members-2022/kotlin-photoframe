package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.codesquad.kotlinphotoframe.databinding.ActivityMainBinding
import com.codesquad.kotlinphotoframe.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.subButton.text = "선택"
        binding.subButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)

        val subAssetManager = resources.assets
        val subInputStream = subAssetManager.open("photoframe-border.jpg")
        val subBitmap: Bitmap = BitmapFactory.decodeStream(subInputStream)
        binding.subImage.setImageBitmap(subBitmap)

    }

}