package com.example.myapplication.Model

import android.util.Log
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestAPI {

    var datos = mutableListOf<String>()
    var datos2 = mutableListOf<String>()
    var datos3 = mutableListOf<String>()
    var datos4 = mutableListOf<String>()

    companion object {

        var token = ""
        var userId = ""
        var borrados4 = mutableListOf<String>()

    }

    private val client = OkHttpClient.Builder().apply{
        addInterceptor(HttpInterceptor())
    }.build()


    var retrofit = Retrofit.Builder()
        .baseUrl("http://derrama.net")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getMasterAPI() : MasterService{

        var masterService = retrofit.create(MasterService::class.java)

        return masterService
    }


    fun setPostLogin(email:String, password:String){

        var newUser = User()
        newUser.email = email
        newUser.password = password

        var json = Gson().toJson(newUser)

        var postService = retrofit.create(PostMasterService::class.java)

//        Calling with foo.example("Bob Smith", "Jane Doe") yields a request body of name=Bob+Smith&name=Jane+Doe.

        var call = postService.setMasterService(email,password)

        call.enqueue(object : Callback<Token> {
            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                Log.i("response", response.body()!!.tienda.toString())

                RestAPI.token = response.body()!!.access_token.toString()

            }

            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.i("error", t.message.toString())
            }

        })

    }


    fun setBorrados(num : Int){

        RestAPI.borrados4.add(num.toString())

    }

    fun getBorrados(): MutableList<String> {

        return RestAPI.borrados4
    }

    fun removeElementFourthDigit(num : Int){

        if(num>0&&num<=9) {
//            Log.i("response", (miLista4.getItemIdAtPosition(position) + 1).toString())
            datos4.set(num,"") //0009
            datos3.set(num,"") //009
            datos2.set(num,"") //09
            datos.set(num-1,"") //9

        }else if(num>9&&num<=99) {
            Log.i("response",num.toString())
            Log.i("response",num.toString().substring(1))
            datos4.set(num,"")
            datos3.set(num,"")
            datos2.set(num,"")
            datos.set(num.toString().substring(1).toInt()-1,"")


        }else if(num>99&&num<=999) { //aqui esta llegand 125 -> 25 -> 5 solo tres digitos
            Log.i("response",num.toString())
            Log.i("response",num.toString().substring(1))
            Log.i("response",num.toString().substring(2))
            Log.i("response",num.toString().substring(3))


            datos4.set(num-1,"")
            datos3.set(num-1,"")
            datos2.set(num.toString().substring(1).toInt()-1,"")
            datos.set(num.toString().substring(2).toInt()-1,"")
            Log.i("response", "aqui "+ num.toString().substring(2))
        }else if(num>999&&num<=9999) {
            Log.i("response",num.toString())
            Log.i("response",num.toString().substring(1))
            Log.i("response",num.toString().substring(2))
            Log.i("response",num.toString().substring(3))


            datos4.set(num-1,"")
            datos3.set(num.toString().substring(1).toInt()-1,"")
            datos2.set(num.toString().substring(2).toInt()-1,"")
            datos.set(num.toString().substring(3).toInt()-1,"")
        }


    }



    fun generateFourthDigit(){

        for (i in 1..9999) {
            if(i<10){
                datos4+="000"+i.toString()
            }else if(i<100){
                datos4+="00"+i.toString()
            }else if(i<1000){
                datos4+="0"+i.toString()
            }else{
                datos4+=i.toString()
            }
        }
    }

    fun generateDigit(){

        for (i in 1..9) {
            datos+=i.toString()
        }
    }

    fun generateTwoDigit(){

        for (i in 1..99) {
            if(i<10){
                datos2+="0"+i.toString()
            }else{
                datos2+=i.toString()

            }
        }
    }

    fun generateThreeDigit(){

        for (i in 1..999) {
            if(i<10){
                datos3+="00"+i.toString()
            }else if(i<100){
                datos3+="0"+i.toString()
            }else{
                datos3+=i.toString()
            }
        }
    }

}