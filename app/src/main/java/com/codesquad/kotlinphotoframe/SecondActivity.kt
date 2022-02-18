package com.codesquad.kotlinphotoframe

import android.content.Intent.*
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.util.Log
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar



class SecondActivity : AppCompatActivity() {
    private lateinit var layout: ConstraintLayout
    private lateinit var firstBtn: Button
    private lateinit var firstImageView: ImageView
    private lateinit var secondImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("SecondActivity", "onCreate")
        layout = findViewById(R.id.second_activity_first_layout)
        firstBtn = findViewById(R.id.second_activity_btn)
        firstImageView = findViewById(R.id.second_activity_first_imageview)
        secondImageView = findViewById(R.id.second_activity_second_imageview)
        setLayoutColor(layout)
        putImageToImageView(firstImageView)
        setFirstButtonForTextAndColor(firstBtn)
        val photoFromGallery = registerActivityResultToSetImageFromGallery()
        clickBtnToSelectPhoto(firstBtn,photoFromGallery)
    }

    private fun putImageToImageView(imageView: ImageView) {
        imageView.setImageDrawable(getDrawable(R.drawable.frame))
    }

    private fun setLayoutColor(layout: ConstraintLayout) {
        layout.setBackgroundColor(Color.parseColor("#FFD3FAF9"))
    }

    private fun setFirstButtonForTextAndColor(button: Button) {
        button.text = "선택"
        button.textSize = 20f
        button.setTextColor(Color.BLACK)
        button.setBackgroundColor(Color.YELLOW)
    }

    private fun clickButtonToFinish(button: Button) {
        button.setOnClickListener {
            finish()
        }
    }

    private fun registerActivityResultToSetImageFromGallery() = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        secondImageView.setImageURI(it.data!!.data)
        Snackbar.make(layout, "사진을 불러왔습니다",Snackbar.LENGTH_SHORT).show()
    }

    private fun clickBtnToSelectPhoto(button: Button, intent: ActivityResultLauncher<Intent>) {
        button.setOnClickListener {
            val intentForPhoto = Intent(ACTION_PICK).setType("image/*")
            intent.launch(intentForPhoto)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("SecondActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SecondActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SecondActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SecondActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity", "onDestroy")
    }
}