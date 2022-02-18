package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.ImageFormat
import android.media.Image
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
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class TargetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)
        val prevBtn = findViewById<Button>(R.id.target_btn_select)
        prevBtn.setOnClickListener {
            getPhotoFromGallery()
        }
    }

    private fun getPhotoFromGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        getPhoto.launch(intent)
    }

    private fun getPhotoUriFromGallery(){
        getPhotoUri.launch("image/*")
    }

    private val getPhoto: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val photo = findViewById<ImageView>(R.id.target_iv_photo)
            if (it.resultCode == RESULT_OK && it.data != null) {
                val currentImageUri = it.data?.data
                lateinit var bitmap:Bitmap
                try {
                    currentImageUri?.let {
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
                            bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, currentImageUri)
                        }
                        else {
                            val source = ImageDecoder.createSource(this.contentResolver, currentImageUri)
                            bitmap = ImageDecoder.decodeBitmap(source)
                        }
                    }
                    photo?.setImageBitmap(bitmap)
                    Snackbar.make(photo, "사진을 불러왔습니다.", Snackbar.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                Snackbar.make(photo, "사진을 가져오지 못했습니다.", Snackbar.LENGTH_SHORT).show()
            }
        }

    private val getPhotoUri = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        val photo = findViewById<ImageView>(R.id.target_iv_photo)
        lateinit var bitmap:Bitmap
        uri.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val source = ImageDecoder.createSource(this.contentResolver, uri)
                bitmap = ImageDecoder.decodeBitmap(source)
                photo?.setImageBitmap(bitmap)
            } else {
                bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                photo?.setImageBitmap(bitmap)
            }
            photo?.setImageBitmap(bitmap)
            Snackbar.make(photo, "사진을 불러왔습니다.", Snackbar.LENGTH_SHORT).show()
        }
    }

}