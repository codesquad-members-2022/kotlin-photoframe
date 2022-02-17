package com.codesquad.kotlinphotoframe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codesquad.kotlinphotoframe.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun setNextBtn(){
        binding.btnNext.setOnClickListener {
            
        }
    }
}