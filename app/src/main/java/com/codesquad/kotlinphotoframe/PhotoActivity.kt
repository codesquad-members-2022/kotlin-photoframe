package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar

private const val TAG = "PhotoActivity"
class PhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        val btnPictureSelect: Button = findViewById(R.id.btn_picture_select)
        val galleryIntent = Intent(Intent.ACTION_PICK)
        galleryIntent.type = "image/*"
        galleryIntent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val ivViewPicture: ImageView = findViewById(R.id.iv_viewPicture)
        val layoutPhotoActivity: View = findViewById(R.id.activity_photo)
        val nextActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                ivViewPicture.setImageURI(it.data?.data)
                Snackbar.make(layoutPhotoActivity, "사진을 불러왔습니다.", Snackbar.LENGTH_SHORT).show()
            }
        }

        btnPictureSelect.setOnClickListener {
            nextActivity.launch(galleryIntent)
        }
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }
}