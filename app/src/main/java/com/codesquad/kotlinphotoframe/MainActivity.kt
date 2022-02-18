package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT

class MainActivity : AppCompatActivity() {
    private lateinit var textForFrame: TextView
    private lateinit var firstFab: FloatingActionButton
    private lateinit var secondButton: Button
    private lateinit var firstImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate")
        textForFrame = findViewById(R.id.text_for_frame)
        secondButton = findViewById(R.id.second_btn)
        firstImageView = findViewById(R.id.first_image_view)
        firstFab = findViewById(R.id.fab)
        setTextForFrame(textForFrame)
        clickBtnToShowImage(secondButton)
        moveToSecondActivity(firstFab)
    }

    private fun clickBtnToShowImage(btn: Button) {
        btn.setOnClickListener {
            val filename = Array<String>(22) { i -> String.format("%02d", i + 1) + ".jpg" }.random()
            val bitmap = BitmapFactory.decodeStream(resources.assets.open(filename))
            firstImageView.setImageBitmap(bitmap)
            firstImageView.scaleType = ImageView.ScaleType.FIT_XY
        }
    }

    private fun setTextForFrame(textForFrame: TextView) {
        val name = "Linus"
        textForFrame.text = "${name}의 사진액자"
        textForFrame.setTextColor(Color.parseColor("#FF0000"))
        textForFrame.setBackgroundColor(Color.YELLOW)
        textForFrame.setTextSize(3, 10.0f)
    }

    private fun setButtonToShowSnackBarAndToastMeg(button: Button) {
        val textForbutton = "사진 추가"
        button.text = "$textForbutton"
        button.setOnClickListener {
            Snackbar.make(it, "사진을 불러옵니다", LENGTH_SHORT).setAction("Okay") {
                Toast.makeText(this, "Toast 먹고싶다", Toast.LENGTH_SHORT).show()
            }.show()
        }
    }

    private fun moveToSecondActivity(button: FloatingActionButton) {
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registerIntentToShowTextAfterOtherActivity(view: View): ActivityResultLauncher<Intent> {
        return registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            Snackbar.make(view, "사진을 불러왔습니다", LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}


