package com.abregujuancruz.globallogicapp.ui.viewmodel

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abregujuancruz.globallogicapp.data.models.ComputerResponse
import com.abregujuancruz.globallogicapp.data.network.APIService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComputerViewModel : ViewModel() {
    
    private val apiService = APIService()
    
    private val _computerData = MutableLiveData<ComputerResponse>()
    val computerData: LiveData<ComputerResponse> get() = _computerData
    
    private val _visibility = MutableLiveData<Boolean>()
    val visibility: LiveData<Boolean> get() = _visibility
    
    fun getListOfComputers() {
        viewModelScope.launch {
            val call: Call<ComputerResponse> = apiService.getListOfComputers()
            call.enqueue(object : Callback<ComputerResponse> {
                override fun onResponse(
                    call: Call<ComputerResponse>,
                    response: Response<ComputerResponse>
                ) {
                    _computerData.value = response.body()
                }
                
                override fun onFailure(call: Call<ComputerResponse>, t: Throwable) {
                    Log.e("Error!!", t.message.toString())
                }
            })
        }
    }
    
    fun controlVisibility() {
        viewModelScope.launch {
            Handler(Looper.getMainLooper()).postDelayed({
                _visibility.value = true
            }, 1000)
        }
    }
    
}