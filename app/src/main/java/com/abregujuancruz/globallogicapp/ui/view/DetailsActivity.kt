package com.abregujuancruz.globallogicapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.abregujuancruz.globallogicapp.databinding.ActivityDetailsBinding
import com.abregujuancruz.globallogicapp.utils.Constants
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityDetailsBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindItemData()
    }
    
    private fun bindItemData() {
        binding.tvTitleItem.text = intent.getStringExtra(Constants.TITLE_EX)
        binding.tvDescriptionItem.text = intent.getStringExtra(Constants.DESCRIPTION_EX)
        val url = intent.getStringExtra(Constants.IMAGE_EX)
        val position = intent.getStringExtra(Constants.POSITION_EX)
        if (!position.equals("9")) {
            Glide.with(this).load(url).into(binding.ivItem)
        } else {
            binding.ivItem.visibility = View.GONE
        }
    }
}