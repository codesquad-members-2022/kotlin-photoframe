package com.codesquad.kotlinphotoframe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d("MainActivity2", "onStart")

        val button : Button = findViewById(R.id.button)
        val pictureView: ImageView = findViewById(R.id.pictureView)

        val galleryIntent = Intent(Intent.ACTION_PICK)
        galleryIntent.type = "image/*"
        galleryIntent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val nextActivity =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    pictureView.setImageURI(it.data?.data)

                    Snackbar.make(pictureView, "사진을 불러왔습니다!", Snackbar.LENGTH_LONG)
                        .show();
                }
            }

        button.setOnClickListener {
            nextActivity.launch(galleryIntent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity2", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity2", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity2", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity2", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity2", "onDestroy")
    }
}