package com.example.myapplication.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MasterServiceCoins {

    @GET("/api/RP/RP_con_NC")
    fun getMasterService() : Call<ResponseRPEstado>

}
