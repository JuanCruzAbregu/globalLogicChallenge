package com.abregujuancruz.globallogicapp.ui.viewmodel

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abregujuancruz.globallogicapp.utils.Constants

class DetailsViewModel : ViewModel() {
    
    private val _computerData = MutableLiveData<ArrayList<String>>()
    val computerData: LiveData<ArrayList<String>> get() = _computerData
    private val list = ArrayList<String>()
    
    private val _visibility = MutableLiveData<Boolean>()
    val visibility: LiveData<Boolean> get() = _visibility
    
    fun getItemData(intent: Intent) {
        
        list.add(intent.getStringExtra(Constants.TITLE_EX).toString())
        list.add(intent.getStringExtra(Constants.DESCRIPTION_EX).toString())
        list.add(intent.getStringExtra(Constants.IMAGE_EX).toString())
        val position = intent.getStringExtra(Constants.POSITION_EX)
        if (position == "9") _visibility.value = true
        _computerData.value = list
        
    }
    
}