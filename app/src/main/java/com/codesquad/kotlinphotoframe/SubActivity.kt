package com.codesquad.kotlinphotoframe

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast.LENGTH_LONG
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.codesquad.kotlinphotoframe.databinding.ActivityMainBinding
import com.codesquad.kotlinphotoframe.databinding.ActivitySubBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.subButton.text = "선택"
        binding.subButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)

        val subAssetManager = resources.assets
        val subInputStream = subAssetManager.open("photoframe-border.jpg")
        val subBitmap: Bitmap = BitmapFactory.decodeStream(subInputStream)
        binding.subImage.setImageBitmap(subBitmap)

        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    Snackbar.make(binding.subLayout, "사진을 불러왔습니다.", Snackbar.LENGTH_SHORT).show()
                    try {
                        val uri = it.data?.data
                        binding.subImage.setImageURI(uri)
                    } catch (e: Exception) {
                        e.message
                    }
                }
            }

        binding.subButton.setOnClickListener {
            intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            getResult.launch(intent)

        }
    }
}