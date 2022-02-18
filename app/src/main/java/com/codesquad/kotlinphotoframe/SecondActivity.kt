package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val selectButton: Button = findViewById(R.id.btn_select)
        val selectImage: ImageView = findViewById(R.id.iv_select)
        val layout: ConstraintLayout = findViewById(R.id.constraintlayout_secondLayout)
        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val selectedImageUri: Uri? = it.data?.data
                    selectImage.setImageURI(selectedImageUri)
                    Snackbar.make(layout, "사진을 불러왔습니다", Snackbar.LENGTH_SHORT).show()
                }
            }

        selectButton.setOnClickListener {
            val intent = Intent()
            .apply {
                action = Intent.ACTION_GET_CONTENT
                type = "image/*"
            }
            getResult.launch(Intent.createChooser(intent, "앨범 가져오기"))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SecondActivity - onStart() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "SecondActivity - onRestart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SecondActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SecondActivity - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SecondActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SecondActivity - onDestroy() called")
    }
}