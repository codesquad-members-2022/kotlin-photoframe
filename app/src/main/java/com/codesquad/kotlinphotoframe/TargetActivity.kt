package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import java.lang.Exception

class TargetActivity : AppCompatActivity() {
    val tag = "TargetActivity"
    private val getResult: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK && it.data != null) {
                val currentImageUri = it.data?.data
                val photo = findViewById<ImageView>(R.id.target_iv_photo)
                try {
                    currentImageUri?.let {
                        if (Build.VERSION.SDK_INT < 28) {
                            val bitmap = MediaStore.Images.Media.getBitmap(
                                this.contentResolver,
                                currentImageUri
                            )
                            photo?.setImageBitmap(bitmap)
                        } else {
                            val source =
                                ImageDecoder.createSource(this.contentResolver, currentImageUri)
                            val bitmap = ImageDecoder.decodeBitmap(source)
                            photo?.setImageBitmap(bitmap)

                        }

                    }
                    Toast.makeText(this, "사진을 불러왔습니다.", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                Toast.makeText(this, "사진을 가져오지 못했습니다.", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)
        val prevBtn = findViewById<Button>(R.id.target_btn_select)
        prevBtn.setOnClickListener {
            startDefaultGalleryApp()
        }
    }

    private fun startDefaultGalleryApp() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        getResult.launch(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d("$tag", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("$tag", "onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d("$tag", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("$tag", "onDestroy")
    }

}