package com.abregujuancruz.globallogicapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.abregujuancruz.globallogicapp.databinding.ActivityDetailsBinding
import com.abregujuancruz.globallogicapp.ui.viewmodel.DetailsViewModel
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityDetailsBinding
    private val detailsViewModel : DetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        detailsViewModel.getItemData(intent)
        detailsViewModel.computerData.observe(this){
            binding.tvTitleItem.text = it[0]
            binding.tvDescriptionItem.text = it[1]
            Glide.with(this).load(it[2]).into(binding.ivItem)
        }
        
        detailsViewModel.visibility.observe(this) {
            binding.ivItem.visibility = if(it) View.GONE else View.VISIBLE
        }
    }
    
}