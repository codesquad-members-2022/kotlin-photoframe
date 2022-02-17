package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT

class MainActivity : AppCompatActivity() {
    private lateinit var textForFrame: TextView
    private lateinit var firstButton: Button
    private lateinit var secondButton: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate")
        textForFrame = findViewById(R.id.textForFrame)
        secondButton = findViewById(R.id.button2)
        imageView = findViewById(R.id.imageView)
        setTextForFrame(textForFrame)
        clickBtnToShowImage(secondButton)
    }

    private fun clickBtnToShowImage(btn:Button) {
        btn.setOnClickListener {
            val filename = Array<String>(22) {i -> String.format("%02d", i+1) + ".jpg"}.random()
            val bitmap = BitmapFactory.decodeStream(resources.assets.open(filename))
            imageView.setImageBitmap(bitmap)
            imageView.scaleType = ImageView.ScaleType.FIT_XY
        }
    }
    private fun setTextForFrame(textForFrame: TextView) {
        val name = "Linus"
        textForFrame.text = "${name}의 사진액자"
        textForFrame.setTextColor(Color.parseColor("#FF0000"))
        textForFrame.setBackgroundColor(Color.YELLOW)
        textForFrame.setTextSize(3, 10.0f)
    }

    private fun setFirstButtonToShowSnackBarAndToastMeg(button: Button) {
        val textForbutton = "사진 추가"
        button.text = "$textForbutton"
        button.setOnClickListener {
            Snackbar.make(it, "사진을 불러옵니다", LENGTH_SHORT).setAction("Okay") {
                Toast.makeText(this, "Toast 먹고싶다", Toast.LENGTH_SHORT).show()
            }.show()
        }
    }

    private fun setSecondButtonToMoveOtherActivity(button: Button) {
        val launcher = showTextAfterotherActivity(button)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            launcher.launch(intent)
        }
    }

    private fun showTextAfterotherActivity(view: View): ActivityResultLauncher<Intent> {
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


