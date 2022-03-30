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
        var borrados = mutableListOf<String>()
        var borrados2 = mutableListOf<String>()
        var borrados3 = mutableListOf<String>()
        var borrados4 = mutableListOf<String>()
        var premio = ""
        var debo = ""
        var cupo = ""
        var repolla = ""
        var ronda = ""
        var acumulado = ""

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

    fun getMasterCoinsAPI() : MasterServiceCoins{

        var masterServiceCoins = retrofit.create(MasterServiceCoins::class.java)

        return masterServiceCoins
    }

    fun setPostSendComprarUnoAPI(
        numero : Int,
        cifras : Int,
        telefono: String,
        cliente: String,
        id_repolla: String,
        ronda: String
    ){

        var setPostSendComprarUno = retrofit.create(PostSendComprarUno::class.java)

        var call = setPostSendComprarUno.setSendComprarUno(

            numero,
            cifras,
            telefono,
            cliente,
            id_repolla,
            ronda
        )

        call.enqueue(object : Callback<ResponseComprarUno>{
            override fun onResponse(
                call: Call<ResponseComprarUno>,
                response: Response<ResponseComprarUno>
            ) {
                Log.i("response", response.body().toString())
            }

            override fun onFailure(call: Call<ResponseComprarUno>, t: Throwable) {
                Log.i("error", t.toString())
            }

        })


    }

    fun setPostSendComprarUnoCoinAPI(
        numero : Int,
        cifras : Int,
        telefono: String,
        cliente: String,
        id_repolla: String,
        ronda: String
    ){

        var setPostSendComprarUnoCoin = retrofit.create(PostSendComprarUnoCoin::class.java)

        var call = setPostSendComprarUnoCoin.setSendComprarUno(

            numero,
            cifras,
            telefono,
            cliente,
            id_repolla,
            ronda
        )

        call.enqueue(object : Callback<ResponseComprarUno>{
            override fun onResponse(
                call: Call<ResponseComprarUno>,
                response: Response<ResponseComprarUno>
            ) {
                Log.i("response", response.body().toString())
            }

            override fun onFailure(call: Call<ResponseComprarUno>, t: Throwable) {
                Log.i("error", t.toString())
            }

        })


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

        RestAPI.borrados.add(num.toString())
    }

    fun getBorrados(): MutableList<String> {

        return RestAPI.borrados
    }

    fun setBorrados2(num : Int){

        RestAPI.borrados2.add(num.toString())
    }

    fun getBorrados2(): MutableList<String> {

        return RestAPI.borrados2
    }
    fun setBorrados3(num : Int){

        RestAPI.borrados3.add(num.toString())
    }

    fun getBorrados3(): MutableList<String> {

        return RestAPI.borrados3
    }
    fun setBorrados4(num : Int){

        RestAPI.borrados4.add(num.toString())
    }

    fun getBorrados4(): MutableList<String> {

        return RestAPI.borrados4
    }

    fun removeElementOneDigit(num : Int){

        if(num>=0&&num<=9) {
            datos.set(num,"")
            for(i in 0..9){
                var numStr = "${i}${num}".toInt()
                datos2.set(numStr, "")
            }
            for(i in 0..9){
                for(j in 0..9) {
                    var numStr = "${j}${i}${num}".toInt()
                    datos3.set(numStr, "")
                }
            }
            for(i in 0..9){
                    var numStr = "${0}${0}${i}${num}".toInt()
                    datos4.set(numStr,"")
            }
        }
    }

    fun removeElementTwoDigit(num : Int){

        if(num>=0&&num<=9) {
            datos.set(num,"")
            datos2.set(num,"")
            for(i in 0..9){
                 var numStr = "${i}${num}".toInt()
                    datos3.set(numStr,"")
            }
            for(i in 0..9){
                    var numStr = "${0}${i}${num}".toInt()
                    datos4.set(numStr,"")

            }
        }else if(num>9&&num<=99) {
            datos.set(num.toString().substring(1).toInt(),"")
            datos2.set(num,"")
            for(i in 0..9){
                 var numStr = "${i}${num}".toInt()
                    datos3.set(numStr,"")
            }
            for(i in 0..9){
                    var numStr = "${0}${i}${num}".toInt()
                    datos4.set(numStr,"")

            }
        }
    }

    fun removeElementThreeDigit(num : Int){

        if(num>=0&&num<=9) {

            datos.set(num,"")
            datos2.set(num,"")
            datos3.set(num,"")
            for(i in 0..9){
                Log.i("response", "${i}${0}${num}")
                var numStr = "${i}${0}${num}".toInt()
                datos4.set(numStr,"")

            }
        }else if(num>9&&num<=99) {
            datos.set(num.toString().substring(1).toInt(),"")
            datos2.set(num,"")
            datos3.set(num,"")
            for(i in 0..9){
                Log.i("response", "${i}${0}${num}")
                var numStr = "${i}${0}${num}".toInt()
                datos4.set(numStr,"")

            }
        }else if(num>99&&num<=999) {
            datos.set(num.toString().substring(2).toInt(),"")
            datos2.set(num.toString().substring(1).toInt(),"")
            datos3.set(num,"")
            for(i in 0..9){
                Log.i("response", "${i}${0}${num}")
                var numStr = "${i}${num}".toInt()
                datos4.set(numStr,"")

            }
        }
    }

    fun removeElementFourthDigit(num : Int){

        if(num>=0&&num<=9) {

            datos.set(num,"")
            datos2.set(num,"")
            datos3.set(num,"")
            datos4.set(num,"")

        }else if(num>9&&num<=99) {
            datos.set(num.toString().substring(1).toInt(),"")
            datos2.set(num,"")
            datos3.set(num,"")
            datos4.set(num,"")

        }else if(num>99&&num<=999) {
            datos.set(num.toString().substring(2).toInt(),"")
            datos2.set(num.toString().substring(1).toInt(),"")
            datos3.set(num,"")
            datos4.set(num,"")

        }else if(num>999&&num<=9999) {
            datos.set(num.toString().substring(3).toInt(),"")
            datos2.set(num.toString().substring(2).toInt(),"")
            datos3.set(num.toString().substring(1).toInt(),"")
            datos4.set(num,"")

        }
    }

    fun generateFourthDigit(){

        for (i in 0..9999) {
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

        for (i in 0..9) {
            datos+=i.toString()
        }
    }

    fun generateTwoDigit(){

        for (i in 0..99) {
            if(i<10){
                datos2+="0"+i.toString()
            }else{
                datos2+=i.toString()

            }
        }
    }

    fun generateThreeDigit(){

        for (i in 0..999) {
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