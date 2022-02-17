package com.codesquad.kotlinphotoframe

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.codesquad.kotlinphotoframe.databinding.ActivityGalleryBinding

const val REQUEST_IMAGE_GET = 100

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGalleryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setOpenGalleryBtn1()
        //setOpenGalleryBtn2()
    }

    fun setOpenGalleryBtn1(){
        var getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            Log.d("AppTest", "data : ${it.data}")
            binding.ivPhoto.setImageURI(it.data?.data)
        }

        binding.btnOpenGallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK) // 갤러리로 이동
            //val intent = Intent(Intent.ACTION_GET_CONTENT)  // 전체 이미지 관련 파일 선택 가능한 화면으로 이동
            intent.type = "image/*"
            getContent.launch(intent)
        }
    }

    fun setOpenGalleryBtn2(){        // startActivityForResult 사용하는 방법 (deprecated)
        binding.btnOpenGallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK).apply {
                type = "image/*"
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_GET)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_GET && resultCode == Activity.RESULT_OK) {
            //val thumbnail: Bitmap? = data?.getParcelableExtra("data")
            val fullPhotoUri: Uri? = data?.data
            Log.d("AppTest", "photo uri : $fullPhotoUri")
            binding.ivPhoto.setImageURI(fullPhotoUri)
        }
    }
}