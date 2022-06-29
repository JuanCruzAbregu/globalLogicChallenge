package com.abregujuancruz.globallogicapp.data.network

import com.abregujuancruz.globallogicapp.data.models.ComputerResponse
import retrofit2.Call
import retrofit2.http.GET

interface ComputerAPI {
    @GET("list")
    fun getListOfComputers(): Call<ComputerResponse>
}