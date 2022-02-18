package com.codesquad.kotlinphotoframe

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    var bitmap: Bitmap? = null
    private lateinit var msg: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val view: View = findViewById(R.id.back)
        Log.d("${this.localClassName}", "onCreate")
//        val background: LinearLayout = findViewById(R.id.back)
//        background.setBackgroundColor(Color.parseColor("#9965f4"))
        val imageView: ImageView = findViewById(R.id.image)
        val button: Button = findViewById(R.id.button)
        button.text = "선택"
        val getContent = imageChange(imageView, view)
        button.setOnClickListener {
//            val contextView = findViewById<View>(R.id.context)
//            Toast.makeText(applicationContext,"사진을 불러오는 중입니다.",Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("msg", "사진을 가져오는 중"
//            startActivity(intent)
            getContent.launch("image/*")
        }
    }

    private fun imageChange(imageView: ImageView, view: View) = registerForActivityResult(ActivityResultContracts.GetContent()) {
        bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver, it))
        } else {
            MediaStore.Images.Media.getBitmap(contentResolver, it)
        }
        imageView?.setImageBitmap(bitmap)
        msg = "사진을 불러왔습니다."
        msg?.Snackbar(view)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("${this.localClassName}", "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("${this.localClassName}", "onStart")
    }

    override fun onResume() {
        Log.d("${this.localClassName}", "onResume")
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        Log.d("${this.localClassName}", "onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d("${this.localClassName}", "onPause")
    }
}
