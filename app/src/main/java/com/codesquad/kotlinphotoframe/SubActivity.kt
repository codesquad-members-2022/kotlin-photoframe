package com.codesquad.kotlinphotoframe

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val subButton = findViewById<Button>(R.id.sub_button)
        subButton.text = "선택"
        subButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)

        val subImage = findViewById<ImageView>(R.id.sub_image)
        val subAssetManager = resources.assets
        val subInputStream = subAssetManager.open("photoframe-border.jpg")
        val subBitmap: Bitmap = BitmapFactory.decodeStream(subInputStream)
        subImage.setImageBitmap(subBitmap)
    }
}