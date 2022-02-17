package com.codesquad.kotlinphotoframe

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast.LENGTH_LONG
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.codesquad.kotlinphotoframe.databinding.ActivityMainBinding
import com.codesquad.kotlinphotoframe.databinding.ActivitySubBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class SubActivity : AppCompatActivity() {
    val REQ_GALLERY = 1
    private lateinit var binding: ActivitySubBinding

    private val getImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        binding.subImage.setImageURI(it.data?.data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.subButton.text = "선택"
        binding.subButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)

        val subAssetManager = resources.assets
        val subInputStream = subAssetManager.open("photoframe-border.jpg")
        val subBitmap: Bitmap = BitmapFactory.decodeStream(subInputStream)
        binding.subImage.setImageBitmap(subBitmap)

        binding.subButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQ_GALLERY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                REQ_GALLERY -> {
                    try{
                        val uri = data?.data
                        binding.subImage.setImageURI(uri)
                    }catch (e:Exception){
                        e.message
                    }
                }
            }
        }
    }
}