package com.codesquad.kotlinphotoframe

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.io.IOException
import kotlin.random.Random

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvExplain: TextView = findViewById(R.id.tv_explain)
        tvExplain.text = "wooki의 사진 액자^^"
        tvExplain.setTextColor(Color.RED)
        tvExplain.setBackgroundColor(Color.YELLOW)
        tvExplain.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)

        val btnNext: Button = findViewById(R.id.btn_next_picture)
        val ivPicture: ImageView = findViewById(R.id.iv_picture)
        btnNext.setOnClickListener {
            val randomIndex = Random.nextInt(1, 23)
            val fileName = String.format("%02d.jpg", randomIndex)
            if (ivPicture.setImageBitmap(getBitmapFromAssetsDirectory(fileName)) == null) {
                Toast.makeText(this, "이미지를 불러올 수 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        val btnNextActivity: FloatingActionButton = findViewById(R.id.btn_next_activity)
        val intentNextActivity = Intent(this, PhotoActivity::class.java)
        btnNextActivity.setOnClickListener {
            startActivity(intentNextActivity)
        }
    }

    private fun getBitmapFromAssetsDirectory(filename: String): Bitmap? {
        try {
            val assetMgr = resources.assets
            val inputStream = assetMgr.open(filename)
            return BitmapFactory.decodeStream(inputStream)
        } catch (e: IOException) {
            Log.e(TAG, e.toString())
            return null
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
